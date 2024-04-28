package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Stock implements Serializable{

	String stockId;
	String stockName;
	String CompanyName;
	double price;
	LocalDate closingDate;
	int quantity;

	public Stock(String stockId, String stockName, String companyName, double price, LocalDate closingDate,
			int quantity) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.CompanyName = companyName;
		this.price = price;
		this.closingDate = closingDate;
		this.quantity = quantity;
	}

	public Stock() {
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", CompanyName=" + CompanyName + ", price="
				+ price + ", closingDate=" + closingDate + ", quantity=" + quantity + "]";
	}

}
