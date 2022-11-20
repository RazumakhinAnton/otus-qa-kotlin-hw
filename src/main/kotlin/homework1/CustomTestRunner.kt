package homework1

import org.slf4j.LoggerFactory
import kotlin.reflect.full.functions

class CustomTestRunner : TestRunner {

    companion object {
        val logger = LoggerFactory.getLogger(CustomTestRunner::class.java);
    }

    override fun <T> runTest(steps: T, test: () -> Unit) {
        runRequiredSteps(steps, "before")
        test()
        runRequiredSteps(steps, "after")
    }

    private fun <T> runRequiredSteps(steps: T, stepName: String) {
        logger.info("Execute all methods begin with $stepName")
        steps!!::class.functions
            .filter { it.name.startsWith(stepName) }
            .forEach {
                logger.info("Execute step: ${it.name}")
                it.call(steps)
            }
    }

}