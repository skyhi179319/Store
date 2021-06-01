import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigDecimal;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Assets.Automation;
import Components.Bundle;
import Components.Table.Tables;
import Language.Application;
import Language.Console;

public class Program {
	static TreeMap<String,JButton> TableData = new TreeMap<String,JButton>();
	public static TreeMap<String,String> inventoryData() {
		TreeMap<String,String> data = new TreeMap<String,String>();
		for (String i : Data.Database.Inventory.keySet()) {
			data.put(i, Data.Database.Inventory.get(i).toString());
	    }
		return data;
	}
	public static void fillBuyTable(DefaultTableModel buyModel) {
		Object[] Coffee = {Data.Database.Items.get(0)};
		Object[] Soda = {Data.Database.Items.get(1)};
		Object[] Hotdogs = {Data.Database.Items.get(2)};
		Object[] Hamburgers = {Data.Database.Items.get(3)};
		Object[] Cheeseburgers = {Data.Database.Items.get(4)};
		buyModel.addRow(Coffee);
		buyModel.addRow(Soda);
		buyModel.addRow(Hotdogs);
		buyModel.addRow(Hamburgers);
		buyModel.addRow(Cheeseburgers);
	}
	public static void fillInvTable(String method,DefaultTableModel InvModel) {
		if(method == "start") {
			for (String i : inventoryData().keySet()) {
		         Object[] set = {i,inventoryData().get(i)};
		         InvModel.addRow(set);
		    }
		}
		if(method == "update") {
			int rowCount = InvModel.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
            	InvModel.removeRow(i);
            }
			for (String i : inventoryData().keySet()) {
		         Object[] set = {i,inventoryData().get(i)};
		         InvModel.addRow(set);
		    }
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data.Database.fillData();
		DefaultTableModel InvModel = new DefaultTableModel();
		String[] TabsString = {"Info","Actions","Buy","Inventory"};
		JPanel MoneyJPanel = new JPanel();
		JLabel Money = new Components.Label("$" + Assets.Money.stringMoney(Data.Database.Money), Colors.colors.Black);
		MoneyJPanel.add(Money);
		// ACTIONS
		JPanel Actions = new JPanel();
		Actions.add(new Components.Button(28, "Sim", true, Colors.colors.Black, Colors.colors.silver, new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Automation.run(Money);
				fillInvTable("update",InvModel);
			}
		}));
		Actions.add(new Components.Button(24, "Money", true, Colors.colors.Black, Colors.colors.silver, new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel Money = new JPanel();
				JLabel stats = new Components.Label("Money Gained: $" + Data.Database.Gained + " - Money Spent: $" + Data.Database.Spent, Colors.colors.blue);
				Money.add(stats);
				Timer myTimer = new Timer(1000, new ActionListener(){
				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	stats.setText("Money Gained: $" + Data.Database.Gained + " - Money Spent: $" + Data.Database.Spent);
				    }
				});
				myTimer.start();
				JFrame game = new Components.Window(150, 150, 1000, 550, "Money", new JPanel(), new JPanel(), new JPanel(), new JPanel(), Money);
			}
		}));
		// Inventory
		String[] InvColumns = {"Item","Amount"};
		JPanel InvTable = new JPanel();
		JTable inv;
		inv = new JTable(InvModel) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
		};
		JScrollPane Invsp = new JScrollPane(inv);
		Invsp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
		InvTable.add(Invsp);
		for (int i = 0; i < InvColumns.length; i++) {
			InvModel.addColumn(InvColumns[i]);
		}
		fillInvTable("start",InvModel);
		// Buy TABLE
		String[] BuyColumns = {"Item"};
		DefaultTableModel buyModel = new DefaultTableModel();
		JPanel BuyTable = new JPanel();
		JTable buy;
		buy = new JTable(buyModel) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
		};
		JScrollPane buysp = new JScrollPane(buy);
		buysp.getVerticalScrollBar().setBackground(Colors.colors.lightblue);
		BuyTable.add(buysp);
		for (int i = 0; i < BuyColumns.length; i++) {
			buyModel.addColumn(BuyColumns[i]);
		}
		fillBuyTable(buyModel);
		buy.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		JTable target = (JTable)e.getSource();
	    		int row = target.getSelectedRow();
	    		int columns = target.getSelectedColumn();
	    		if(buy.getValueAt(row, columns) == "Coffee") {
	    			if(Data.Database.Money.intValue() > Data.Database.Cost.get("Coffee").intValue()) {
	    				Data.Database.modifyInventory("add", "Coffee", 1);
	    				Assets.Money.buyItem("Coffee", Money);
	    				fillInvTable("update",InvModel);
	    			}
	    			else {
	    				
	    			}
	    		}
	    		if(buy.getValueAt(row, columns) == "Soda") {
	    			if(Data.Database.Money.intValue() > Data.Database.Cost.get("Soda").intValue()) {
	    				Data.Database.modifyInventory("add", "Soda", 1);
	    				Assets.Money.buyItem("Soda", Money);
	    				fillInvTable("update",InvModel);
	    			}
	    			else {
	    				
	    			}
	    		}
	    		if(buy.getValueAt(row, columns) == "Hotdogs") {
	    			if(Data.Database.Money.intValue() > Data.Database.Cost.get("Hotdogs").intValue()) {
	    				Data.Database.modifyInventory("add", "Hotdogs", 1);
	    				Assets.Money.buyItem("Hotdogs", Money);
	    				fillInvTable("update",InvModel);
	    			}
	    			else {
	    				
	    			}
	    		}
	    		if(buy.getValueAt(row, columns) == "Hamburgers") {
	    			if(Data.Database.Money.intValue() > Data.Database.Cost.get("Hamburgers").intValue()) {
	    				Data.Database.modifyInventory("add", "Hamburgers", 1);
	    				Assets.Money.buyItem("Hamburgers", Money);
	    				fillInvTable("update",InvModel);
	    			}
	    			else {
	    				
	    			}
	    		}
	    		if(buy.getValueAt(row, columns) == "Cheeseburgers") {
	    			if(Data.Database.Money.intValue() > Data.Database.Cost.get("Cheeseburgers").intValue()) {
	    				Data.Database.modifyInventory("add", "Cheeseburgers", 1);
	    				Assets.Money.buyItem("Cheeseburgers", Money);
	    				fillInvTable("update",InvModel);
	    			}
	    			else {
	    				
	    			}
	    		}
	    	}
	    });
		// TABS
		JPanel[] Tabs = {MoneyJPanel,Actions,BuyTable,InvTable};
		Color[] Foreground = {Colors.colors.Black,Colors.colors.Black,Colors.colors.Black,Colors.colors.Black};
		Components.Tabs Tab = new Components.Tabs(TabsString, Tabs, Foreground, 500, 500);
		// WINDOW
		JFrame game = new Components.Window(150, 150, 1000, 550, "Store", new JPanel(), new JPanel(), new JPanel(), new JPanel(), Tab);
	}
}