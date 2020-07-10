import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        launch(CoroutineName("amanCoroutine")) {
            print("This is run from ${this.coroutineContext[CoroutineName.Key]}")
        }
    }
}