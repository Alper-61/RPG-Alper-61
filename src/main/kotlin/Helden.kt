



open class Hero(val name: String, var hp: Int, val maxHp: Int, var isProtected: Boolean = false, var isVerflucht: Boolean = false)  {
    fun takeDamage(damage: Int) {
        if((hp-damage) <0){
            println("$name erleidet $damage Schaden. Verbleibende HP: $hp")
        }else{
            hp = (hp - damage)
            println("$name erleidet keinen Schaden wegen dem Schutzzauber")
        }
    }
    fun fluch(percent: Int = 10){
        var condition = (100/maxHp*hp)<=20
        if((100/maxHp*hp)>20){
            isVerflucht=true
            hp= (hp*0.9).toInt().coerceAtLeast((maxHp*0.2).toInt())
            println("$name wird verflucht.Verbleibende HP: $hp")
        }else{
            isVerflucht=false
        }
    }
    fun isAlive(): Boolean = hp > 0
    fun heal(amount: Int) {
        if ((hp+amount)>maxHp){
            hp = maxHp
            println("$name heilt sich um $amount. HP: $hp")
        }else{
            hp = (hp + amount)
        }

    }
    open fun performAction(action: String, target: Enemy) {

    }
    open fun getActionNames(): List<String>{
        return emptyList()
    }
    open fun increaseddamage(percent:Int){}
    override fun toString(): String{
        return """
            Name: $name
            HP: $hp
        """.trimIndent()
    }
}