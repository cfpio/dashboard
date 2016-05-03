{
  const dashboard = angular.module('io.cfp.dashboard', [

  ])
  .component('cfpEventList', {
    controller($http) {
      this.events = []
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
  .component('cfpSpeakerList', {
    controller($http) {
      this.speakers = []
      $http.get('/api/speakers').then(({ data }) => {
        this.speakers = data
      })
    },
    template: `
      <h3>Speaker List</h3>
      <ul>
        <li ng-repeat="speaker in $ctrl.speakers">{{speaker.name}} {{speaker.lastname}}({{speaker.mail}})</li>
      </ul>
    `
  })
  document.addEventListener('DOMContentLoaded', () => {
    angular.bootstrap(document.documentElement, [dashboard.name])
  })
}
