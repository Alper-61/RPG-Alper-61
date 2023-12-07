class Diener(name: String,) : Enemy(name, 200, mutableListOf("fire breath", "curse","summon dark wizard"), "Dark Wizard",) {
    override fun performAction(action: String, targets: List<Hero>,battle: Battle) {
        when (action) {
            "fire breath" -> targets.forEach { it.takeDamage(20) } // Flächenschaden
            "curse" -> targets.random().takeDamage(10) // Fluch auf zufälligen Helden
            "summon dark wizard" -> {
                battle.summonDarkWizard()
                println("$name hat den Dark Wizard beschworen!")}
            else -> super.performAction(action, targets,battle)
        }
    }
}
