package ar.jug.domain;

import org.knowhow.mwa.jpa.JpaConfigurer;
import org.knowhow.mwa.jpa.JpaModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The event module.
 *
 * @author edgar.espina
 * @since 0.1
 */
@Configuration
public class EventModule {

  /**
   * Publish persistent classes required by {@link JpaModule}.
   *
   * @return All persistent classes required by {@link JpaModule}.
   * @throws Exception If the persisten classes cannot be detected.
   */
  @Bean
  public JpaConfigurer jpaConfigurer() throws Exception {
    JpaConfigurer configurer = new JpaConfigurer();
    configurer.addPackage(getClass().getPackage());
    return configurer;
  }
}
