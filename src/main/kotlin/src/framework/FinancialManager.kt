package src.framework

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("src")
class FinancialManager

fun main(args: Array<String>) {
    runApplication<FinancialManager>(*args)
}