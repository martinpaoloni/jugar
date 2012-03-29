/**
 * The event row view.
 *
 * @author edgar.espina
 * @since 0.1
 */
JugAR.EventRow = Backbone.View.extend({

  /**
   * @property {String} tagName The dom element for each event.
   */
  tagName: 'tr',

  events: {
    'click #delete': 'onDeleteEvent',
    'click #edit':   'onEditEvent'
  },

  /**
   * Renderer the view.
   */
  render: function () {
    var template = $('#event-row-tmpl').html(),
        data = this.model.toJSON();
    // Apply some formatting
    data.date = new Date(data.date);
    data.type = data.type.name;
    this.$el.append(Mustache.to_html(template, data));
    return this;
  },

  /**
   * Open the edit screen.
   */
  onEditEvent: function() {
    JugAR.navigate('/event/' + this.model.id);
  },

  /**
   * Delete a JUG event.
   */
  onDeleteEvent: function() {
    if(confirm('Delete: "' + this.model.get('name') + '"')) {
      var $tr = this.$el;
      this.model.destroy({
        success: function() {
          $tr.remove();
        }
      });
    }
  }
});
