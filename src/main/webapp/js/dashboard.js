{
  const dashboard = angular.module('io.cfp.dashboard', [

  ]).component('cfpEventList', {
    controller($http) {
      $http.get('/api/events').then(({ data }) => {
        this.events = data
      })
    },
    template: `
      <h3>Event List</h3>
      <ul>
        <li ng-repeat="event in $ctrl.events">{{event.name}}</li>
      </ul>
    `
  })
  document.addEventListener('DOMContentLoaded', () => {
    angular.bootstrap(document.documentElement, [dashboard.name])
  })
}
