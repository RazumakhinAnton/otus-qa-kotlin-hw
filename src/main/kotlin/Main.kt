import homework1.CustomTestRunner
import homework1.Steps

fun main() {
    val customTestRunner = CustomTestRunner()
    customTestRunner.runTest(Steps()) {
        println("Test")
    }
}