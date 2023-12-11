
class Paladin(name: String, hp: Int): Hero(name, hp, hp) {
    var actionDamage = 70
    var healAmount = 10
    var actionDamage2 = 100
    override fun performAction(action: String, target: Enemy) {
        isProtected = false
        when (action) {
            "Schwert Attacke" -> target.takeDamage(actionDamage)
            "In rage" ->{
                target.takeDamage(500)
                target.takeDamage(actionDamage2)
            }
            "Elexier" -> this.heal(healAmount)
            "Schutzpanzer"->{
                println("$name nutzt den Schutzpanzer.")
                isProtected = true
            }
            else -> super.performAction(action, target)
        }
    }
    override fun getActionNames(): List<String> {
        return listOf("Schwert Attacke","In rage","Elexier","Schutzpanzer")
    }
    override fun increaseddamage(percent:Int){
        actionDamage += (actionDamage/100*percent).toInt()
    }
}