package errorhandling

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.Exception

fun main() {
    runBlocking {
        //errorhandling.tryCatchTest()
//        errorhandling.catchOperatorTest()
        onCompletionOperatorTest()
    }
}

private suspend fun onCompletionOperatorTest() {
    (1..3).asFlow()
        .onEach {
            check(it != 2)
        }
        .onCompletion { cause ->
            if (cause != null) {
                println("Flow ended with cause $cause")
            } else {
                println("Flow completed successfully")
            }

        }
        .catch { e ->
            println("Caught Exception $e")
        }
        .collect {
            println(it)
        }

}

private suspend fun catchOperatorTest() {
    (1..3).asFlow()
        .onEach {
            check(it != 2)
        }
        .catch { e ->
            println("Caught Exception $e")
        }
        .collect {
            println(it)
        }

}


private suspend fun tryCatchTest() {
    try {
        (1..3).asFlow()
            .onEach {
                check(it != 2)
            }
            .collect {
                println(it)
            }
    } catch (e: Exception) {
        println("Caught Exception $e")
    }
}