import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            println("First Context is $coroutineContext on thread ${Thread.currentThread().name} with ID ${Thread.currentThread().id}")

            withContext(Dispatchers.IO){
                println("Second Context is $coroutineContext on thread ${Thread.currentThread().name} with ID ${Thread.currentThread().id}")
            }

            println("Third Context is $coroutineContext on thread ${Thread.currentThread().name} with ID ${Thread.currentThread().id}")

        }
    }
}