//main.kt
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import Car as Car




fun main () {
    val numberOfCar = 1
    val time  = measureTimeMillis {
        buildNewCar(numberOfCar)
    }
    var car = Car()
    println("Time taken to build single car ${car.timeForSingleCar}")
    println("Total time taken to build ($numberOfCar) cars is  ${time }. ")
}

fun buildNewCar(numberOfCar : Int ) = runBlocking {
        repeat(numberOfCar) { // launch a lot of coroutines
            launch {
                var car = Car()
                car.build(it+1)
            }
        }
}



//car.kt

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class Car {
    var timeForSingleCar  : Long = 100;
    fun build(carNumber : Int) =  runBlocking { // this: CoroutineScope
            launch { // launch a new coroutine and continue
                val time  = measureTimeMillis {
                    buildBody(carNumber) // print after delay
                    paint(carNumber) // print after delay
                    installDriveTrain(carNumber) // print after delay
                    installBattery(carNumber) // print after delay
                    installInterior(carNumber) // print after delay
                    println(" car $carNumber build...")
                }

                if(carNumber == 1){
                    timeForSingleCar = time;
                    println("First car time $timeForSingleCar")
                }
            }
        
        println("car is building...")
    }
    private suspend fun buildBody(carNumber : Int){
        delay(5000L) // non-blocking delay for 5 second (default time unit is ms)
        println("Building Body of car ${carNumber}!")
    }

    private suspend fun paint (carNumber : Int){
        delay(5000L) // non-blocking delay for 5 second (default time unit is ms)
        println("Painting car ${carNumber}!")
    }

    private suspend fun installDriveTrain (carNumber : Int) {
        delay(10000L) // non-blocking delay for 10 second (default time unit is ms)
        println("Installing drive train in car ${carNumber}!")
    }

    private suspend fun installBattery (carNumber : Int) {
        delay(15000L) // non-blocking delay for 15 second (default time unit is ms)
        println("Installing battery in car ${carNumber}!")
    }

    private suspend fun installInterior (carNumber : Int) {
        delay(15000L) // non-blocking delay for 5 second (default time unit is ms)
        println("Installing interior in ${carNumber}!")
    }
}
