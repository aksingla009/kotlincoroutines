import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val firstDeferred: Deferred<Int> = async { getFirstValue() }
        val secondDeferred = async { getSecondValue() }

        println("Doing some processing here")
        delay(500L)
        println("Waiting for values")

        val firstVal = firstDeferred.await()
        println("First Value Is $firstVal")
        val secondVal = secondDeferred.await()
        println("Second Value Is $secondVal")

        println("Total Is ${firstVal + secondVal}")

    }


}

suspend fun getFirstValue(): Int {
    delay(3000L)
    val value = Random.nextInt(100)
    println("Returning First value $value")
    return value
}

suspend fun getSecondValue(): Int {
    delay(9000L)
    val value = Random.nextInt(1000)
    println("Returning Second value $value")
    return value
}