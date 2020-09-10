var CropSuggestionController = angular.module('cropSuggestion-controller', ['ui.router','oc.lazyLoad']);

CropSuggestionController.controller('CropSuggestionController', function($scope,$state, $rootScope, $location,toaster,$uibModal,CropSuggestionAPI){
	
	$scope.product = [];
	CropSuggestionAPI.getDemandValue().success(function(res){
			
	$scope.product = res;
	console.log($scope.product);
	$scope.label = [];
	$scope.data = [];
	for (index = 0; index < res.length; index++) { 
    	$scope.data[index] = res[index].percentage;
    	$scope.label[index] = res[index].productName;
    	//console.log($scope.label[index]); 
	} 
			
	let myChart = document.getElementById('myChart').getContext('2d');
	
    // Global Options
    Chart.defaults.global.defaultFontFamily = 'Lato';
    Chart.defaults.global.defaultFontSize = 18;
    Chart.defaults.global.defaultFontColor = '#777';
	console.log($scope.data1);
    let massPopChart = new Chart(myChart, {
      type:'doughnut', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
      data:{
        labels:$scope.label,
        datasets:[{
          label:'Crop Demand Chart ',
          data:$scope.data,   
          //$scope.data1,
          //backgroundColor:'green',
          backgroundColor:[
            'rgba(255, 99, 132, 0.6)',
            'rgba(54, 162, 235, 0.6)',
            'rgba(255, 206, 86, 0.6)',
            'rgba(75, 192, 192, 0.6)',
            'rgba(153, 102, 255, 0.6)',
            'rgba(255, 159, 64, 0.6)',
            'rgba(255, 162, 132, 0.6)',
            'rgba(255, 99, 162, 0.6)',
            'rgba(54, 162, 235, 0.6)',
            'rgba(255, 206, 206, 0.6)',
            'rgba(75, 86, 192, 0.6)',
            'rgba(153, 102, 75, 0.6)',
            'rgba(255, 192, 64, 0.6)',
            'rgba(255, 99, 99, 0.6)'
          ],
          borderWidth:1,
          borderColor:'#777',
          hoverBorderWidth:3,
          hoverBorderColor:'#000'
        }]
      },
      options:{
        title:{
          display:true,
          text:'Crop Demand Chart',
          fontSize:25
        },
        legend:{
          display:true,
          position:'right',
          labels:{
            fontColor:'#000'
          }
        },
        layout:{
          padding:{
            left:50,
            right:0,
            bottom:0,
            top:0
          }
        },
        tooltips:{
          enabled:true
        }
      }
    });
	
			
			
			
			
			
			
	});
	
	
	
	

})

