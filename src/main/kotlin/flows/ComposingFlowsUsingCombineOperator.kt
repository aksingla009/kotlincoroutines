package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        combineOperator()
    }
}

private suspend fun combineOperator() {
    val numbers = (1..5).asFlow()
        .onEach { delay(300) }

    val values = flowOf("ONE", "TWO", "THREE", "FOUR", "FIVE")
        .onEach { delay(400) }

    numbers.combine(values) { a, b -> "$a -> $b" }
        .collect {
            println(it)
        }
}