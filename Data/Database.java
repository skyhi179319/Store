package Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.TreeMap;

public class Database {
	 public static TreeMap<String,Integer> Inventory = new TreeMap<String,Integer>();
	 public static TreeMap<String,BigDecimal> Prices = new TreeMap<String,BigDecimal>();
	 public static TreeMap<String,BigDecimal> Cost = new TreeMap<String,BigDecimal>();
	 public static ArrayList<String> Items = new ArrayList<String>();
	 public static BigDecimal Money = new BigDecimal(100.00);
	 public static BigDecimal Gained = new BigDecimal(0.00);
	 public static BigDecimal Spent = new BigDecimal(0.00);
	 public static void fillData() {
		 Inventory.put("Coffee", 0);
		 Inventory.put("Soda", 0);
		 Inventory.put("Hotdogs", 0);
		 Inventory.put("Hamburgers", 0);
		 Inventory.put("Cheeseburgers", 0);
		 Items.add("Coffee");
		 Items.add("Soda");
		 Items.add("Hotdogs");
		 Items.add("Hamburgers");
		 Items.add("Cheeseburgers");
		 Prices.put("Coffee", new BigDecimal(4.00));
		 Prices.put("Soda", new BigDecimal(1.00));
		 Prices.put("Hotdogs", new BigDecimal(3.00));
		 Prices.put("Hamburgers", new BigDecimal(3.00));
		 Prices.put("Cheeseburgers", new BigDecimal(4.00));
		 Cost.put("Coffee", new BigDecimal(3.00));
		 Cost.put("Soda", new BigDecimal(0.50));
		 Cost.put("Hotdogs", new BigDecimal(2.00));
		 Cost.put("Hamburgers", new BigDecimal(2.00));
		 Cost.put("Cheeseburgers", new BigDecimal(3.00));
	 }
	 public static void modifyInventory(String method,String item,int number) {
		 if(method == "add") {
			 int inventory = Language.Math.Sum(Inventory.get(item), number);
			 Inventory.replace(item, inventory);
		 }
		 if(method == "Subtract") {
			 int math = number - number - number;
			 int inventory = Inventory.get(item) - number;
			 Inventory.replace(item, inventory);
		 }
	 }
}