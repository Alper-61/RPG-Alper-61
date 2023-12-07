open class Enemy(name: String, hp: Int, actions: MutableList<String>, val enemyType: String,) : Character(name, hp, hp, actions) {
    open fun performAction(action: String, targets: List<Hero>, battle: Battle) {
        println("$name führt die Aktion $action aus")

    }


}
//open class Enemy(var name: String, var allianz: String, var level: Int = 1, var isDead: Boolean = false) {
//
//    var hp: Double // Health Points = Lebenspunkte
//    var ep: Double // Experience Points
//    var ap: Double // Attack Points
//
//    // init Block: da der Primäre Konstruktor keinen eigenen Körper hat (der Körper ist ja einfach die gesamte Klasse), brauchen wir den init Block. Der wird, wie die Körper der sekundären Konstruktoren, immer beim Initialisieren = Erstellen eines konkreten Pokemons aufgerufen
//    init {
//        this.hp = 90.0
//        this.ep = 0.0
//        this.ap = level * 30.0
//
////        println("----Primärer Konstruktor Call im init-Block----")
////        println("Pokemon $name wurde auf Level $level initialisiert.")
////        //Thread.sleep(500)
////        println("$name hat $ap AP und folgende Attacken:")
////        // Thread.sleep(500)
////        println("Tackle (${level + ap} Schaden)")
////        // Thread.sleep(500)
////        println("--Primäre Konstruktion beendet--")
//
//    }
//
//
//    // sekundärer Konstruktor: Pokemon ist automatisch vom Typ Normal
//    constructor(name: String) : this(name, "Rote Allianz") {
////        println("---Sekundärer Konstruktor Call---")
////        // Thread.sleep(500)
////        println("Ein Pokemon namens $name mit Default den Typ 'Normal' wurde angelegt.")
////        // Thread.sleep(500)
////        println("---Sekundäre Konstruktion beendet---")
//    }
//}
