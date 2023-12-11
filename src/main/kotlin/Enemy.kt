//open class Enemy(name: String, hp: Int, actions: MutableList<String>, val enemyType: String,) : Character(name, hp, hp, actions, ) {
//    open fun performAction(round: Int,action: String, targets: MutableList<Hero>, battle: Battle, ) {
//
//    }
//
//
//}
open class Enemy(val name: String, var hp: Int, val maxHp: Int, var isProtected: Boolean = false)  {
    fun takeDamage(damage: Int) {
        if(!isProtected){
            hp = (hp - damage).coerceAtLeast(0)
            println("$name erleidet $damage Schaden. Verbleibende HP: $hp")
        }else{
            println("$name erleidet keinen Schaden wegen dem Schutz")
        }
    }
    fun isAlive(): Boolean = hp > 0
    fun heal(amount: Int) {
        hp = (hp + amount).coerceAtMost(maxHp)
        println("$name heilt sich um $amount. HP: $hp")
    }
    open fun performAction(action: String, target: Hero) {
        when (action) {
            "attack" -> target.takeDamage(10) // Basisangriff
            "heal" -> this.heal(15) // Selbstheilung
            else -> println("Diese Action gibt es nicht")
        }
    }
    open fun getActionNames(): List<String>{
        return emptyList()
    }
    override fun toString(): String{
        return """
            Name: $name
            HP: $hp
        """.trimIndent()
    }
}

