angular.module('mdButton', ['ngRoute','ngMaterial']);

angular.module('mdButton', ['ngRoute','ngMaterial'])
.controller('mdButton', function($scope) {
  $scope.title1 = 'Button';
  $scope.title4 = 'Warn';
  $scope.isDisabled = true;
});