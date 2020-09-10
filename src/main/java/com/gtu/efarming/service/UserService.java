package com.gtu.efarming.service;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtu.efarming.User.CropDemand;
import com.gtu.efarming.User.CropRegister;
import com.gtu.efarming.User.FarmerCropRegistration;
import com.gtu.efarming.User.FarmerDetails;
import com.gtu.efarming.User.Product;
import com.gtu.efarming.User.VendorDetails;
import com.gtu.efarming.User.user;
import com.gtu.efarming.repository.BidingRepository;
import com.gtu.efarming.repository.CropDemandRepository;
import com.gtu.efarming.repository.CropRegisterRepository;
import com.gtu.efarming.repository.FarmerCropRepository;
import com.gtu.efarming.repository.FarmerDetailsRepository;
import com.gtu.efarming.repository.ProductRepository;
import com.gtu.efarming.repository.UserRepository;
import com.gtu.efarming.repository.VendorDetailsRepository;

@Service
public class UserService {
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired 
	BidingRepository bidingRepo;
	
	@Autowired
	CropRegisterRepository cropRepo;
	
	@Autowired
	FarmerDetailsRepository farmerDetailsRepo;
	
	@Autowired
	VendorDetailsRepository vendorDetailsRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CropDemandRepository demandRepo;
	
	@Autowired
	FarmerCropRepository farmerCropRepo;

public Map<String,Object> login(String name,String password)
{
	Map<String,Object> res = new HashMap<>();
	user data = userRepository.findOneByNameAndPassword(name,password);
	
	if(data != null) {
		res.put("user", data);
		res.put("status",true);
	}else {
		res.put("status",false);
	}
			return res;
}

public void register(String name,String password,String type)
{
	user data = new user();
	data.setName(name);
	data.setPassword(password);
	data.setType(type);
	userRepository.save(data);
}


public void vendorRegister(String type,String name,String mobNumber,int age,String gender,String compName,String compReg,String compAdd,String resCountry,String resState,String resDistrict,String resSubDistrict,String village,String address,String pin,String vendorId,String aaNo,String ifsc,String bDetailCountry,String bDetailState,String bDetailDistrict,String bankName,String bankBranchName,String acDetail,String password,boolean status)
{
	user uData = new user();
	uData.setName(name);
	uData.setPassword(password);
	uData.setType(type);
	uData.setMno(mobNumber);
	uData.setAge(age);
	uData.setGender(gender);
	uData.setCountry(resCountry);
	uData.setState(resState);
	uData.setDistrict(resDistrict);
	uData.setSubdistrict(resSubDistrict);
	uData.setVillage(village);
	uData.setAddress(address);
	uData.setPincode(pin);
	uData.setAano(aaNo);
	uData.setIfsc(ifsc);
	uData.setBcountry(bDetailCountry);
	uData.setBstate(bDetailState);
	uData.setBdistrict(bDetailDistrict);
	uData.setBname(bankName);
	uData.setBbname(bankBranchName);
	uData.setAcno(acDetail);
	uData.setStatus(status);
	
	userRepository.save(uData);
	
	
	long user_id = uData.getId();
	
	VendorDetails data = new VendorDetails();
	data.setUser(new user(user_id));
	data.setCompName(compName);
	data.setCompRegNo(compReg);
	data.setCompAdd(compAdd);
	data.setVendorId(vendorId);
	
	vendorDetailsRepo.save(data);
	
	

}
public void cropBidRegister(int farmerId,String cropName,String cropType,int basePrice,String weight,ZonedDateTime startDate,ZonedDateTime endDate,String selectCountry,String selectState,String selectDistrict,String description)
{
	
	FarmerCropRegistration data = new FarmerCropRegistration();
	data.setUser(new user(farmerId));
	data.setCropName(cropName);
	data.setCropType(cropType);
	data.setBasePrice(basePrice);
	long currentPrice = (Integer.parseInt(weight)/100)*basePrice;
	data.setCurrentPrice(currentPrice);
	data.setWeight(weight);
	data.setStartDate(startDate);
	data.setEndDate(endDate);
	data.setSelectCountry(selectCountry);
	data.setSelectState(selectState);
	data.setSelectDistrict(selectDistrict);
	data.setDescription(description);
	cropRepo.save(data);

}

public void getCropDemandByName(String cropName,float finalWeight)
{
	CropDemand data = demandRepo.findByProductName(cropName);
	float register = data.getRegister();
	
	float totalRegister = register + finalWeight;
	data.setRegister(totalRegister);
	demandRepo.save(data);
	
}


public void RegisterCrop(int farmerId,String weight,String year,String soilType,String cropName)
{
	
	Product productData = productRepo.findByProductName(cropName);
	Long productId = productData.getId();
	
	CropRegister data = new CropRegister();
	data.setUser(new user(farmerId));
	data.setProduct(new Product(productId));
	float weight1 = Float.parseFloat(weight);
	data.setWeight(weight1);
	data.setSoilType(soilType);
	data.setYear(year);
	
	farmerCropRepo.save(data);
	
	
	
	
}


public void farmerRegister(String type,String name,String relationship,String relativeName,String mobNumber,int age,String caste,String gender,String farmerType,String resCountry,String resState,String resDistrict,String resSubDistrict,String village,String address,String pin,String farmerId,String aaNo,String ifsc,String bDetailCountry,String bDetailState,String bDetailDistrict,String bankName,String bankBranchName,String acDetail,String password,boolean status)
{
	user uData = new user();
	uData.setName(name);
	uData.setPassword(password);
	uData.setType(type);
	uData.setMno(mobNumber);
	uData.setAge(age);
	uData.setGender(gender);
	uData.setCountry(resCountry);
	uData.setState(resState);
	uData.setDistrict(resDistrict);
	uData.setSubdistrict(resSubDistrict);
	uData.setVillage(village);
	uData.setAddress(address);
	uData.setPincode(pin);
	uData.setAano(aaNo);
	uData.setIfsc(ifsc);
	uData.setBcountry(bDetailCountry);
	uData.setBstate(bDetailState);
	uData.setBdistrict(bDetailDistrict);
	uData.setBname(bankName);
	uData.setBbname(bankBranchName);
	uData.setAcno(acDetail);
	uData.setStatus(status);
	
	userRepository.save(uData);
	
	long user_id = uData.getId();
	
	
	FarmerDetails data = new FarmerDetails();
	data.setUser(new user(user_id));
	data.setRelationship(relationship);
	data.setRelname(relativeName);
	data.setCaste(caste);
	data.setFtype(farmerType);
	data.setVfno(farmerId);
	
	farmerDetailsRepo.save(data);
	
	

}

public List<FarmerCropRegistration> getFarmerBids(int id) {
	// TODO Auto-generated method stub
	return cropRepo.findByUserId(Long.valueOf(id));
}

public List<FarmerCropRegistration> getVendorBidHitory(int id) {
	
	return cropRepo.findByVendorId(Long.valueOf(id));
}

public List<FarmerCropRegistration> getVendorDetailsForBid(int id) {
	// TODO Auto-generated method stub
	return cropRepo.findByIdAndDate(Long.valueOf(id),ZonedDateTime.now());
}

public List<Product> getAllProducts() {
	// TODO Auto-generated method stub
	return productRepo.findAll();
}

public List<Product> getAllProductsByName(String soilType) {
	// TODO Auto-generated method stub
	return productRepo.findBySoilType(soilType);
}

public List<CropDemand> getCropDemand() {
	// TODO Auto-generated method stub
	
	return demandRepo.findAll();
}

public List<CropDemand> getCropDemandBySoil(String soilType) {
	// TODO Auto-generated method stub
	
	return demandRepo.findBySoilType(soilType);
}

public void setPercentage(List<CropDemand> addPercentage) {
	// TODO Auto-generated method stub
	
	 demandRepo.saveAll(addPercentage);
}

public List<FarmerCropRegistration> getAllLiveBids(){
	
	return cropRepo.findAllLiveBids(ZonedDateTime.now());
	
}

public List<FarmerCropRegistration> getAllBids(){
	
	return cropRepo.findAllBids(ZonedDateTime.now());
	
}


public List<user> getAllFarmer(String type,boolean status){
	
	
	return userRepository.findByTypeAndStatus(type,status);
	
}

public List<user> getAllVendor(String type,boolean status){
	
	
	return userRepository.findByTypeAndStatus(type,status);
	
}

public boolean updateBid(int id,int vendorId,long currentPrice){
	
	System.out.println(id+" , "+vendorId+" , "+currentPrice);
	
	FarmerCropRegistration data1 = cropRepo.findById(id);
	data1.setVendorUser(new user(vendorId));
	data1.setCurrentPrice(currentPrice);
	
	ZonedDateTime startDate = data1.getStartDate();
	ZonedDateTime endDate = data1.getEndDate();
	
	ZonedDateTime currentDate = ZonedDateTime.now();
	
	if(currentDate.isAfter(startDate) && currentDate.isBefore(endDate))
	{
		
		cropRepo.save(data1);
		return true;
	}
	else
	{
		
		return false;
	}
	//cropRepo.updateCurrentPriceAndVendorId(id,vendorId,currentPrice);
	 
	
	
}

public List<FarmerDetails> getAllFarmerDetail(String type,boolean status){
	
	
	return farmerDetailsRepo.findByTypeAndStatus(type,status);
	
}

public void updateFarmerListStatus(long id,boolean status){
	
	
	
	user data1 = userRepository.findById(id);
	data1.setStatus(status);
	
	userRepository.save(data1);
	
	
	
}




}
