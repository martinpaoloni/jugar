/**
 * The event form view.
 *
 * @author edgar.espina
 * @since 0.1
 */
JugAR.EventForm = Backbone.View.extend({

  /**
   * Listen for save and cancel event.
   */
  events: {
    'click #save': 'onSave',
    'click #cancel': 'onCancel'
  },

  /**
   * The event form.
   */
  initialize: function() {
    this.form = new Backbone.Form({
      model: this.model
    }).render();

    this.$('#form').html(this.form.el);
    return this;
  },

  /**
   * Save a JUG Event.
   */
  onSave: function() {
    var events = this.collection;
    // Update the model
    this.form.commit();
    // Persist the model
    this.model.url = events.url;
    this.model.save(null, {
      success: function(event) {
        events.add(event);
        JugAR.navigate();
      },
      error: function(model, response) {
        var errors = JSON.parse(response.responseText);
        $('#errors').empty();
        _.forEach(errors, function(error) {
          $('#errors').append('<p>' + error.message + '</p>');
        });
      }
    });
  },

  /**
   * Cancel the creation of a JUG Event.
   */
  onCancel: function() {
    JugAR.navigate();
  }
});
