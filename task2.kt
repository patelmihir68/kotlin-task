import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

interface Heater {
    fun on ()
    fun off ()
    fun isHeating (): Boolean
}

interface Pump {
    fun pump ()
}

class CoffeeMaker (private val heater: Heater, private val pump: Pump) {
    fun brew (type : String){
        heater.on()
        if (heater.isHeating()){
            pump.pump()
            println( "$type coffee's Ready! Enjoy")
        }else{
            println("Heater is not started...")
        }
    }
}

class ElectricHeater() : Heater {
    var isHeaterStarted = false
    override fun on () {
        println("Heater started..")
        isHeaterStarted = true
    }
    override fun off() {
        println("Heater off..")
        isHeaterStarted = false
    }
    override fun isHeating (): Boolean {
        return isHeaterStarted
    }
}

class PumpOne() : Pump {
    override fun pump(){
        println("Pump started...")
    }
}

val myModule = module {
    factory { ElectricHeater() as Heater }
    factory { PumpOne() as Pump }
    factory { CoffeeMaker(get(), get()) }
}

class Main : KoinComponent {
    val coffeeMaker: CoffeeMaker by inject()
}

fun main(args: Array<String>) {
    val type = args[0]
    startKoin { modules(listOf( myModule)) }
    val main = Main()
    main.coffeeMaker.brew(type);
}
