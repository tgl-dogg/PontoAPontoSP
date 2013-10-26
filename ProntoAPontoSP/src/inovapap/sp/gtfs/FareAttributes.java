package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class FareAttributes {
	private String fareId;
	private float price;
	private String currencyType;
	private int paymentMethod;
	private String transfers;
	private int transferDuration;
	
	public FareAttributes(String line){
		String txt = line;
		Parser parse = new Parser();
		
		this.fareId = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.price = parse.floatParse(txt);
		txt = parse.removeComma(txt);
		
		this.currencyType = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.paymentMethod = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.transfers = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.transferDuration = parse.intParse(txt);		
	}

	public String getFareId() {
		return fareId;
	}

	public void setFareId(String fareId) {
		this.fareId = fareId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getTransfers() {
		return transfers;
	}

	public void setTransfers(String transfers) {
		this.transfers = transfers;
	}

	public int getTransferDuration() {
		return transferDuration;
	}

	public void setTransferDuration(int transferDuration) {
		this.transferDuration = transferDuration;
	}
}
