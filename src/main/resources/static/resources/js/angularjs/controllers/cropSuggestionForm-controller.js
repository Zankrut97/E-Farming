var CropSuggestionFormController = angular.module('cropSuggestionForm-controller', ['ui.router','oc.lazyLoad']);

CropSuggestionFormController.controller('CropSuggestionFormController', function($scope,$state,$cookieStore, $rootScope, $location,toaster,$uibModal,CropRegisterAPI,CropSuggestionFormAPI){
	
		$scope.product = [];
		$scope.global = $cookieStore.get("globals") || {};
		$scope.arrlist = [{
			"userid": 1,
			"name": "Alluvial"
			}, {
			"userid": 2,
			"name": "Black Soil"
			}, {
			"userid": 3,
			"name": "Red Soils"
			}, {
			"userid": 4,
			"name": "Lateritic Soils"
		}];	
		$scope.getdetails = function () {
			
			CropSuggestionFormAPI.getCropName($scope.crop.soilType).success(function(res){
			
				$scope.product = res;
				//console.log($scope.product);
		
			});
				
			
		/*	if ($scope.soilselected.userid == "1")
				console.log($scope.soilselected.name);
			else if($scope.soilselected.userid == "2")
				console.log($scope.soilselected.name);
			else if($scope.soilselected.userid == "3")
				console.log($scope.soilselected.name);
			else if($scope.soilselected.userid == "4")
				console.log($scope.soilselected.name);
			else
				console.log("error");	*/
		}
		
		$scope.cropSuggestionForm = function($event) {
		
			$scope.crop.farmerId= $scope.global.currentUser.id;
			$scope.crop.soilName = $scope.crop.soilType.name;
			
			CropRegisterAPI.registerCrop($scope.crop).success(function(res){
			
				console.log(res.status);
					
			});
			
			
		}
		
		$scope.getFinalProductName = function(name) {
			
				$scope.crop.name = name;
		}
		
	
	
})

