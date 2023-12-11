
class Paladin(name: String, hp: Int): Hero(name, hp, hp) {
    var actionDamage = 70
    var healAmount = 10

    override fun performAction(action: String, target: Enemy) {
        isProtected = false
        when (action) {
            "Schwert Angriff" -> target.takeDamage(actionDamage)
            "Heiliges Licht" ->{
                target.takeDamage(500)

            }
            "Elexier" -> this.heal(healAmount)
            "Schildverteidigung"->{
                println("$name nutzt den Schildverteidigung.")
                isProtected = true
            }
            else -> super.performAction(action, target)
        }
    }
    override fun getActionNames(): List<String> {
        return listOf("Schwert Angriff","Heiliges Licht","Elexier","Schildverteidigung")
    }
    override fun increaseddamage(percent:Int){
        actionDamage += (actionDamage/100*percent).toInt()
    }
}