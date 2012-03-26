package ar.jug.domain;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Create, Read, Update and Delete {@link Event} using a REST API.
 *
 * @author edgar.espina
 * @since 0.1
 */
@Controller
@RequestMapping("/events")
@Transactional
public class Events {

  /**
   * The persistence manager. Required.
   */
  private EntityManager em;

  /**
   * Creates a new {@link Events manager}.
   *
   * @param em The persistence manager. Required.
   */
  @Inject
  public Events(final EntityManager em) {
    this.em = checkNotNull(em, "The entity manager is required.");
  }

  /**
   * Required by {@link Transactional}.
   */
  protected Events() {
  }

  /**
   * Create or update an {@link Event event}.
   *
   * @param event The event to persist. Required.
   * @return The persitent event.
   */
  @RequestMapping(method = {POST, PUT })
  @ResponseBody
  public Event event(@RequestBody @Valid final Event event) {
    return em.merge(event);
  }

  /**
   * Get an {@link Event event}.
   *
   * @param id The event's id. Required.
   * @return An existing event.
   */
  @RequestMapping(value = "/{id}", method = GET)
  @ResponseBody
  public Event get(@PathVariable @NotEmpty final String id) {
    return em.find(Event.class, id);
  }

  /**
   * Search for events.
   *
   * @param criteria The event criteria. Required.
   * @return The resulting events.
   */
  @RequestMapping(method = GET)
  @ResponseBody
  public Iterable<Event> list(@Valid final EventCriteria criteria) {
    return criteria.execute(em);
  }

  /**
   * Delete an {@link Event event} by it's id.
   *
   * @param id The event's id. Required.
   */
  @RequestMapping(value = "/{id}", method = DELETE)
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable @NotEmpty final String id) {
    em.remove(get(id));
  }
}
