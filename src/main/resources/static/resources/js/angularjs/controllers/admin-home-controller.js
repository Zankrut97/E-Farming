/**
 * 
 */
'use strict';

var adminHomeController = angular.module('admin-home-controller', ['ui.router','oc.lazyLoad']);

adminHomeController.controller('adminHomeController', function($scope,$state, $rootScope, $location,toaster){
	
	$scope.$state = $state;
	
	})
	