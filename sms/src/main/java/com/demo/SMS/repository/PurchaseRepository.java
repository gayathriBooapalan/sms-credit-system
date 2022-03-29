package com.demo.SMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SMS.model.Purchase;
import com.demo.SMS.model.User;

public interface PurchaseRepository  extends JpaRepository<Purchase,Integer>{

	//Purchase findByPhoneNumber(Integer phonenumber);

	Purchase findByUser(User userObject);

}
