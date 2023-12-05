import kotlin.random.Random


class Mage(name: String, hp: Int, actions: List<String>) : Hero(name, hp, actions, "Mage") {
    override fun performAction(action: String, target: Character) {
        when (action) {
            "1" -> target.takeDamage(20 + Random.nextInt(5)) // Feuerball mit zufälligem Bonus
            "2" -> this.heal(20) // Heilung
            else -> super.performAction(action, target)
        }
    }
}