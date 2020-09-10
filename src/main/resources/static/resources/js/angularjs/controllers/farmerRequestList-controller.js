var farmerRequestListController = angular.module('farmerRequestList-Controller', []);

farmerRequestListController.controller("farmerRequestListController",function(farmerListAPI, $location,$rootScope,$state,$scope,toaster,$cookieStore,updateFarmerStatusAPI){
    $scope.requestList1 = [];
   
    
    
    farmerListAPI.requestList().success(function(res){
    	
        $scope.requestList1 = res;
       
	});

	 $scope.updateStatus = function(index){
        $scope.editCurrentStatus = $scope.requestList1[index];
       
    }
    
     $scope.changeCurrentStatus = function(){
     	var status1 = document.getElementById("status_value").value;
     	
     	if(status1=="true")
     	{
     		 $scope.editCurrentStatus.user.status = status1;
     		 toaster.pop('success', " ","Authenticate Successfully..");
     		 updateFarmerStatusAPI.updateFarmerStatusData($scope.editCurrentStatus.user).success(function(res){
     		 
		     		$state.go("adminhome");
					$rootScope.currentPage = "/admin/home"
     		    
            });
           
     		
       	}
     	else
     	{
     		 toaster.pop('error', " ","Change Status..");
     			
     	}
    }

});
