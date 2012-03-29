/**
 * The Event Collection class.
 *
 * @author edgar.espina
 * @since 0.1
 */
JugAR.Events = Backbone.Collection.extend({
  /**
   * The Base URI for the REST API.
   *
   * @property {String} url The Base URI for the REST API.
   */
  url: JugAR.contextPath + 'api/events',

  /**
   * The component type.
   *
   * @property {Event} model The component type.
   */
  model: JugAR.Event
});
