/**
 * 
 */
'use strict';

var loginController = angular.module('login-controller', ['ui.router','oc.lazyLoad']);

	/*page under construction controller*/
	loginController.controller('loginController', function($scope, $rootScope, $location,LoginAPI,toaster,$state,AuthenticationService,$cookieStore){
	
		
		$scope.login = function($event){
			
			$event.preventDefault();
			
				LoginAPI.doLogin($scope.loginModel).success(function (response) {
					//console.log(response);
					if(response.status){
						
						if(response.user.type=="admin"){
							
							toaster.pop('success', "Login", response.message);
							AuthenticationService.SetCredentials($scope.loginModel.email, $scope.loginModel.password,response.user.type,response.user.id);
							
							$state.go("adminhome");
						    $rootScope.currentPage = "/admin/home"
						}
						else if(response.user.type=="farmer"){
						
							if(response.user.status==1){
								toaster.pop('success', "Login", response.message);
								AuthenticationService.SetCredentials($scope.loginModel.email, $scope.loginModel.password,response.user.type,response.user.id);
								$rootScope.adminDetails = response;
								
							    $state.go("farmerhome");
								$rootScope.currentPage = "/farmer/home"
						   	}
						    else{
						   		toaster.pop('error', "Login","authentication pending");
						    }
						}
						else if(response.user.type=="vendor"){
							if(response.user.status==1){
								toaster.pop('success', "Login", response.message);
								AuthenticationService.SetCredentials($scope.loginModel.email, $scope.loginModel.password,response.user.type,response.user.id);
								$rootScope.adminDetails = response;
								
								$state.go("vendorhome");
							    $rootScope.currentPage = "/vendor/home"
						      }
						    else{
						    	toaster.pop('error', "Login","authentication pending");
						    }
						}
						
					}
					else{
						
						toaster.pop('error', "Login", response.message);
					}
				}).
				error(function(data, status, headers, config) {
					toaster.pop('error', "History", "There is some error to save basic info..!!");
				});
			}
		
		
	});