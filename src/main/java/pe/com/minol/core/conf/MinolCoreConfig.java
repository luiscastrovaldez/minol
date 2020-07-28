package pe.com.minol.core.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan({ "pe.com.minol.core.entities",
		"pe.com.minol.core.services" })
@EnableJpaRepositories(basePackages = "pe.com.minol.core.repositories", entityManagerFactoryRef = "entityManagerFactory")
@EnableTransactionManagement
@PropertySource("classpath:minol-database.properties")
public class MinolCoreConfig extends AbstractCoreConfig {

}
