package com.ga.api

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("analytics")
data class AnalyticsConfig(
        var version: String = "",
        var scheme: String = "",
        var host: String = "",
        var path: String = "",
        var tracking: String = ""
)