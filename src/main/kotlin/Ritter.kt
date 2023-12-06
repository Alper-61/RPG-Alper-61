import kotlin.random.Random

class Warrior(name: String, hp: Int, actions: List<String>) : Hero(name, hp, actions, "Warrior") {
    override fun performAction(action: String, target: Character) {
        when (action) {
            action -> target.takeDamage(15 + Random.nextInt(3)) // Schwertangriff mit zufälligem Bonus
            action -> this.heal(10) // Verteidigung
            else -> super.performAction(action, target)
        }
    }
}