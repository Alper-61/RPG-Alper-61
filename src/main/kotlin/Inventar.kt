
class Inventar {
    // Inventar(beutel)
    // 3 Heiltränke
    var anzahlHeiltraenke: Int = 3
    // 1 Vitamin
    var anzahlVitamin: Int = 1

    // Heiltrank nutzungs Methode
    fun healItem(target: Hero){
        // schauen ob noch Heiltränke da sind
        if (anzahlHeiltraenke > 0) {
            // benutzen = ein Held bekommt 20% mehr HP 51 26 25
            target.heal((target.maxHp / 2).toInt())
            // benutzten Heiltrank wegschmeißen
            anzahlHeiltraenke--
        }
    }
    fun vitItem(target: Hero){
        // schauen ob noch Heiltränke da sind
        if (anzahlVitamin > 0) {
            // benutzen = ein Held bekommt 20% mehr HP
            target.increaseddamage(10)
            // benutzten Heiltrank wegschmeißen
            anzahlVitamin--
        }
    }
    fun isEmpty(): Boolean {
        if(anzahlVitamin==0&&anzahlHeiltraenke==0){
            return true
        }else{
            return false
        }
    }
    override fun toString(): String{
        return """
            1) Heltraenke (Anzahl $anzahlHeiltraenke)
            2) Vitamine: (Anzahl $anzahlVitamin)
        """.trimIndent()
    }
}