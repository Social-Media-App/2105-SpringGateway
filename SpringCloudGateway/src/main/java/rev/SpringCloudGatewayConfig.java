package rev;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class SpringCloudGatewayConfig {
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(myRoute -> myRoute.path("/user-api/**").uri("lb://user-service"))
				.route(myRoute -> myRoute.path("/post-api/**").uri("lb://post-service"))
				.build();
	}

}
