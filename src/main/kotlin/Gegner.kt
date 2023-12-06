open class Enemy(name: String, hp: Int, actions: List<String>, val enemyType: String) : Character(name, hp, hp, actions) {
    open fun performAction(action: String, targets: List<Hero>,) {
        println("$name führt die Aktion $action aus")
    }

}