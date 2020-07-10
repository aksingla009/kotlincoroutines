import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        /*  println("Showcasing the use of MAP operator")
          mapOperator()
          println("---------------------------------------")
          println("Showcasing the use of FILTER operator")
          println()
          filterOperator()
          println("---------------------------------------")
          println("Showcasing the use of TRANSFORM operator")
          println()
          transformOperator()
          println("---------------------------------------")
        println("Showcasing the use of TAKE operator")
        println()
        takeOperator()
        println("---------------------------------------")
        println("Showcasing the use of REDUCE operator")
        println()
        reduceOperator()*/
        println("---------------------------------------")
        println("Showcasing the use of FLOW ON operator to switch context")
        println()
        flowOnOperator()
    }
}

private suspend fun flowOnOperator() {
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect {
            println(it)
        }
}

private suspend fun reduceOperator() {
    val size = 10
    val factorial = (1..10).asFlow()
        .reduce { accumulator, value ->
            accumulator * value
        }
    println("The factorial of $size is $factorial")
}

private suspend fun takeOperator() {
    (1..10).asFlow()
        .take(3)
        .collect {
            println(it)
        }
}

private suspend fun mapOperator() {
    (1..10).asFlow()
        .map {
            delay(500L)
            "mapping $it"
        }
        .collect {
            println(it)
        }
}

private suspend fun filterOperator() {
    (1..10).asFlow()
        .filter {
            it % 2 == 0
        }
        .collect {
            println(it)
        }
}

private suspend fun transformOperator() {
    (1..10).asFlow()
        .transform {
            //Emitting String
            emit("Emitting SQUARE value of $it as ${it * it}")
            emit(it)
            //Emitting INT
        }
        .collect {
            println(it)
        }
}

