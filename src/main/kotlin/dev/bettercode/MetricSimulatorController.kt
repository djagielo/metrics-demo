package dev.bettercode

import io.micrometer.core.instrument.LongTaskTimer
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Duration
import java.time.LocalDateTime
import kotlin.random.Random

@RestController
class MetricSimulatorController(meterRegistry: MeterRegistry) {

    private val longTaskTimer: LongTaskTimer = LongTaskTimer.builder("long-timer").minimumExpectedValue(Duration.ofSeconds(1))
        .distributionStatisticExpiry(Duration.ofHours(1))
        .publishPercentiles(0.9, 0.99)
        .maximumExpectedValue(Duration.ofMinutes(60)).register(meterRegistry)

    private val timer: Timer = Timer.builder("just-timer").minimumExpectedValue(Duration.ofSeconds(1))
        .distributionStatisticExpiry(Duration.ofHours(1))
        .publishPercentiles(0.9, 0.99)
        .maximumExpectedValue(Duration.ofMinutes(60)).register(meterRegistry)

    @PostMapping("/generate-metric/just-timer")
    fun generateLongTimer() {
        val hourOfDay = LocalDateTime.now().hour

        // generate 0-120 seconds
        // multiple by hour of day and publish

        val random = Random(System.currentTimeMillis()).nextLong(0, 120)
        val duration = Duration.ofSeconds(random * hourOfDay)
        timer.record(duration)
    }
}