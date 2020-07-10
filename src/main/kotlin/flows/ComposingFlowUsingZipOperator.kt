package flows

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        zipOperator()
    }
}

private suspend fun zipOperator() {
    val english = flowOf("ONE", "TWO", "THREE")
    val french = flowOf("UN", "DEUX", "TROIS")

    english.zip(french) { a, b -> "English Word '$a' in french is '$b'" }
        .collect {
            println(it)
        }
}