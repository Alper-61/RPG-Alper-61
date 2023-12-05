class DarkWizard(name: String) : Enemy(name, 200, listOf("fire breath", "curse",), "Dark Wizard") {
    override fun performAction(action: String, targets: List<Hero>) {
        when (action) {
            "fire breath" -> targets.forEach { it.takeDamage(20) } // Flächenschaden
            "curse" -> targets.random().takeDamage(10) // Fluch auf zufälligen Helden
            else -> super.performAction(action, targets)
        }
    }
}