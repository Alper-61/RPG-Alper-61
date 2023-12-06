class Bag {
    val items = mutableMapOf("Healing Potion" to 3, "Vitamins" to 1)
    fun useItem(itemName: String, hero: Hero) {
        if (items[itemName] ?: 0 > 0) {
            when (itemName) {
                "Healing Potion" -> {
                    hero.heal(hero.maxHp / 3)
                    items[itemName] = items[itemName]!! - 1
                }
                "Vitamins" -> {
                    // Implementiere die Logik für Vitamine
                    hero.heal(hero.maxHp / 1)
                    items[itemName] = items[itemName]!! - 1
                }
            }
        }
    }
}