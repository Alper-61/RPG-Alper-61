
open class Enemy(val name: String, var hp: Int, val maxHp: Int, var isProtected: Boolean = false)  {
    fun takeDamage(damage: Int) {
        if(!isProtected){
            hp = (hp - damage).coerceAtLeast(0)
            println("$name erleidet $damage Schaden. Verbleibende HP: $hp")
        }else{
            println("$name erleidet keinen Schaden durch seinen Schutzzauber.")
        }
    }
    fun isAlive(): Boolean = hp > 0
    fun heal(amount: Int) {
        hp = (hp + amount).coerceAtMost(maxHp)// .coercetAtMost info von chatgpt für einen begrenzten wert
        println("$name heilt sich um $amount. HP: $hp")
    }
    open fun performAction(action: String, target: Hero) {


    }

    override fun toString(): String{
        return """
            Name: $name
            HP: $hp
        """.trimIndent()
    }
}

