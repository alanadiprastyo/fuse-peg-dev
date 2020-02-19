package org.pegadaian.dev;

import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.configuration.SaslQop;

public class InfinispanConfig {
	
	private InfinispanConfig() {
	}
	
	public static ConfigurationBuilder createConfig() {
		ConfigurationBuilder cfg = new ConfigurationBuilder();
		
		cfg
			.addServer()
				.host("cache-service-route-middleware.apps.ocp-jkt.pegadaian.co.id")
				.port(443)
			.security().authentication()
				.enable()
				.username("pegadaian")
				.password("pegadaian")
				.serverName("cache-service")
				.saslQop(SaslQop.AUTH)
			.ssl()
			.trustStorePath("apps-ocp-jkt-pegadaian-co-id-chain.pem")
			.trustStoreType("PEM")
		;
		
		return cfg;
	}

}