var app = angular.module('tst', [
    'ngAnimate',
    'ngResource',
    'ui.router',
    'ui.bootstrap',
    'angular-loading-bar',
    'oc.lazyLoad',
    'nouislider',
    'ngTable',
    'tst.controllers',
    'tst.services',
    'toaster',
    'ngCookies',
    'ngPassword',
    'angularAudioRecorder',
    'ngStorage'
])
 

app.config(function (recorderServiceProvider) {
	recorderServiceProvider
    .forceSwf(false)
    //.setSwfUrl('/lib/recorder.swf')
    .withMp3Conversion(true);
	    
	  });


app.config([ '$stateProvider', '$urlRouterProvider' ,'$locationProvider',
            function($stateProvider, $urlRouterProvider,$locationProvider) {
	$urlRouterProvider.otherwise("/home");
	$stateProvider

	.state ('adminhome', {
        url: '/admin/home',
        templateUrl: 'views/adminhome.html',
        controller  : 'adminHomeController',
    
    })
    
    .state ('farmerhome', {
        url: '/farmer/home',
        templateUrl: 'views/FarmerHome.html',
        controller  : 'farmerHomeController',
    
    })
    
    .state ('vendorhome', {
        url: '/vendor/Home',
        templateUrl: 'views/VendorHomePage.html',
       	
    
    })
    .state ('liveBids', {
        url: '/vendor/liveBid',
        templateUrl: 'views/vendorLiveBids.html',
        controller: 'liveBidController',
       
    
    })
    .state ('bidHistory', {
        url: '/vendor/bidHistory',
        templateUrl: 'views/bidHistory.html',
        controller: 'bidHistoryController',
       
    
    })
    .state ('allBids', {
        url: '/vendor/allBids',
        templateUrl: 'views/allBids.html',
        controller: 'allBidsController',
       
    
    })
    
     .state ('CropSuggestion', {
        url: '/farmer/CropSuggestion',
        templateUrl: 'views/CropSuggestionHome.html',
        controller  : 'CropSuggestionController',
    })
    
     .state ('CropSuggestionForm', {
        url: '/farmer/CropSuggestionForm',
        templateUrl: 'views/CropSuggestionForm.html',
        controller  : 'CropSuggestionFormController',
    })
    
     .state ('authenticate', {
        url: '/requests',
        templateUrl: 'views/requestList.html',
        controller  : 'addPreTestController',
    })
    
     .state ('authenticate.farmer', {
        url: '/requests/farmer',
        templateUrl: 'views/farmerRequestList.html',
        controller  : 'farmerRequestListController',
    })
    
     .state ('authenticate.vendor', {
        url: '/requests/vendor',
        templateUrl: 'views/vendorRequestList.html',
        controller : 'vendorRequestListController',
    })
    
    
   
    .state ('createBid', {
        url: '/farmer/createBid',
        templateUrl: 'views/farmerBiddingForm.html',
        controller  : 'editPreTestController',  
        resolve	:{
            productList	: function($http){
                return $http.get("user/viewProduct").then(function(response){
                    return response.data;
                })
            }
         }  
    })
    
    .state ('viewBid', {
        url: '/farmer/viewBid',
        templateUrl: 'views/viewBid.html',
        controller  : 'viewBidController',    
       
    })
    
    .state ('VendorDetails', {
        url: '/farmer/vendorDetails',
        templateUrl: 'views/VendorDetailForBid.html',
        controller  : 'vendorDetailsForBidController',    
       
    })
    
    .state ('register', {
        url: '/register',
        templateUrl: 'views/registration.html',
        controller  : 'farmerRegisterController',
        
          
    })
    
     .state ('vendorregister', {
        url: '/vendorregister',
        templateUrl: 'views/registrationVendor.html',
        controller  : 'vendorRegisterController',
        
          
    })
    
 
   
   
    .state ('employee', {
        url: '/employee',
        templateUrl: 'views/employee.html',
        controller  : 'employeeController',
    })
   
    .state ('login', {
        url: '/login',
        templateUrl: 'views/login.html',
        controller  : 'loginController',
    })
     .state ('home', {
        url: '/home',
        templateUrl: 'views/home.html',
        //controller  : 'homeController', 
    })
    
   
}]);
