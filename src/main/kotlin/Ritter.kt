import kotlin.random.Random

class Warrior(name: String, hp: Int, actions: List<String>) : Hero(name, hp, actions, "Warrior") {
    override fun performAction(action: String, target: Character) {
        when (action) {
            "1" -> target.takeDamage(15 + Random.nextInt(3)) // Schwertangriff mit zufälligem Bonus
            "2" -> this.heal(10) // Verteidigung
            else -> super.performAction(action, target)
        }
    }
}