package Assets;

import java.math.BigDecimal;
import java.util.Random;

import javax.swing.JLabel;

public class Automation {
	public static void run(JLabel label) {
		int coffeeIn = Data.Database.Inventory.get("Coffee");
		int sodaIn = Data.Database.Inventory.get("Soda");
		int hotdogsIn = Data.Database.Inventory.get("Hotdogs");
		int hamburgerIn = Data.Database.Inventory.get("Hamburgers");
		int cheeseburgerIn = Data.Database.Inventory.get("Cheeseburgers");
		if(coffeeIn == 0) {
			
		}
		else {
			Random rand = new Random();
			int out = rand.nextInt(coffeeIn);
			Data.Database.modifyInventory("Subtract", "Coffee", out);
			Assets.Money.pay(Assets.Money.giveMoney("Coffee", out));
		}
		if(sodaIn == 0) {
			
		}
		else {
			Random rand = new Random();
			int out = rand.nextInt(sodaIn);
			Data.Database.modifyInventory("Subtract", "Soda", out);
			Assets.Money.pay(Assets.Money.giveMoney("Soda", out));
		}
		if(hotdogsIn == 0) {
			
		}
		else {
			Random rand = new Random();
			int out = rand.nextInt(hotdogsIn);
			Data.Database.modifyInventory("Subtract", "Hotdogs", out);
			Assets.Money.pay(Assets.Money.giveMoney("Hotdogs", out));
		}
		if(hamburgerIn == 0) {
			
		}
		else {
			Random rand = new Random();
			int out = rand.nextInt(hamburgerIn);
			Data.Database.modifyInventory("Subtract", "Hamburgers", out);
			Assets.Money.pay(Assets.Money.giveMoney("Hamburgers", out));
		}
		if(cheeseburgerIn == 0) {
			
		}
		else {
			Random rand = new Random();
			int out = rand.nextInt(cheeseburgerIn);
			Data.Database.modifyInventory("Subtract", "Cheeseburgers", out);
			Assets.Money.pay(Assets.Money.giveMoney("Cheeseburgers", out));
		}
		label.setText("$" + Assets.Money.stringMoney(Data.Database.Money));
		System.out.print(Data.Database.Inventory);
	}
}