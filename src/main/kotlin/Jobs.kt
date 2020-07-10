import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    lateinit var job2: Job
    runBlocking {
        val job1 = launch {
            println("Job1 launched")

            job2 = launch {
                println("Job2 launched")
                delay(3000L)
                println("Job2 is finishing")
            }
            job2.invokeOnCompletion {
                println("Job2 completed")
            }

            val job3 = launch {
                println("Job3 launched")
                delay(3000L)
                println("Job3 is finishing")
            }
            job3.invokeOnCompletion {
                println("Job3 completed")
            }
            println("Job1 is finishing")
        }

        job1.invokeOnCompletion {
            println("Job1 completed")
        }

        delay(500L)
        println("Job1 will be cancelled")
        job2.cancel()
    }
}