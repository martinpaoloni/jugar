package ar.jug.view;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.jug.domain.EventCriteria;
import ar.jug.domain.Events;

/**
 * Render views.
 *
 * @author edgar.espina
 * @since 0.1
 */
@Controller
public class Views {

  /**
   * The event manager. Required.
   */
  private Events events;

  /**
   * Creates a new {@link Views} controller.
   *
   * @param events The event manager. Required.
   */
  @Inject
  public Views(final Events events) {
    this.events = checkNotNull(events, "The event manager is required.");
  }

  /**
   * Render /events.html.
   *
   * @param criteria The event criteria. Required.
   * @param model The model object. Required.
   */
  @RequestMapping("/")
  public void events(@Valid final EventCriteria criteria, final Model model) {
    model.addAttribute("events", events.list(criteria));
  }
}
