package src.framework.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("api")
@ConstructorBinding
data class ApplicationProperties(val key: String)
