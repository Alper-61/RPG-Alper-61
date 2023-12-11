

class DemonLord(name: String, hp: Int): Enemy(name, hp, hp) {
    var attacDamage = 50
    var healAmount = 50
    var attacDamage2 = 100
    var feueratemDamage = 20

    override fun performAction(action: String, target: Hero) {
        when (action) {
            "Feuer Ball" ->{
                println("")
                target.takeDamage(attacDamage)
            }
            "Fluegelschlag" ->{
                println("")
                target.takeDamage(attacDamage2)
            }
            "Feueratem" ->{
                println("")
                this.takeDamage(feueratemDamage)
            }
            "Heilender Feuer Stein" ->{
                println("")
                this.heal(healAmount)
            }
            "Fluch"->{
                println("")
                target.fluch()
            }
            else -> super.performAction(action, target)
        }
    }
}
