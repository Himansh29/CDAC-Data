package validations;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import entity.Stock;
import exceptions.InvalidStockException;

public class StockValidations {

	public static void validateStockId(String stockId, Map<String, Stock> stockMap) throws InvalidStockException {
		if (stockMap.containsKey(stockId)) {
			throw new InvalidStockException("Id already exists!!!");
		}
	}

	public static void validateStockDate(String date) throws InvalidStockException {
		LocalDate parsedDate = LocalDate.parse(date);
		if (parsedDate.isBefore(LocalDate.now())) {
			throw new InvalidStockException("Stock date cannot be any past date!!");
		}
	}

	public static Map<String, Stock> validateData(String stockId, String stockName, String companyName, double price,
			String closingDate, int quantity, Map<String, Stock> stockMap) throws InvalidStockException {

		Map<String, Stock> validatedData = new HashMap<>();

		validateStockId(stockId, stockMap);
		validateStockDate(closingDate);

		Stock stockObject = new Stock(stockId, stockName, companyName, price, LocalDate.parse(closingDate), quantity);
		validatedData.put(stockId, stockObject);

		return validatedData;
	}
}
