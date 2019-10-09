package io.spring.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.embedded.NettyWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class FrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendApplication.class, args);
	}

	@Bean
	public NettyWebServerFactoryCustomizer customizer(Environment environment, ServerProperties serverProperties) {
		return new NettyWebServerFactoryCustomizer(environment, serverProperties) {
			@Override
			public void customize(NettyReactiveWebServerFactory factory) {
				factory.addServerCustomizers(httpServer -> httpServer.metrics(true));
				super.customize(factory);
			}
		};
	}
}
