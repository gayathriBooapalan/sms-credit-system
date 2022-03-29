package com.demo.SMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SMS.model.Purchase;
import com.demo.SMS.model.User;
import com.demo.SMS.service.UserService;
import com.demo.SMS.service.PurchaseService;
@RestController
@RequestMapping("/api/phoneUser")
public class UserController {
	@Autowired
	private UserService userService;
	private PurchaseService purchaseService;
	
	public UserController()
	{
		
	}
	@Autowired
	public UserController(PurchaseService purchaseService) {
		super();
		this.purchaseService = purchaseService;
	}

	
	  public UserController(UserService userService) { super(); this.userService =
	  userService; }
	 
	  //to update purchase details  in Purchase table 
	  @PutMapping("/{id}")
	  public ResponseEntity<Purchase>
	  updatePurchase(@PathVariable("id") int phoneNumber,Purchase purchase) throws Exception {
	  return new ResponseEntity<Purchase>(purchaseService.createPurchase(purchase,
	  phoneNumber), HttpStatus.OK); }
	 
	  //To create User in User Table
	  @PostMapping 
	  public ResponseEntity<User> createUser( @RequestBody User user)
	  { return new ResponseEntity<User>(userService.createUser(user),
	  HttpStatus.CREATED); }
	  
		
	 
}
