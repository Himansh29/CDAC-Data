package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entity.Stock;
import exceptions.InvalidStockException;
import validations.StockValidations;

public interface Utility {

	public static Map<String, Stock> stockMap = new HashMap<>();
	public static Scanner sc = new Scanner(System.in);

	public static void addStock() throws InvalidStockException {

		System.out.println("Enter Stock Id");
		String stockId = sc.next();

		System.out.println("Enter Stock Name");
		String stockName = sc.next();

		System.out.println("String company Name");
		String companyName = sc.next();

		System.out.println("Enter price of stock");
		double price = sc.nextDouble();

		System.out.println("Enter closing date of stock");
		String date = sc.next();

		System.out.println("Enter Quantity");
		int quantity = sc.nextInt();

		stockMap.putAll(StockValidations.validateData(stockId, stockName, companyName, price, date, quantity, stockMap));

		System.out.println("Stock added successfully");
	}

	public static void displayAvailabaleStocksByCompanyName() {
		System.out.println("Enter Company Name");
		String CompanyName = sc.next();

		stockMap.values().stream().filter(i -> i.getCompanyName().equals(CompanyName))
				.forEach(i -> System.out.println(i));
	}

	public static void purchaseStocks() throws InvalidStockException {
		System.out.println("Enter stock id");
		String stockId = sc.next();

		System.out.println("Enter the quantity");
		int quantity = sc.nextInt();

//		if (stockMap.containsKey(stockId)) {
//			Stock stock = stockMap.get(stockId);
//			stock.setQuantity(stock.getQuantity() + quantity);
//			System.out.println("Stocks Bought");
//		}else {
//			throw new InvalidStockException("Invalid Stock Id");
//		}
		Stock stock = stockMap.get(stockId);
		if(stock != null) {
			int totalStocksBought = stock.getQuantity() + quantity;
			stock.setQuantity(totalStocksBought);
			System.out.println("Total " + quantity + " Stocks of " + stock.getCompanyName() + " Bought Successfully ");
		}else {
			throw new InvalidStockException("Invalid Stock Id");
		}
		
		
	}

	public static void sellStocks() throws InvalidStockException {
		System.out.println("Enter stock id");
		String stockId = sc.next();

		System.out.println("Enter the quantity");
		int quantity = sc.nextInt();
		
		Stock stock = stockMap.get(stockId);
		if(stock != null) {
			if(stock.getQuantity() >= quantity) {
				int stocksBought = stock.getQuantity()-quantity;
				stock.setQuantity(stocksBought);
				System.out.println("Stock Sold successfully" + " Remaining Stocks: " + stocksBought);
			}else {
				throw new InvalidStockException("Insufficient Stocks!!");
			}
		}else {
			throw new InvalidStockException("Stock with id " + stockId + "Doesn't exist!");
		}
		
		

//		if (stockMap.containsKey(stockId)) {
//			Stock stock = stockMap.get(stockId);
//			if (stock.getQuantity() >= quantity) {
//				stock.setQuantity(stock.getQuantity() - quantity);
//				System.out.println("Stocks sold successfully");
//			} else {
//				throw new InvalidStockException("Insufficient Stock quantity!!");
//			}
//		} else {
//			throw new InvalidStockException("Invalid Stock Id!!!");
//		}
	}

	public static void storeStockMap() throws FileNotFoundException, IOException {

		System.out.println("Enter fileName.ser to store the binary stream");
		try (ObjectOutputStream serializeMap = new ObjectOutputStream(new FileOutputStream(sc.next()))) {
			serializeMap.writeObject(stockMap);
			System.out.println("Stock map stored successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readSerializedStockMapDetails()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Enter fileName.ser from which you want to read the object");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(sc.next()));
		Object de_serializedObject = in.readObject();
		System.out.println(de_serializedObject);
		in.close();
	}

	public static void populateMap() {
		stockMap.put("101", new Stock("101", "Ambuja", "Ambuja", 100.0, LocalDate.of(2024, 4, 30), 50));
		stockMap.put("102", new Stock("102", "Ambuja", "Ambuja", 200.0, LocalDate.of(2024, 5, 15), 70));
		stockMap.put("103", new Stock("103", "Ambani", "Ambani", 150.0, LocalDate.of(2024, 5, 10), 60));
		stockMap.put("104", new Stock("104", "Adani", "Adani", 300.0, LocalDate.of(2024, 5, 20), 80));
		stockMap.put("105", new Stock("105", "Nifty", "Nifty", 250.0, LocalDate.of(2024, 5, 25), 90));
		stockMap.put("106", new Stock("106", "TredingCom", "TredingCom", 180.0, LocalDate.of(2024, 5, 5), 55));
		stockMap.put("107", new Stock("107", "Ambuja", "Ambuja", 220.0, LocalDate.of(2024, 4, 28), 65));
		stockMap.put("108", new Stock("108", "Ambuja", "Ambuja", 280.0, LocalDate.of(2024, 5, 30), 75));
		stockMap.put("109", new Stock("109", "Ambani", "Ambani", 170.0, LocalDate.of(2024, 5, 8), 85));
		stockMap.put("110", new Stock("110", "Ambani", "Ambani", 320.0, LocalDate.of(2024, 5, 18), 100));
	}

}
