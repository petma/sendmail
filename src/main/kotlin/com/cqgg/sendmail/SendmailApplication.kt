package com.cqgg.sendmail

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class SendmailApplication

fun main(args: Array<String>) {
    runApplication<SendmailApplication>(*args)
}
