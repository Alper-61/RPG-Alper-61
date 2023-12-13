fun main() {
    // Helden
    val mage = Mage("Merlin", 200)
    val jaeger = Jaeger("Klein", 200)
    val paladin = Paladin("Kirito",200)
    // Team an Helden
    val helden: MutableList<Hero> = mutableListOf(mage,jaeger,paladin)
    // Gegner
    val demonLord = DemonLord("DemonenLord Varvatos",600)

    val enemyListe: MutableList<Enemy> = mutableListOf(demonLord)

    spielRunde(helden, enemyListe)
}
fun spielRunde(helden: MutableList<Hero>, enemyListe: MutableList<Enemy>) {
    var gameOver: Boolean = false
    // Rundencounter
    var round: Int = 1
    val inventar = Inventar()
    var hasSommoned = false
    println("#  \$\$\\      \$\$\\ \$\$\\ \$\$\\ \$\$\\ \$\$\\                                                                 \n" +
            "#  \$\$ | \$\\  \$\$ |\\__|\$\$ |\$\$ |\$\$ |                                                                \n" +
            "#  \$\$ |\$\$\$\\ \$\$ |\$\$\\ \$\$ |\$\$ |\$\$ |  \$\$\\  \$\$\$\$\$\$\\  \$\$\$\$\$\$\\\$\$\$\$\\  \$\$\$\$\$\$\\\$\$\$\$\\   \$\$\$\$\$\$\\  \$\$\$\$\$\$\$\\  \n" +
            "#  \$\$ \$\$ \$\$\\\$\$ |\$\$ |\$\$ |\$\$ |\$\$ | \$\$  |\$\$  __\$\$\\ \$\$  _\$\$  _\$\$\\ \$\$  _\$\$  _\$\$\\ \$\$  __\$\$\\ \$\$  __\$\$\\ \n" +
            "#  \$\$\$\$  _\$\$\$\$ |\$\$ |\$\$ |\$\$ |\$\$\$\$\$\$  / \$\$ /  \$\$ |\$\$ / \$\$ / \$\$ |\$\$ / \$\$ / \$\$ |\$\$\$\$\$\$\$\$ |\$\$ |  \$\$ |\n" +
            "#  \$\$\$  / \\\$\$\$ |\$\$ |\$\$ |\$\$ |\$\$  _\$\$<  \$\$ |  \$\$ |\$\$ | \$\$ | \$\$ |\$\$ | \$\$ | \$\$ |\$\$   ____|\$\$ |  \$\$ |\n" +
            "#  \$\$  /   \\\$\$ |\$\$ |\$\$ |\$\$ |\$\$ | \\\$\$\\ \\\$\$\$\$\$\$  |\$\$ | \$\$ | \$\$ |\$\$ | \$\$ | \$\$ |\\\$\$\$\$\$\$\$\\ \$\$ |  \$\$ |\n" +
            "#  \\__/     \\__|\\__|\\__|\\__|\\__|  \\__| \\______/ \\__| \\__| \\__|\\__| \\__| \\__| \\_______|\\__|  \\__|\n" +
            "#                                                                                               \n" +
            "#                                                                                               \n" +
            "#                                                                                               ")
    Thread.sleep(1500)

    while (!gameOver){
        println("\u001B[97m----Runde $round!----\u001B[0m")
        Thread.sleep(1000)
        println("\u001b[94m----Helden Team:----\u001B[0m")
        // print alle helden in meinem team und ihre aktionen --> ueber liste der helden iterieren
        var livingheroes = helden.filter { it.isAlive() }.toMutableList()
        livingheroes.forEach { println(it) }
        // print alle gegner --> ueber liste der gegner iterieren
        println("\u001b[91m----Team des DemonenLords :---\u001B[0m")
        var livingenemys = enemyListe.filter { it.isAlive()}.toMutableList() // nur lebende Gegner werden rausgefiltert
        livingenemys.forEach { println(it) }
        livingenemys = actionHeroes(livingheroes, livingenemys,inventar)
        if (!hasSommoned){
            if ((1..3).random()==2){
                sommonedKnight( enemyListe)
                hasSommoned=true
            }else{
                livingheroes = actionEnemys(livingenemys, livingheroes,)
                livingheroes = helden.filter { it.isAlive() }.toMutableList()
            }
        }else {
            livingheroes = actionEnemys(livingenemys,livingheroes)
            livingheroes = helden.filter { it.isAlive() }.toMutableList()
        }
        println("Runde $round beendet!")

            gameOver = gameOver(livingheroes, livingenemys, gameOver)

        round++

    }
    println("Spiel beendet!") // Logik: helden oder gegner tot?
}
private fun sommonedKnight(enemyListe: MutableList<Enemy>) {
        println("Der DemonenLord Varvatos beschwört seinen Helfer Darkknight")
    enemyListe.add(DarkKnight("Darkknight",250))
}
private fun gameOver(helden: MutableList<Hero>, lebendeEnemy: MutableList<Enemy>, gameOver: Boolean): Boolean {
    var gameOver1 = gameOver
    if (helden.isEmpty()) {
        println("\u001B[35mDie Helden haben versagt, alle Helden sind Tot... Game Over :(\u001B[0m")
        println("#   \$\$\$\$\$\$\\                                           \$\$\$\$\$\$\\                                 \n" +
                "#  \$\$  __\$\$\\                                         \$\$  __\$\$\\                                \n" +
                "#  \$\$ /  \\__| \$\$\$\$\$\$\\  \$\$\$\$\$\$\\\$\$\$\$\\   \$\$\$\$\$\$\\        \$\$ /  \$\$ |\$\$\\    \$\$\\  \$\$\$\$\$\$\\   \$\$\$\$\$\$\\  \n" +
                "#  \$\$ |\$\$\$\$\\  \\____\$\$\\ \$\$  _\$\$  _\$\$\\ \$\$  __\$\$\\       \$\$ |  \$\$ |\\\$\$\\  \$\$  |\$\$  __\$\$\\ \$\$  __\$\$\\ \n" +
                "#  \$\$ |\\_\$\$ | \$\$\$\$\$\$\$ |\$\$ / \$\$ / \$\$ |\$\$\$\$\$\$\$\$ |      \$\$ |  \$\$ | \\\$\$\\\$\$  / \$\$\$\$\$\$\$\$ |\$\$ |  \\__|\n" +
                "#  \$\$ |  \$\$ |\$\$  __\$\$ |\$\$ | \$\$ | \$\$ |\$\$   ____|      \$\$ |  \$\$ |  \\\$\$\$  /  \$\$   ____|\$\$ |      \n" +
                "#  \\\$\$\$\$\$\$  |\\\$\$\$\$\$\$\$ |\$\$ | \$\$ | \$\$ |\\\$\$\$\$\$\$\$\\        \$\$\$\$\$\$  |   \\\$  /   \\\$\$\$\$\$\$\$\\ \$\$ |      \n" +
                "#   \\______/  \\_______|\\__| \\__| \\__| \\_______|       \\______/     \\_/     \\_______|\\__|      \n" +
                "#                                                                                             \n" +
                "#                                                                                             \n" +
                "#                                                                                             ")
        gameOver1 = true
    } else if (lebendeEnemy.isEmpty()){
        println("\u001B[35mGeschafft! Sieg and die Helden, die Bösen wurden besiegt! Congratulations :\u001B[0m) ")
        println("#   \$\$\$\$\$\$\\                                           \$\$\$\$\$\$\\                                 \n" +
                "#  \$\$  __\$\$\\                                         \$\$  __\$\$\\                                \n" +
                "#  \$\$ /  \\__| \$\$\$\$\$\$\\  \$\$\$\$\$\$\\\$\$\$\$\\   \$\$\$\$\$\$\\        \$\$ /  \$\$ |\$\$\\    \$\$\\  \$\$\$\$\$\$\\   \$\$\$\$\$\$\\  \n" +
                "#  \$\$ |\$\$\$\$\\  \\____\$\$\\ \$\$  _\$\$  _\$\$\\ \$\$  __\$\$\\       \$\$ |  \$\$ |\\\$\$\\  \$\$  |\$\$  __\$\$\\ \$\$  __\$\$\\ \n" +
                "#  \$\$ |\\_\$\$ | \$\$\$\$\$\$\$ |\$\$ / \$\$ / \$\$ |\$\$\$\$\$\$\$\$ |      \$\$ |  \$\$ | \\\$\$\\\$\$  / \$\$\$\$\$\$\$\$ |\$\$ |  \\__|\n" +
                "#  \$\$ |  \$\$ |\$\$  __\$\$ |\$\$ | \$\$ | \$\$ |\$\$   ____|      \$\$ |  \$\$ |  \\\$\$\$  /  \$\$   ____|\$\$ |      \n" +
                "#  \\\$\$\$\$\$\$  |\\\$\$\$\$\$\$\$ |\$\$ | \$\$ | \$\$ |\\\$\$\$\$\$\$\$\\        \$\$\$\$\$\$  |   \\\$  /   \\\$\$\$\$\$\$\$\\ \$\$ |      \n" +
                "#   \\______/  \\_______|\\__| \\__| \\__| \\_______|       \\______/     \\_/     \\_______|\\__|      \n" +
                "#                                                                                             \n" +
                "#                                                                                             \n" +
                "#                                                                                             ")

        gameOver1 = true
    }
    return gameOver1
}
//fertig
private fun actionHeroes(heroes: MutableList<Hero>, livingEnemy: MutableList<Enemy>, inventar: Inventar): MutableList<Enemy> {
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
            println("Druecke 1 um eine Aktion auszuwaehlen oder 2 um das Inventar zu öffnen  ")
            chooseAcOrIn = readln().toInt()
        }
        if (chooseAcOrIn==2){
            if (!inventar.isEmpty()){
                println("Bitte waehle dir etwas aus dem Inventar aus")
                println(inventar)
                var inventarChoose = readln().toInt()
                if(inventarChoose==1){
                    inventar.healItem(hero)
                }else{
                    inventar.boostVitality(hero)
                }
                inventarUsed=true
            }
        }else{
            println("${hero.name} greift an. Wähle die Aktion per Zahleneingabe aus!")
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
                    println("Falsche Zahl, gib bitte eine gültige Zahl ein!")
                }
            }
        }
    }
    return livingEnemy1
}
private fun actionEnemys(enemy: MutableList<Enemy>, livingHeros: MutableList<Hero>, ): MutableList<Hero> {
    var livingHero1 = livingHeros
    var inputValid = false
    for (hero in livingHeros){
        if (hero.isVerflucht){
            println("Ist verflucht worden")
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
                    h.performAction("Schwarzes Loch",livingHero1.first())
                }else if(choice==2){
                    h.performAction("Feuerregen",livingHero1.first())
                }else if(choice==3){
                    for (held in livingHeros){
                        h.performAction("Fegefeuer",held)
                    }
                }else if(choice==4){
                    h.performAction("Dunkle Materie",livingHero1.first())
                }else if(choice==5){
                    h.performAction("Demonen Fluch",livingHero1.random())
                }
                inputValid = true
            }else{
                val choice = (1..4).random()
                if (choice==1){
                    h.performAction("Felsenschlag",livingHero1.first())
                }else if(choice==2){
                    h.performAction("Verwirrungsschrei",livingHero1.first())
                }else if(choice==3){
                    for (held in livingHeros){
                        h.performAction("Dunkle Materie",held)
                    }
                }else if(choice==4){
                    h.performAction("Schattenrüstung",livingHero1.first())
                }
                inputValid = true
            }
        }
    }
    return livingHeros
}