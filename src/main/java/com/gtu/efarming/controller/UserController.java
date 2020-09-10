package com.gtu.efarming.controller;

import java.text.ParseException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gtu.efarming.User.CropDemand;
import com.gtu.efarming.User.FarmerCropRegistration;
import com.gtu.efarming.User.FarmerDetails;
import com.gtu.efarming.User.Product;
import com.gtu.efarming.User.user;
import com.gtu.efarming.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String,Object> login(@RequestBody Map<String,Object> req)
	{
		String name = req.get("email").toString();
		String password = req.get("password").toString();
		Map<String,Object> res = userService.login(name, password);
		return res;  
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@RequestBody Map<String,Object> req)
	{
		String name = req.get("name").toString();
		String password = req.get("password").toString();
		String type = req.get("type").toString();	
		userService.register(name, password,type);
		 
	}
	@RequestMapping(value="/vendorRegistration", method = RequestMethod.POST)
	public void vendorRegister(@RequestBody Map<String,Object> req)
	{
		
		String type = "vendor";
		String fName = req.get("fName").toString();
		String mobNumber = req.get("mNum").toString();
		int age = (int)req.get("age");
		String gender  =req.get("gender").toString();
		String compName = req.get("cName").toString();
		String compReg =req.get("cReg").toString();
		String compAdd = req.get("cAdd").toString();
		String resCountry = req.get("country").toString();
		String resState = req.get("state").toString();
		String resDistrict = req.get("district").toString();
		String resSubDistrict = req.get("sDistrict").toString();
		String village = req.get("village").toString();
		String address = req.get("add").toString();
		String pin = req.get("pin").toString();
		String vendorId = req.get("idNo").toString();
		String aaNo = req.get("aaNo").toString();
		String ifsc = req.get("ifsc").toString();
		String bDetailCountry = req.get("country1").toString();
		String bDetailState = req.get("state1").toString();
		String bDetailDistrict = req.get("district1").toString();
		String bankName = req.get("bName").toString();
		String bankBranchName = req.get("bbName").toString();
		String acDetail = req.get("acNo").toString();
		String password = req.get("pass").toString();
		boolean status = false;
		System.out.println(type);
		//System.out.println(fName+" "+relationship+" "+relativeName+" "+mobNumber+" "+age+" "+caste+" "+gender+" "+farmerType+" "+resCountry+" "+resState+" "+resDistrict+" "+resSubDistrict+" "+village+" "+address+" "+pin+" "+farmerId+" "+aaNo+" "+ifsc+" "+bDetailCountry+" "+bDetailState+" "+bDetailDistrict+" "+bankName+" "+bankBranchName+" "+acDetail+" "+confirmAcDetail+" "+password);
		userService.vendorRegister(type,fName,mobNumber,age,gender,compName,compReg,compAdd,resCountry,resState,resDistrict,resSubDistrict,village,address,pin,vendorId,aaNo,ifsc,bDetailCountry,bDetailState,bDetailDistrict,bankName,bankBranchName,acDetail,password,status);
	
	}
	
	@RequestMapping(value="/cropBidRegistration", method = RequestMethod.POST)
	public void cropBidRegister(@RequestBody Map<String,Object> req) throws ParseException
	{
		int farmerId = (int)req.get("farmerId");
		String cropName = req.get("cropName").toString();
		String cropType = req.get("cropType").toString();
		int basePrice = (int)req.get("basePrice");
		String weight = req.get("weight").toString();
		String startDate = req.get("startDate").toString();
		ZonedDateTime startDate1 =  ZonedDateTime.parse(startDate); 
		
		System.out.println(startDate1);
		
		String endDate = req.get("endDate").toString();
		ZonedDateTime endDate1 =  ZonedDateTime.parse(endDate);  
		System.out.println(endDate1);
		
		String selectCountry = req.get("selectCountry").toString();
		String selectState = req.get("selectState").toString();
		String selectDistrict = req.get("selectDistrict").toString();
		String description = req.get("description").toString();
		System.out.println(farmerId);
		userService.cropBidRegister(farmerId,cropName,cropType,basePrice,weight,startDate1,endDate1,selectCountry,selectState,selectDistrict,description);	
	}
	
	@RequestMapping(value="/registerCrop", method = RequestMethod.POST)
	public void cropRegister(@RequestBody Map<String,Object> req)
	{
		int farmerId = (int)req.get("farmerId");
		String weight = req.get("weight").toString();
		float finalWeight = Float.parseFloat(weight)/1000000;
		String year = req.get("currentYear").toString();
		String soilType = req.get("soilName").toString();
		String cropName = req.get("name").toString();
		
		 userService.getCropDemandByName(cropName,finalWeight);
		 userService.RegisterCrop(farmerId,weight,year,soilType,cropName);
	}
	
	@RequestMapping(value="/farmerRegistration", method = RequestMethod.POST)
	public void farmerRegister(@RequestBody Map<String,Object> req)
	{
		
		String type = "farmer";
		String fName = req.get("fName").toString();
		String relationship = req.get("rel").toString();
		String relativeName = req.get("relNsssame").toString();
		String mobNumber = req.get("mNum").toString();
		int age = (int)req.get("age");
		String caste = req.get("caste").toString();
		String gender  =req.get("gender").toString();
		String farmerType = req.get("fType").toString();
		String resCountry = req.get("country").toString();
		String resState = req.get("state").toString();
		String resDistrict = req.get("district").toString();
		String resSubDistrict = req.get("sDistrict").toString();
		String village = req.get("village").toString();
		String address = req.get("add").toString();
		String pin = req.get("pin").toString();
		String farmerId = req.get("idNo").toString();
		String aaNo = req.get("aaNo").toString();
		String ifsc = req.get("ifsc").toString();
		String bDetailCountry = req.get("country1").toString();
		String bDetailState = req.get("state1").toString();
		String bDetailDistrict = req.get("district1").toString();
		String bankName = req.get("bName").toString();
		String bankBranchName = req.get("bbName").toString();
		String acDetail = req.get("acNo").toString();
		String confirmAcDetail = req.get("cacNO").toString();
		String password = req.get("pass").toString();
		boolean status = false;
		System.out.println(type);
		//System.out.println(fName+" "+relationship+" "+relativeName+" "+mobNumber+" "+age+" "+caste+" "+gender+" "+farmerType+" "+resCountry+" "+resState+" "+resDistrict+" "+resSubDistrict+" "+village+" "+address+" "+pin+" "+farmerId+" "+aaNo+" "+ifsc+" "+bDetailCountry+" "+bDetailState+" "+bDetailDistrict+" "+bankName+" "+bankBranchName+" "+acDetail+" "+confirmAcDetail+" "+password);
		userService.farmerRegister(type,fName,relationship,relativeName,mobNumber,age,caste,gender,farmerType,resCountry,resState,resDistrict,resSubDistrict,village,address,pin,farmerId,aaNo,ifsc,bDetailCountry,bDetailState,bDetailDistrict,bankName,bankBranchName,acDetail,password,status);
	}
	
	
	
	@RequestMapping(value = "/bidding/{id}", method = RequestMethod.GET)
	public List<FarmerCropRegistration> getFarmerBid(@PathVariable int id )
	{
		
		return userService.getFarmerBids(Integer.valueOf(id));
		 
	}
	
	@RequestMapping(value="/viewProduct", method = RequestMethod.GET)
	public List<Product> getAllProduct()
	{
		
		return userService.getAllProducts();
		 
	}
	
	/*@RequestMapping(value="/getCropNameBySoil/{soilType}", method = RequestMethod.GET)
	public List<Product> getCropNameBySoil(@PathVariable String soilType )
	{
		
		//System.out.println("soiltype = "+soilType);
		return userService.getAllProductsByName(soilType);
		 
	}*/
	
	@RequestMapping(value="/getCropDemandBySoil/{soilType}", method = RequestMethod.GET)
	public List<CropDemand> getCropDemandBySoil(@PathVariable String soilType )
	{
		
		//System.out.println("soiltype = "+soilType);
		return userService.getCropDemandBySoil(soilType);
		 
	}
	
	@RequestMapping(value="/getCropDemand", method = RequestMethod.GET)
	public List<CropDemand> getCropDemand()
	{
		
		return userService.getCropDemand();
	}
	
	@RequestMapping(value="/setPercentage", method = RequestMethod.GET)
	public List<CropDemand> setPercentage()
	{
		float totalDemand = 0;
		List<CropDemand> cropDemand =  userService.getCropDemand();
		for(int i = 0; i < cropDemand.size(); i++)
		{
			totalDemand = totalDemand + Float.parseFloat(cropDemand.get(i).getDemand());
		}
		for(int i = 0; i < cropDemand.size(); i++)
		{
			float percentage = (Float.parseFloat(cropDemand.get(i).getDemand())*100)/totalDemand;
			cropDemand.get(i).setPercentage(percentage);
		}
		
		userService.setPercentage(cropDemand);
		return cropDemand;
		
	}
	
	@RequestMapping(value = "/liveBid", method = RequestMethod.GET)
	public List<FarmerCropRegistration> getAllLiveBid()
	{
		
		return userService.getAllLiveBids();
		 
	}
	
	@RequestMapping(value = "/allBid", method = RequestMethod.GET)
	public List<FarmerCropRegistration> getAllBid()
	{
		
		return userService.getAllBids();
		 
	}
	@RequestMapping(value = "/vendorBidHistory/{id}", method = RequestMethod.GET)
	public List<FarmerCropRegistration> getVendorBidHistory(@PathVariable int id )
	{
		
		return userService.getVendorBidHitory(Integer.valueOf(id));
		 
	}
	
	@RequestMapping(value = "/requestVendorList", method = RequestMethod.GET)
	public List<user> getAllVendorList()
	{
		String type = "vendor";
		boolean status = false;
		return userService.getAllVendor(type,status);
		 
	}
	
	@RequestMapping(value="/updateBidValue", method = RequestMethod.POST)
	public boolean updateBidValue(@RequestBody Map<String,Object> req)
	{
		int id = (int)req.get("id");
		int vendorId = (int)req.get("vendorUser");
		long currentPrice = (int)req.get("currentPrice");
				
		boolean status = userService.updateBid(id,vendorId,currentPrice);
		return status;
		
	}
	
	@RequestMapping(value = "/requestFarmerDetailList", method = RequestMethod.GET)
	public List<FarmerDetails> getAllFarmerDetailList()
	{
		String type = "farmer";
		boolean status = false;
		return userService.getAllFarmerDetail(type,status);
		 
	}
	
	@RequestMapping(value="/updateFarmerStatus", method = RequestMethod.POST)
	public void updateFarmerStatus(@RequestBody Map<String,Object> req)
	{
		long id = Long.parseLong((req.get("id").toString()));
		 
		boolean status = Boolean.parseBoolean(req.get("status").toString());
		
		//System.out.println(status);
		 userService.updateFarmerListStatus(id,status);
			
		
		
	}
	
	@RequestMapping(value = "/vendorDetailsForBid/{id}", method = RequestMethod.GET)
	public List<FarmerCropRegistration> getVendorDetailsForBid(@PathVariable int id )
	{
	
		return userService.getVendorDetailsForBid(Integer.valueOf(id));
		 
	}
	
}
