package geoRestTest;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.Test;

import georest.Customer;
import georest.Item;

public class CustomerTest {

	    @Mock
	    Customer customer = new Customer();	   
		List<Item> listOfItems = new ArrayList<Item>();
		
	    
	    @Before
	    public void setUp() throws Exception {

	         MockitoAnnotations.initMocks(this);
	    }	    

	    @Test
	    public void calculateBillTest() {
	    	customer.setPrice(20);
	    	customer.setName("first");
	    	listOfItems.add(0, customer);
	    	listOfItems.add(1, customer);   	
	    	customer.setListOfItems(listOfItems);
	    	Assert.assertEquals(customer.calculateBill(),40);	 
	    }

	}


