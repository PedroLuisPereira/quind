package com.example.quind.infrastructure.config;

import com.example.quind.domain.ports.ClientePortRepository;
import com.example.quind.domain.service.ClienteService;
import com.example.quind.infrastructure.output.persistence.ClientePersistenceAdapter;
import com.example.quind.infrastructure.output.persistence.repository.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ClientePersistenceAdapter clientePersistenceAdapter(ClienteRepository clienteRepository) {
        return new ClientePersistenceAdapter(clienteRepository);
    }

    @Bean
    public ClienteService clienteService(ClientePortRepository clientePortRepository) {
        return new ClienteService(clientePortRepository);
    }
}