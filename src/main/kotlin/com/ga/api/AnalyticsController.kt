package com.ga.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("analytics")
class AnalyticsController(@Autowired private val config: AnalyticsConfig) {

    @PostMapping
    fun postSampleEvent() {
        val uri = UriComponentsBuilder
                .newInstance()
                .scheme(config.scheme)
                .host(config.host)
                .path(config.path)
                .queryParam("v", config.version)
                .queryParam("tid", config.tracking)
                .queryParam("cid", "555")
                .queryParam("ua", "sampleUserAgent")    // This was needed for Spring apps, GA filters on certain user agent strings
                .queryParam("t", "event")
                .queryParam("ec", "sampleCategory")
                .queryParam("ea", "sampleAction")
                .build()
                .toUri()

        val rest = RestTemplate()
        rest.postForObject(uri, null, ByteArray::class.java)
    }

}