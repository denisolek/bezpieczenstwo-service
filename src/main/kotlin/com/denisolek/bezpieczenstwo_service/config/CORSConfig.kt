package com.denisolek.bezpieczenstwo_service.config

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class CORSConfig : CorsFilter(configurationSource()) {
    companion object {
        fun configurationSource(): UrlBasedCorsConfigurationSource {
            val config = CorsConfiguration()
            config.allowCredentials = true
            config.addAllowedOrigin("*")
            config.addAllowedHeader("*")
            config.addAllowedMethod("*")
            val source = UrlBasedCorsConfigurationSource()
            source.registerCorsConfiguration("/**", config)
            return source
        }
    }
}