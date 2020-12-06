/**
 * 
 */
package georest;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Reggie
 *
 */
public class Customer implements Item{


	@InjectMocks 
	Item item; 
	String itemName;
	int itemPrice;

	public Customer() {};

	List<Item> listOfItems = new ArrayList<Item>();

	public int calculateBill()
	{
		int total = 0;

		for (Item item:listOfItems) {
			total+=item.getPrice();
		}
		return total;
	}

	public String getName() {
		return itemName;
	}

	public void setName(String name) {
		this.itemName = name;
	}

	//@Override
	public int getPrice() {
		return itemPrice;
	}

	//@Override
	public void setPrice(int price) {
		this.itemPrice = price;
	} 

	public List<Item> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<Item> listOfItems) {
		this.listOfItems = listOfItems;
	}
}


