open class Battle( val heroes: List<Hero>, val enemies: List<Enemy>, val bag: Bag) {

    fun rufeHelfer(round: Int, gegnerListe: MutableList<Enemy>)  {
        if (round == 1) {
            println("Der DemonenLord beschwört sich in der $round. Runde einen Diener dazu.....")
            gegnerListe.add(Enemy("Schwarzer Ritter wir beschworen von ", 80, mutableListOf("Schwarzesloch", "dunkle Sense",
                "Blitz"),"DemonenLord Diener"))
        }
    }
    fun startBattle() {
        var round = 1
        var





        while (heroes.any { it.isAlive() } && enemies.any { it.isAlive() }) {
            println("Round $round")
            rufeHelfer(round, gegnerListe)
            // Heldenaktionen
            heroes.forEach { hero ->
                println("Aktion für ${hero.name} wählen:\n" + "1 -> ${hero.actions} \n" + "2 -> heal\n" + "3 -> Inventar"
                )
                val action = readln()
                if (action == "3") {
                    println("Welchen Gegenstand verwenden?\n"+"Healing Potion\n"+"Vitamins")
                    val item = readln()
                    bag.useItem(item, hero)
                } else {
                    val target = enemies.random() // Ziel für Angriffe
                    hero.performAction(action, target)
                }
                println("---------------------------")
            }
            // Gegneraktionen
            enemies.forEach { enemy ->
                val aktion = enemy.actions.random()
                enemy.performAction(aktion, heroes,this)
                println("$aktion ausgeführt von ${enemy.name}")
                println("-------------------------------")
            }

            round++
        }
        // Kampfergebnis
        if (heroes.any { it.isAlive() }) println("Helden gewinnen!") else println("Endgegner gewinnt!")
    }
    fun summonDarkWizard() {
        enemies.filter { it is Dragon }.forEach { it.performAction("summon dark wizard", heroes,this) }
    }
}
// Hauptfunktion
fun main() {
    val bag = Bag()

    val heroes = listOf(
        Mage("Mage", 100, listOf("fireball", "heal")),
        Warrior("Warrior", 150, listOf("sword attack", "defend")),
        Archer("Archer", 80, listOf("poison arrow", "multi shot"))
    )
    val enemies = listOf(
        Diener("Dark Wizard"),
        Dragon("Dragon")
    )
    val battle = Battle(heroes, enemies, bag)
    battle.startBattle()
}