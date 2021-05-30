package src.framework.security

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import src.framework.properties.ApplicationProperties
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthorizerInterceptor(val applicationProperties: ApplicationProperties): HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val token =request.getHeader("api-key")
        if (token == null || token != applicationProperties.key) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Not Authorized")
            return false
        }
        return true
    }
}