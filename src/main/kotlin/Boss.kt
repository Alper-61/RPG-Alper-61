

class DemonLord(name: String, hp: Int): Enemy(name, hp, hp) {
    var attacDamage = 50
    var healAmount = 50
    var attacDamage2 = 100
    var feueratemDamage = 20

    override fun performAction(action: String, target: Hero) {
        when (action) {
            "Schwarzes Loch" ->{
                println("$name setzt Schwarzes Loch ein.")
                target.takeDamage(attacDamage)
            }
            "Feuerregen" ->{
                println("$name setzt Feuerregen ein")
                target.takeDamage(attacDamage2)
            }
            "Fegefeuer" ->{
                println("$name setzt Fegefeuer ein Flächenschaden an :")
                target.takeDamage(feueratemDamage)
            }
            "Dunkle Materie" ->{

                this.heal(healAmount)
            }
            "Demonen Fluch"->{
                println("$name setzt ein Fluch ein")
                target.fluch()
            }
            else -> super.performAction(action, target)
        }
    }
}
