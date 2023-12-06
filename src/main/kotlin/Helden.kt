open class Hero(name: String, hp: Int, actions: List<String>, val heroType: String) : Character(name, hp,hp, actions) {
    open fun performAction(action: String, target: Character) {
        when (action) {
            "1" -> target.takeDamage(10) // Basisangriff
            "2" -> this.heal(15) // Selbstheilung
            else -> println("$name führt die Aktion $action aus")
        }
    }

}






