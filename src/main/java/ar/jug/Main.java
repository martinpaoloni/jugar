package ar.jug;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;

import org.knowhow.mwa.Startup;
import org.knowhow.mwa.jpa.JpaModule;
import org.knowhow.mwa.wro4j.WebResourceOptimizer;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import ar.jug.domain.EventModule;
import ar.jug.view.ViewModule;

/**
 * Startup the web-app.
 *
 * @author edgar.espina
 * @since 0.1
 */
public class Main extends Startup {

  /**
   * Publish all the modules.
   *
   * @return All the modules.
   */
  @Override
  protected Class<?>[] modules() {
    return new Class<?>[] {JpaModule.class, EventModule.class,
        ViewModule.class };
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void onStartup(final ServletContext servletContext,
      final ConfigurableWebApplicationContext context) {
    servletContext.addFilter("wro4j",
        new WebResourceOptimizer(context.getEnvironment())
            .withPostProcessor("googleClosureSimple")
            .withPostProcessor("yuiCssMin")
            .build()
        ).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false,
            "*.js", "*.css");
  }
}
