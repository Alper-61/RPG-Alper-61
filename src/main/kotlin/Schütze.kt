
import kotlin.random.Random
class Jaeger(name: String, hp: Int): Hero(name, hp, hp) {
    var actionDamage = 40
    var healAmount = 20
    var actionDamage2 = 100
    override fun performAction(action: String, target: Enemy) {
        isProtected = false
        when (action) {
            "Bogen Attacke" -> target.takeDamage(actionDamage + Random.nextInt(50))
            "Wurf Schleuder" ->{
                target.takeDamage(500)
                target.takeDamage(actionDamage2)
            }
            "Schlafen" -> this.heal(healAmount)
            "Schutz Mantel"->{
                println("$name nutzt den Schutz Mantel.")
                isProtected = true
            }
            else -> super.performAction(action, target)
        }
    }
    override fun getActionNames(): List<String> {
        return listOf("Bogen Attacke","Wurf Schleuder","Schlafen","Schutz Mantel")
    }
    override fun increaseddamage(percent:Int){
        actionDamage += (actionDamage/100*percent).toInt()
    }
}