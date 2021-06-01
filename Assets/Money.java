package Assets;

import java.math.BigDecimal;
import java.math.MathContext;

import javax.swing.JLabel;

import Language.Console;

public class Money {
	public static String stringMoney(BigDecimal money) {
		return money.setScale(2).toString();
	}
	public static BigDecimal giveMoney(String Item, int Amount) {
		BigDecimal item = Data.Database.Prices.get(Item);
		BigDecimal amount = new BigDecimal(Amount);
		return item.multiply(amount);
	}
	public static void pay(BigDecimal Amount) {
		Data.Database.Money = Data.Database.Money.add(Amount);
		Data.Database.Gained = Data.Database.Gained.add(Amount);
	}
	public static void buyItem(String Item,JLabel Money) {
		BigDecimal cost = Data.Database.Money.subtract(Data.Database.Cost.get(Item));
		Data.Database.Money = cost;
		BigDecimal spent = Data.Database.Cost.get(Item);
		Data.Database.Spent = Data.Database.Spent.add(spent);
		Money.setText(stringMoney(Data.Database.Money));
	}
}