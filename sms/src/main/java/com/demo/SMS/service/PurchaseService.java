package com.demo.SMS.service;

import com.demo.SMS.model.Purchase;

public interface PurchaseService {
	

	Purchase createPurchase(Purchase purchase, Integer phonenumber) throws Exception;
	
}
