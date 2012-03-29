/**
 * The Java User Group Event class.
 *
 * @author edgar.espina
 * @since 0.1
 */
JugAR.Event = Backbone.Model.extend({
  /**
   * defaults attributes.
   */
  defaults: {
    date: new Date()
  },

  /**
   * Required by Backbone-Forms.
   */
  schema: {
    name:     'Text',
    type:     {type: 'Select', options: function(callback) {
      $.ajax({
        url: JugAR.contextPath + 'api/events/types',
        success: function(eventTypes) {
          callback(eventTypes);
        }
      });
    }},
    location: 'Text',
    date:     'DateTime'
  }
});
