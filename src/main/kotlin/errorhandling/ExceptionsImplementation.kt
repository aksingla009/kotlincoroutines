package errorhandling

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val myExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception Handled in Exception Handler ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(myExceptionHandler) {
            println("Throwing Exception From JOB")
            throw IndexOutOfBoundsException("Exception FROM LAUNCH job")
        }
        job.join()

        val deferred = GlobalScope.async {
            println("Throwing Exception from ASYNC DEFERRED JOB")
            throw ArithmeticException("Exception FROM async deferred job")
        }
        try {
            deferred.await()
        } catch (e: ArithmeticException){
            println("Exception Handled in CATCH block ${e.localizedMessage}")
        }
    }
}