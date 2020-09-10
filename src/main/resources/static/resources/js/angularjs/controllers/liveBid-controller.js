var liveBidController = angular.module('liveBid-Controller', []);

liveBidController.controller("liveBidController",function(liveBidAPI,$scope,$cookieStore,toaster,updateBidAPI){
    $scope.bidList = [];
 
    
    $scope.global = $cookieStore.get("globals") || {};

    $scope.vendorId= $scope.global.currentUser.id;

    liveBidAPI.listBid().success(function(res){
 
        $scope.bidList = res;

	});

    $scope.openModel = function(index){
        $scope.editCurrentPrice = $scope.bidList[index];
        $scope.data1.currentPrice1 =  $scope.editCurrentPrice.currentPrice;
        
    }

    $scope.changeCurrentPrice = function(){
     
        if($scope.data1.currentPrice1>$scope.editCurrentPrice.currentPrice )
        {
            $scope.editCurrentPrice.currentPrice=$scope.data1.currentPrice1;
            
            $scope.editCurrentPrice.vendorUser=$scope.global.currentUser.id;
            
            updateBidAPI.updateBidData($scope.editCurrentPrice).success(function(res){
               
                if(res){
                	 alert("Bid Created.. :)");
                	 
                	
                }
                else
                {
                	 alert("Please Refresh Your Page And Try Again..!!");
                	 
                }
                
                
                
            });
           
        }
        else
        {
            alert("Your Price Should be Grater Than Current Price..Please Try Agian..!!");
            
        }
      
    }
});
