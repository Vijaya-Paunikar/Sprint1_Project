package com.example.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CloudVendor;
import com.example.repository.VendorRepository;

@RestController
@RequestMapping("/api/vendor")
public class VendorController 
{
	@Autowired
	private VendorRepository vendorRepo;
	
	@GetMapping("/vendors")
	public List<CloudVendor> getAllUser()
	{
		return vendorRepo.findAll();
	}
	
	@GetMapping("/vendors/{id}")
    public ResponseEntity<CloudVendor> getVendorById(@PathVariable long id) 
	{
       Optional<CloudVendor> vendor=vendorRepo.findById(id);
       if(vendor.isPresent())
       {
    	   return new ResponseEntity<CloudVendor>(vendor.get(),HttpStatus.FOUND);
       }
       else
       {
    	   return new ResponseEntity<CloudVendor>(HttpStatus.NOT_FOUND);  
       }
    }
	
	@PostMapping("/vendorAdd")
	public String addNewUser(@RequestBody CloudVendor vendor)
	{
		vendorRepo.save(vendor);
		return "Vendor created in database";
	}
	
	@PutMapping("/updateVendors/{id}")
	public String updateVendorById(@PathVariable long id, @RequestBody CloudVendor cloudVendor)
	{
	    Optional<CloudVendor> vendor = vendorRepo.findById((long) id);
	    if (vendor.isPresent()) 
	    {
	        CloudVendor existVendor=vendor.get();
	        existVendor.setVendorName(cloudVendor.getVendorName());
	        existVendor.setDescription(cloudVendor.getDescription());
	        existVendor.setPhoneNumber(cloudVendor.getPhoneNumber());
	        existVendor.setStatus(cloudVendor.getStatus());
	        // Save clothe updated employee in the repository
	        vendorRepo.save(existVendor);
	        
	        return "Vendor details against id " +id+" is updated";
	    } 
	    else 
	    {
	        return "Vendor Details does not exist for Vendor id "+id;
	    }
	}
	
	@DeleteMapping("/deleteVendor/{id}")
	public ResponseEntity<String> deleteVendor(@PathVariable long id) 
	{
	    Optional<CloudVendor> existingVendorOptional = vendorRepo.findById(id);
	    if (existingVendorOptional.isPresent()) 
	    {
	        vendorRepo.deleteById(id);
	        return new ResponseEntity<>("Vendor with ID " + id + " has been deleted", HttpStatus.OK);
	    } 
	    else 
	    {
	        return new ResponseEntity<>("Vendor with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
	}

}