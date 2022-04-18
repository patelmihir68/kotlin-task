interface CleanPot {
    fun cleanPot()
}

abstract class Beverage {

    fun addHotWater() {
        println("Adding hot water")
    }

    fun addHotMilk() {
        println("Adding hot milk")
    }

    fun addSugar() {
        println("Adding sugar")
    }

    fun getMixture() {
        addHotWater()
        addHotMilk()
        addSugar()
    }

    abstract fun getBeverage()

    abstract fun addIngredients()
}

class Tea : Beverage(), CleanPot {

    override fun cleanPot() {
        println("Cleaning  pot")
    }

    override fun addIngredients() {
        println("Tea bag is added")
    }

    override fun getBeverage() {
        cleanPot()
        getMixture()
        addIngredients()
        println("Tea is Ready! Enjoy")
    }
}

class Coffee : Beverage(), CleanPot {

    override fun cleanPot() {
        println("Cleaning  pot")
    }

    override fun addIngredients() {
        println("Coffee bag is added")
    }
    
    override fun getBeverage() {
        cleanPot()
        getMixture()
        addIngredients()
        println("Coffee is Ready! Enjoy")
    }
}

fun main(args: Array<String>) {
    println("Want beverage? Enter 1 for Tea / 2 for Coffee!")
    println(args[0])
    if (args[0].equals("1")) {
        var baverage = Tea()
        baverage.getBeverage()
    }else if (args[0].equals("2")) {
        var baverage = Coffee()
        baverage.getBeverage()
    }else{
        println("Invalid Input")
    }
}
