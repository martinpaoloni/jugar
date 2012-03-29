/**
 * The event list view.
 *
 * @author edgar.espina
 * @since 0.1
 */
JugAR.EventList = Backbone.View.extend({

  /**
   * View events.
   */
  events: {
    'click #new': 'onNewEvent'
  },

  /**
   * @field {tbody} The table body.
   */
  $tbody: null,

  /**
   * Perform all the view initialization.
   */
  initialize: function () {
    // Set the table body.
    this.$tbody = this.$('tbody');

    // Listen for reset events and re-render the list.
    this.collection.bind('reset', this.onReset, this);

    // Read all the events from the Server.
    this.collection.fetch();

    this.$el.show();
  },

  /**
   * Re-render all the JUG events.
   */
  onReset: function() {
    this.$tbody.empty();
    this.collection.each(this.onAdd, this);
  },

  /**
   * Renderer a single JUG Event as a 'tr' element.
   *
   * @param {Event} model The JUG Event.
   */
  onAdd: function(model) {
    this.$tbody.append(new JugAR.EventRow({
      model: model
    }).render().el);
  },

  /**
   * Open the new event screen.
   */
  onNewEvent: function() {
    JugAR.navigate('/event/new');
  }
});
