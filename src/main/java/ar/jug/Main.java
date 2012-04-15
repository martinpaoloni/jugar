package ar.jug;

import org.knowhow.mwa.Startup;
import org.knowhow.mwa.jpa.JpaModule;
import org.knowhow.mwa.validation.ValidationModule;

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
    return new Class<?>[] {JpaModule.class, ValidationModule.class,
        EventModule.class, ViewModule.class };
  }

}
