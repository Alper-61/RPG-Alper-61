
import kotlin.random.Random
class Jaeger(name: String, hp: Int): Hero(name, hp, hp) {
    var actionDamage = 40
    var healAmount = 20

    override fun performAction(action: String, target: Enemy) {
        isProtected = false
        when (action) {
            "Bogenschuss" -> target.takeDamage(actionDamage + Random.nextInt(50))
            "Mehrfachschuss" ->{
                target.takeDamage(200)
            }
            "HP Trank" -> this.heal(healAmount)
            "Ultraschild"->{
                println("$name nutzt den Ultraschild.")
                isProtected = true
            }
            else -> super.performAction(action, target)
        }
    }
    override fun getActionNames(): List<String> {
        return listOf("Bogenschuss","Mehrfachschuss","Hp Trank","Ultraschild")
    }
    override fun increaseVitality(percent:Int){
        actionDamage += (actionDamage/100*percent).toInt()
    }
}