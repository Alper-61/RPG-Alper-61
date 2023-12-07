class Dragon(name: String,) : Enemy(name, 300, listOf("fire breath", "tail swipe", "roar", "summon dark wizard"), "Dragon") {
    private var roarUsed = false // Kontrol, "roar" aksiyonunun yalnızca bir kez kullanılmasını sağlar
    var darkWizardSummoned = false
    val diener: Diener = Diener("Dark Wizard")
    override fun performAction(action: String, targets: List<Hero>,battle: Battle) {
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
                } else {println("$name daha fazla Roar kullanamaz.")

                }
            } else -> {(performAction(action, targets,battle))

            }

        }
    }
}

//class commander(name: String): Enemy(name, "Rote Allianz", 81,false){
//    fun schwertschlag(gegner: Enemy){
//        println("$name führ einen Schwertschlag aus mit einer Angriffskraft von $ap AP!")
//        println("${gegner.name} hat vorher ${gegner.hp} HP...")
//        println("$name's Angriff triggt ${gegner.name}!")
//        gegner.hp -= this.ap
//        println("${gegner.name} verliert $ap HP und hat noch ${gegner.hp} HP!")
//        // Abfangen, dass Gegner direkt stirbt:
//        if (gegner.hp <= 0){
//            println("${gegner.name} ist besiegt!")
//            gegner.isDead = true
//            // kommen hier aber nicht an Gegner Liste ran
//        }
//    }
//    fun schildsto0(gegner: Enemy){
//        ap=level* 4.0
//        println("$name führt einen Schildstoß mit einer Angriffskraft von $ap AP!")
//        println("${gegner.name} hat vorher ${gegner.hp} HP...")
//        println("$name's Angriff triggt ${gegner.name}!")
//        gegner.hp -= this.ap
//        println("${gegner.name} verliert $ap HP und hat noch ${gegner.hp} HP!")
//        // Abfangen, dass Gegner direkt stirbt:
//        if (gegner.hp <= 0){
//            println("${gegner.name} ist besiegt!")
//            gegner.isDead = true
//            // kommen hier aber nicht an Gegner Liste ran
//        }
//    }
//    fun donnernderHieb(gegner: Enemy){
//        ap=level* 6.0
//        println("$name Schildstoß mit einer Angriffskraft von $ap AP!")
//        println("${gegner.name} hat vorher ${gegner.hp} HP...")
//        println("$name's Angriff triggt ${gegner.name}!")
//        gegner.hp -= this.ap
//        println("${gegner.name} verliert $ap HP und hat noch ${gegner.hp} HP!")
//        // Abfangen, dass Gegner direkt stirbt:
//        if (gegner.hp <= 0){
//            println("${gegner.name} ist besiegt!")
//            gegner.isDead = true
//            // kommen hier aber nicht an Gegner Liste ran
//        }
//    }
//
//}
