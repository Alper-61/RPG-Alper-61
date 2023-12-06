open class Battle(val heroes: List<Hero>, val enemies: List<Enemy>, val bag: Bag) {
    fun startBattle() {
        var round = 1
        while (heroes.any { it.isAlive() } && enemies.any { it.isAlive() }) {
            println("Round $round")
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
                val action = enemy.actions.random()
                enemy.performAction(action, heroes)
                println("$action ausgeführt von ${enemy.name}")
                println("-------------------------------")
            }

            round++
        }
        // Kampfergebnis
        if (heroes.any { it.isAlive() }) println("Helden gewinnen!") else println("Endgegner gewinnt!")
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
        DarkWizard("Dark Wizard"),
        Dragon("Dragon")
    )
    val battle = Battle(heroes, enemies, bag)
    battle.startBattle()
}