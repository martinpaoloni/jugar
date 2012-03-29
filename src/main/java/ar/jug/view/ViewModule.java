package ar.jug.view;

import org.apache.commons.lang3.Validate;
import org.knowhow.mwa.Application;
import org.knowhow.mwa.view.HtmlTemplates;
import org.knowhow.mwa.view.mustache.MustacheViewResolver;
import org.knowhow.mwa.wro4j.CssExporter;
import org.knowhow.mwa.wro4j.JavaScriptExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

/**
 * The View Module.
 *
 * @author edgar.espina
 * @since 0.1
 */
@Configuration
public class ViewModule {

  /**
   * Publish a {@link MustacheViewResolver} as view template engine.
   *
   * @param app The application object. Required.
   * @return A {@link MustacheViewResolver} as view template engine.
   */
  @Bean
  public ViewResolver viewResolver(final Application app) {
    Validate.notNull(app, "The application is required");
    MustacheViewResolver viewResolver =
        new MustacheViewResolver(
            new JavaScriptExporter(),
            new CssExporter(),
            new HtmlTemplates("/partials", "html")
        );
    viewResolver.setSuffix(".html");
    viewResolver.setCache(app.mode() != Application.DEV);
    return viewResolver;
  }
}
