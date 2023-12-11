
fun main() {
    // Helden
    val mage = Mage("Merlin", 100)
    val jaeger = Jaeger("Klein", 100)
    val paladin = Paladin("Kirito",100)
    // Team an Helden
    val helden: MutableList<Hero> = mutableListOf(mage,jaeger,paladin)
    // Gegner
    val demonLord = DemonLord("Drache",600)
    val enemyListe: MutableList<Enemy> = mutableListOf(demonLord)
    spielRunde(helden, enemyListe)
}
fun spielRunde(helden: MutableList<Hero>, enemyListe: MutableList<Enemy>) {
    var gameOver: Boolean = false
    // Rundencounter
    var round: Int = 1
    val inventar = Inventar()
    var hasSommoned = false
    while (!gameOver){
        println("---Runde $round!---")
        println("--Unser Team:--")
        // print alle helden in meinem team und ihre aktionen --> ueber liste der helden iterieren
        var livingheroes = helden.filter { it.isAlive() }.toMutableList()
        livingheroes.forEach { println(it) }
        // print alle gegner --> ueber liste der gegner iterieren
        println("--Gegner Team:--")
        var livingenemys = enemyListe.filter { it.isAlive()}.toMutableList() // nur lebende Gegner werden rausgefiltert
        livingenemys.forEach { println(it) }
        livingenemys = aktionenHelden(livingheroes, livingenemys,inventar)
        if (!hasSommoned){
            if ((1..2).random()==1){
                sommonedKnight( enemyListe)
                hasSommoned=true
            }else{
                livingheroes = aktionenGegner(livingenemys, livingheroes)
                livingheroes = helden.filter { it.isAlive() }.toMutableList()
            }
        }else {
            livingheroes = aktionenGegner(livingenemys, livingheroes)
            livingheroes = helden.filter { it.isAlive() }.toMutableList()
        }
        println("Runde $round beendet!")
        println("ggf. Status von allen ausdrucken...")
        gameOver = gameOver(livingheroes, livingenemys, gameOver)
        round++
    }
    println("Spiel beendet!") // Logik: helden oder gegner tot?
}
private fun sommonedKnight(enemyListe: MutableList<Enemy>) {
        println("Der Drache beschwort einen Babydrachen")
    enemyListe.add(BabyDrache("Babydrache",150))
}
private fun gameOver(helden: MutableList<Hero>, lebendeEnemy: MutableList<Enemy>, gameOver: Boolean): Boolean {
    var gameOver1 = gameOver
    if (helden.isEmpty()) {
        println("Unsere Helden haben versagt... Game Over :(")
        gameOver1 = true
    } else if (lebendeEnemy.isEmpty()){
        println("Geschafft! Unsere Helden haben gewonnen! Game Over :) ")
        gameOver1 = true
    }
    return gameOver1
}
//fertig
private fun aktionenHelden(heroes: MutableList<Hero>, livingEnemy: MutableList<Enemy>, inventar: Inventar): MutableList<Enemy> {
    var livingEnemy1 = livingEnemy
    var inputValid = false
    var inventarUsed = false
    for (hero in heroes) {
        if (livingEnemy1.isEmpty()){
            return livingEnemy1
        }
        inputValid = false
        var chooseAcOrIn = 1
        if(!inventarUsed){
            println("Druecke 1 um eine Aktion auszuwaehlen oder 2  um dem Beutel zu nutzen  ")
            chooseAcOrIn = readln().toInt()
        }
        if (chooseAcOrIn==2){
            if (!inventar.isEmpty()){
                println("Bitte waehle dir etwas von dem Beutel aus")
                println(inventar)
                var inventarChoose = readln().toInt()
                if(inventarChoose==1){
                    inventar.healItem(hero)
                }else{
                    inventar.vitItem(hero)
                }
                inventarUsed=true
            }
        }else{
            println("${hero.name} greift an. Wähle die Attacke per Zahleneingabe aus!")
            while (!inputValid){
                var heroActions = hero.getActionNames()
                for ( i in heroActions.indices){
                    println("${i + 1} ${heroActions[i]}")
                }
                val choice = readln().toInt()
                if (choice > 0 && choice <= (heroActions.size)){
                    hero.performAction(heroActions[choice-1], livingEnemy1.last())
                    inputValid = true
                }else{
                    println("Falsche Zahl, gib eine gültige Zahl ein!")
                }
            }
        }
    }
    return livingEnemy1
}
private fun aktionenGegner(enemy: MutableList<Enemy>, livingHeros: MutableList<Hero>, ): MutableList<Hero> {
    var livingHero1 = livingHeros
    var inputValid = false
    for (hero in livingHeros){
        if (hero.isVerflucht){
            hero.fluch()
        }
    }
    for (h in enemy) {
        if (livingHero1.isEmpty()){
            return livingHero1
        }
        inputValid = false
        println("${h.name} greift an.")
        while (!inputValid){
            if (h is DemonLord){
                val choice = (1..5).random()
                if (choice==1){
                    h.performAction("Feuer Ball",livingHero1.first())
                }else if(choice==2){
                    h.performAction("Fluegelschlag",livingHero1.first())
                }else if(choice==3){
                    for (held in livingHeros){
                        h.performAction("Feueratem",held)
                    }
                }else if(choice==4){
                    h.performAction("Heilender Feuer Stein",livingHero1.first())
                }else if(choice==5){
                    h.performAction("Fluch",livingHero1.random())
                }
                inputValid = true
            }else{
                val choice = (1..4).random()
                if (choice==1){
                    h.performAction("Babyschrei",livingHero1.first())
                }else if(choice==2){
                    h.performAction("Babypups",livingHero1.first())
                }else if(choice==3){
                    for (held in livingHeros){
                        h.performAction("Drachenmilch",held)
                    }
                }else if(choice==4){
                    h.performAction("Fluegelschutz",livingHero1.first())
                }
                inputValid = true
            }
        }
    }
    return livingHeros
}