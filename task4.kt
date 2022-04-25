//main.kt
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import Car as Car

fun main() {
    runBlocking {
        val numberOfCar = 10
        val time = measureTimeMillis {
            val avgTime = buildNewCar(numberOfCar);
            println("Time taken to build single car is  ${avgTime}. ")
        }
        println("Total time taken to build ($numberOfCar) cars is  ${time}. ")
    }
}

suspend fun buildNewCar(numberOfCar: Int): Int {
    var totalTime = 0
    coroutineScope {
        repeat(numberOfCar) { // launch a lot of coroutines
            val car = Car()
            launch {
                val tm = car.build(it + 1);
                totalTime = (totalTime + tm).toInt();
            }
        }
    }
    return (totalTime/numberOfCar)
}


//car.kt

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class Car {
    suspend fun build (carNumber: Int): Long {
        var time  = measureTimeMillis {
            buildBody(carNumber) // print after delay
            paint(carNumber) // print after delay
            installDriveTrain(carNumber) // print after delay
            installBattery(carNumber) // print after delay
            installInterior(carNumber) // print after delay
        }
        println("Building process of car $carNumber is completed in $time ms")
        return time;
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
