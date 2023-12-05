class Dragon(name: String) : Enemy(name, 300, listOf("fire breath", "tail swipe", "roar"), "Dragon") {
    var roarUsed = false
    var darkWizardSummoned = false
    override fun performAction(action: String, targets: List<Hero>) {
        if (hp <= maxHp / 2 && !darkWizardSummoned) {
            // Boss hat weniger als die Hälfte seiner Lebenspunkte und hat den DarkWizard noch nicht beschworen
            .summonDarkWizard()
            darkWizardSummoned = true
        } else
        when (action) {
            "Unterboss beschwoeren" -> {

            }
            "fire breath" -> {
                targets.forEach { it.takeDamage(20) } // Tüm kahramanlara hasar ver
                println("$name setzt Fire Breathein ein und fügt jeden Gegner schaden hinzu.")
            }
            "tail swipe" -> {
                val target = targets.random()
                target.takeDamage(30) // Rastgele bir kahramana büyük hasar ver
                println("$name hat mit Tail Swipe ${target.name} sehr großen schaden gegeben.")
            }
            "roar" -> {
                if (!roarUsed) {
                    targets.forEach { it.takeDamage(10) } // Tüm kahramanlara hasar ver
                    println("$name hat mit einem Brüllen allen Helden Schaden zugefügt.")
                    roarUsed = true
                } else {
                    println("$name kann nicht mehr brüllen.")
                }
            }
            else -> performAction(action, targets,)
        }
    }
}


