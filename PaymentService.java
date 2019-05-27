/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Order;
import java.util.HashMap;
import java.util.Map;
//import PIMobile.Entite.Utilisateur;


/**
 *
 * @author Cascada
 */
public class PaymentService {
    private static final String TEST_STRIPE_SECRET_KEY = "sk_test_EeYQYfd1wgRMzAblUkrA4kbZ005GCUadNY";
    public PaymentService() {
    Stripe.apiKey = TEST_STRIPE_SECRET_KEY;
  }

    
    public String createCustomer() {
        Map<String, Object> customerParams = new HashMap<String, Object>();
    customerParams.put("description","amara" +"amara" + "amara");
	customerParams.put("email","mohamedahmed.benamara@esprit.tn");
		
	String id = null;
		
	try { 
      // Create customer
	  Customer stripeCustomer = Customer.create(customerParams);
	  id = stripeCustomer.getId();
	  System.out.println(stripeCustomer);
	} catch (CardException e) {
	  // Transaction failure
	}catch (RateLimitException e) {
	  // Too many requests made to the API too quickly
	} catch (AuthenticationException e) {
	  // Authentication with Stripe's API failed (wrong API key?)
	} 
        catch (StripeException e) {
	  // Generic error
	} catch (Exception e) {
	// Something else happened unrelated to Stripe
	}
	       System.out.println(id);
    return id;
    
    }

    
    public void chargeCreditCard(Order order,String freelancer,String jobT) {
       // Stripe requires the charge amount to be in cents
    long chargeAmountCents =  order.getAmount();

   

	Map<String, Object> chargeParams = new HashMap<String, Object>();
	chargeParams.put("amount",order.getAmount());
	chargeParams.put("currency", "usd");
	chargeParams.put("description", "You Payed the Freelancer "+freelancer+" for the opportunity "+jobT);		
	chargeParams.put("customer", "cus_F1KOD3rfSyNn2o");
			
	try {
	  // Submit charge to credit card 
	  Charge charge = Charge.create(chargeParams);
      System.out.println(charge);
    } catch (CardException e) {
	  // Transaction was declined
	  System.out.println("Status is: " + e.getCode());
	  System.out.println("Message is: " + e.getMessage());
	} catch (RateLimitException e) {
	  // Too many requests made to the API too quickly
	} catch (InvalidRequestException e) {
	  // Invalid parameters were supplied to Stripe's API
    } catch (AuthenticationException e) {
	  // Authentication with Stripe's API failed (wrong API key?)
	} catch (APIConnectionException e) {
	  // Network communication with Stripe failed
	 } catch (StripeException e) {
	  // Generic error
	} catch (Exception e) {
	  // Something else happened unrelated to Stripe
	}	
    }
    
}
