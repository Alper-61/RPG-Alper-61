
class DarkKnight(name: String, hp: Int): Enemy(name, hp, hp) {
    var attacDamage = 20
    var healAmount = 10
    var attacDamage2 = 40
    override fun performAction(action: String, target: Hero) {
        isProtected = false
        when (action) {
            "Felsenschlag" -> target.takeDamage(attacDamage)
            "Verwirrungsschrei"->target.takeDamage(attacDamage2)
            "Dunkle Materie" -> this.heal(healAmount)
            "Schattenrüstung"->{
                println("$name Schattenrüstung.")
                isProtected = true
            }
            else -> super.performAction(action, target)
        }
    }
}







