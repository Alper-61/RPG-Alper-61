import kotlin.random.Random

class Archer(name: String, hp: Int, actions: List<String>) : Hero(name, hp, actions, "Archer") {
    override fun performAction(action: String, target: Character) {
        when (action) {
            "1"-> target.takeDamage(12 + Random.nextInt(4)) // Giftiger Pfeil mit zufälligem Bonus
            "2" -> target.takeDamage(10) // Mehrfachschuss
            else -> super.performAction(action, target)
        }
    }
}