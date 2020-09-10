var vendorRegisterController = angular.module('vendor-register-controller', ['ui.router','oc.lazyLoad']);

vendorRegisterController.controller('vendorRegisterController', function($scope,$state, $rootScope, $location,toaster,$uibModal,VendorRegisterAPI){
	
	$scope.vendorRegistration = function($event){
	
	
	//console.log($scope.vreginfo.fName);
	
	VendorRegisterAPI.createform($scope.vreginfo).success(function(res){
	
	});
		
	}
	
	
	

    })