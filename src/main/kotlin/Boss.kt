

class DemonLord(name: String, hp: Int): Enemy(name, hp, hp) {
    var attacDamage = 50
    var healAmount = 50
    var attacDamage2 = 100
    var feueratemDamage = 20

    override fun performAction(action: String, target: Hero) {
        when (action) {
            "Schwarzes Loch" ->{
                println("setzt Schwarzes Loch ein.")
                target.takeDamage(attacDamage)
            }
            "Feuerregen" ->{
                println(" setzt Feuerregen ein")
                target.takeDamage(attacDamage2)
            }
            "Fegefeuer" ->{
                println("setzt Fegefeuer ein")
                this.takeDamage(feueratemDamage)
            }
            "Dunkle Materie" ->{
                println("Heilt sich")
                this.heal(healAmount)
            }
            "Demonen Fluch"->{
                println("Setzt sein Fluch ein")
                target.fluch()
            }
            else -> super.performAction(action, target)
        }
    }
}
