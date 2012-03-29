/**
 * Initialize the application on dom ready.
 *
 * @author edgar.espina
 * @since 0.1
 */
$(function() {
  /**
   * The event collection.
   */
  var events = new JugAR.Events();

  /**
   * The Application Rotuer.
   */
  var Router = Backbone.Router.extend({

    /**
     * Map URI fragments to function handlers.
     */
    routes: {
      'event/new':         'onNewEvent',
      'event/:id':         'onEdit',
      '*path':             'onGoHome'
    },

    /**
     * Go to '/'.
     */
    onGoHome: function() {
      $('#event-form').hide();
      $('#event-list').show();
      new JugAR.EventList({
        el: '#event-list',
        collection: events
      });
    },

    /**
     * Go to new event screen.
     */
    onNewEvent: function(id) {
      $('#event-list').hide();
      $('#event-form').show();
      new JugAR.EventForm({
        el: '#event-form',
        model: new JugAR.Event(),
        collection: events
      });
    },

    /**
     * Move to the edit screen.
     */
    onEdit: function(id) {
      $('#event-list').hide();
      $('#event-form').show();
      var model = new JugAR.Event({
        id: id
      });
      // Re-load the event from the server.
      model.url = events.url + '/' + id;
      model.fetch({
        success: function() {
          new JugAR.EventForm({
            el: '#event-form',
            model: model,
            collection: events
          });
        }
      });
    }
  });
  /**
   * Create the App router.
   */
  var route = new Router();
  /**
   * A shortcut for navegate between pages.
   */
  JugAR.navigate = function(fragment) {
    route.navigate(fragment, {trigger: true});
  }

  /**
   * Start tracking URI changes.
   */
  Backbone.history.start({pushState: true, root: JugAR.contextPath});
});