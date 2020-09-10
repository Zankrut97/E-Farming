var farmerRegisterController = angular.module('farmer-register-controller', ['ui.router','oc.lazyLoad']);

farmerRegisterController.controller('farmerRegisterController', function($scope,$state, $rootScope, $location,toaster,$uibModal,FarmerRegisterAPI){
	
	$scope.farmerRegistration = function($event){
	
	
	
	
	FarmerRegisterAPI.createform($scope.regInfo).success(function(res){
	
	});
		
	}
	
	
	

    })