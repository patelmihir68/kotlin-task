import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class CoffeeMaker (private val heater: Heater, private val pump: Pump) {

    fun brew (){
        heater.on()
        pump.pump()
        println("Coffee's Ready! Enjoy")

    }
}
class Heater() {
    fun on (){

    }
    fun off(){

    }
    fun isHeating (){

    }
}
class Pump() {
    fun pump(){
        println("Pump started...")
    }
}
val myModule = module {
    factory { Heater() }
    factory { Pump() }
    factory { CoffeeMaker(get(), get()) }
}

class Main : KoinComponent {
    val coffeeMaker: CoffeeMaker by inject()
}

fun main(args: Array<String>) {
    startKoin { modules(listOf( myModule)) }
    val main = Main()
    main.coffeeMaker.brew();
}
