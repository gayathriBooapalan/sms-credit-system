package com.demo.SMS.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.SMS.exception.ResourceNotFoundException;
import com.demo.SMS.model.Purchase;
import com.demo.SMS.model.User;
import com.demo.SMS.repository.PurchaseRepository;
import com.demo.SMS.repository.UserRepository;
import com.demo.SMS.service.PurchaseService;
import com.demo.SMS.service.UserService;
@Service
@Component
public class UserServiceImpl implements UserService,PurchaseService{
	@Autowired
	private UserRepository userRepository;
	private PurchaseRepository purchaseRepository;
	
	public UserServiceImpl()
	{
		
	}
	@Autowired
	public UserServiceImpl(PurchaseRepository purchaseRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
		
	}
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@Override
	public User createUser(User user)
	  	{
		//calls save CRUD method of jpaREpositroy
		 	return userRepository.save(user);
		
			
		}
		
		//To find whether USer is enabled to  buy purchase,check credit flag.
	  public User getCreditFlag(Integer phonenumber)
	  { 
		  	 
	  
		  return userRepository.findById(phonenumber).orElseThrow(()-> new
				  ResourceNotFoundException("User","id",phonenumber)); }
	 

	public Purchase createPurchase(Purchase purchase,Integer phonenumber) throws Exception {
		// TODO Auto-generated method stub
		User userObject=new User();
		userObject.setPhoneNumber(phonenumber);
		Optional<User> userObject1=userRepository.findById(phonenumber);
		if(userObject1.isPresent())
		{
			
		System.out.println("in impl");
		Purchase existingPurchase=purchaseRepository.findByUser(userObject);
		if(existingPurchase ==null)
		{
			
				LocalDate todayDate=LocalDate.now();
				LocalDate expiryDate=LocalDate.now().plusDays(30);
				System.out.println("expiryDate:"+expiryDate);
				User user=purchase.getUser();
				if(userObject1.get().getCreditFlag() == true)
				{
					purchase.setCreditPoints(100);
					purchase.setPurchasedate(todayDate);
					purchase.setExpiryDate(expiryDate);
					purchase.setUser(userObject1.get());
					
					
				     return purchaseRepository.save(purchase);
				}
				else
				{
					System.out.println("you cannot buy credit");
					throw new Exception("You are not elligible to buy credit" );
				}
				
		}
		else
		{
			LocalDate todayDate=LocalDate.now();
		  //Check if credit Flag is enabled
			if(existingPurchase.getUser().getCreditFlag() == true)
			{
				//IF expiry date is before todays date ,alert user to buy credit
				if(existingPurchase.getExpiryDate().isBefore(todayDate) )
				{
					throw new Exception("Your credit date is expired.Please buy Credit!!");
				}else
				{
				//check if previous month's credit point is greater than 50 
				//if yes,add to the current credit
				 if(existingPurchase.getCreditPoints()>50)
				 {
					 existingPurchase.setPurchasedate(todayDate);
						existingPurchase.setExpiryDate(todayDate.plusDays(30));
						existingPurchase.setCreditPoints(100+existingPurchase.getCreditPoints());
						return purchaseRepository.save(existingPurchase);
				 }
				 else
				 {
					 existingPurchase.setCreditPoints(100);
						existingPurchase.setPurchasedate(todayDate);
						existingPurchase.setExpiryDate(todayDate.plusDays(30));
								
				        return purchaseRepository.save(existingPurchase);
				 }
			}
		}
		
	}
		}
		else {
			System.out.println("user id not found");
			throw new Exception("User is not registered");
		}
		return purchase;
	}
}


