package io.smallrye.stork.serviceregistration.eureka;

import jakarta.enterprise.context.ApplicationScoped;

import io.smallrye.stork.api.ServiceRegistrar;
import io.smallrye.stork.api.config.ServiceRegistrarAttribute;
import io.smallrye.stork.api.config.ServiceRegistrarType;
import io.smallrye.stork.impl.EurekaMetadataKey;
import io.smallrye.stork.spi.ServiceRegistrarProvider;
import io.smallrye.stork.spi.StorkInfrastructure;

@ServiceRegistrarType(value = "eureka", metadataKey = EurekaMetadataKey.class)
@ServiceRegistrarAttribute(name = "eureka-host", description = "The Eureka host.", defaultValue = "localhost")
@ServiceRegistrarAttribute(name = "eureka-port", description = "The Eureka port.", defaultValue = "8761")
@ServiceRegistrarAttribute(name = "eureka-context-path", description = "The Eureka server root context path.", defaultValue = "/")
@ServiceRegistrarAttribute(name = "eureka-trust-all", description = "Enable/Disable the TLS certificate verification", defaultValue = "false")
@ServiceRegistrarAttribute(name = "eureka-tls", description = "Use TLS to connect to the Eureka server", defaultValue = "false")
@ServiceRegistrarAttribute(name = "health-check-url", description = "The liveness http address.", defaultValue = "")
@ServiceRegistrarAttribute(name = "host-name", description = "The host name to register in Eureka. If not set, the ipAddress is used.", defaultValue = "")
@ServiceRegistrarAttribute(name = "lease-renewal-enabled", description = "Whether to renew the lease of the registered instances periodically. If disabled, Eureka evicts the instances once the lease duration has expired.", defaultValue = "true")
@ServiceRegistrarAttribute(name = "lease-renewal-interval", description = "How often the lease of the registered instances is renewed.", defaultValue = "30s")
@ServiceRegistrarAttribute(name = "lease-duration", description = "How long Eureka keeps an instance without lease renewal before evicting it.", defaultValue = "90s")
@ApplicationScoped
public class EurekaServiceRegistrarProvider
        implements ServiceRegistrarProvider<EurekaRegistrarConfiguration, EurekaMetadataKey> {

    @Override
    public ServiceRegistrar<EurekaMetadataKey> createServiceRegistrar(EurekaRegistrarConfiguration config,
            String serviceRegistrarName, StorkInfrastructure infrastructure) {
        return new EurekaServiceRegistrar(config, serviceRegistrarName, infrastructure);
    }

}
