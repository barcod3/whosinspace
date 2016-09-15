var space = Ember.Application.create({
    LOG_TRANSITIONS: true,
    LOG_BINDINGS: true,
    LOG_VIEW_LOOKUPS: true,
    LOG_STACKTRACE_ON_DEPRECATION: true,
    LOG_VERSION: true,
    debugMode: true
});


space.Router.map(function(){
    this.route('space')
    this.route('reads')
})

space.SpaceRoute = Ember.Route.extend({
    model: function () {
    return $.getJSON("../whosinspace");
    },

});

space.ReadsRoute = Ember.Route.extend({
    model: function () {

    },





});

space.ReadsController = Ember.ObjectController.extend({
    accountNo:"6958784",
    meters:null,
    actions:{
        getMeters: function(){
            that = this;

            Ember.$.getJSON("../reads?custaccountno=" + this.accountNo).then(function(data){
                that.set('meters',data)
            })
        }
    }
})

