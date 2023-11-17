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

import com.example.model.CloudUser;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public List<CloudUser> getAllUser()
	{
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{id}")
    public ResponseEntity<CloudUser> getUserById(@PathVariable long id) 
	{
       Optional<CloudUser> user=userRepo.findById(id);
       if(user.isPresent())
       {
    	   return new ResponseEntity<CloudUser>(user.get(),HttpStatus.FOUND);
       }
       else
       {
    	   return new ResponseEntity<CloudUser>(HttpStatus.NOT_FOUND);  
       }
    }
	
	@PostMapping("/userAdd")
	public String addNewUser(@RequestBody CloudUser user)
	{
		userRepo.save(user);
		return "User created in database";
	}
	
	@PutMapping("/updateUsers/{id}")
	public String updateUserById(@PathVariable long id, @RequestBody CloudUser cloudUser)
	{
	    Optional<CloudUser> user = userRepo.findById((long) id);
	    if (user.isPresent()) 
	    {
	        CloudUser existUser=user.get();
	        existUser.setName(cloudUser.getName());
	        existUser.setServiceVendor(cloudUser.getServiceVendor());
	        existUser.setPhoneNumber(cloudUser.getPhoneNumber());
	        existUser.setUserStatus(cloudUser.getUserStatus());
	        // Save the updated employee in the repository
	        userRepo.save(existUser);

	        return "User details against id" +id+" is updated";
	    } 
	    else 
	    {
	        return "User Details does not exist for User id"+id;
	    }
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) 
	{
	    Optional<CloudUser> existingUserOptional = userRepo.findById(id);
	    if (existingUserOptional.isPresent()) 
	    {
	        userRepo.deleteById(id);
	        return new ResponseEntity<>("Employee with ID " + id + " has been deleted", HttpStatus.OK);
	    } 
	    else 
	    {
	        return new ResponseEntity<>("Employee with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
	}

	
}
