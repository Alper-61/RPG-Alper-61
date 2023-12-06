class Dragon(name: String) : Enemy(name, 300, listOf("fire breath", "tail swipe", "roar"), "Dragon") {
    private var roarUsed = false // Kontrol, "roar" aksiyonunun yalnızca bir kez kullanılmasını sağlar
    override fun performAction(action: String, targets: List<Hero>) {
        when (action) {
            "fire breath" -> {
                targets.forEach { it.takeDamage(20) } // Tüm kahramanlara hasar ver

            }
            "tail swipe" -> {
                val target = targets.random()
                target.takeDamage(30) // Rastgele bir kahramana büyük hasar ver

            }
            "roar" -> {
                if (!roarUsed) {
                    targets.forEach { it.takeDamage(10) } // Tüm kahramanlara hasar ver

                    roarUsed = true
                } else {

                }
            }
            else -> performAction(action, targets,)
        }
    }
}