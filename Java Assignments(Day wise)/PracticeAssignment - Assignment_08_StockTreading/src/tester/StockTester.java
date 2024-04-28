package tester;

import static utils.Utility.*;

public class StockTester {

	public static void main(String[] args) {

		boolean flag = false;
		populateMap();
		while (!flag) {
			System.out.println(
					"Press 1 to add stock\nPress 2 to Display All Available Stocks of a particular company\nPress 3 to Purchase Stocks\n"
							+ "Press 4 to Sell Stocks\nPress 5 Store Stock Map into Binary File\nPress 6 to read Data from .ser file");
			try {
				switch (sc.nextInt()) {
				case 1:
					addStock();
					break;
				case 2:
					displayAvailabaleStocksByCompanyName();
					break;
				case 3:
					purchaseStocks();
					break;
				case 4:
					sellStocks();
					break;

				case 5:
					storeStockMap();
					break;

				case 6:
					readSerializedStockMapDetails();
					break;

				case 7:
					stockMap.values().stream().forEach(i -> System.out.println(i));
					break;
				case 8:
					flag = true;
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
