package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class FareAttributes {
	private String fareId;
	private float price;
	private String currencyType;
	private String paymentMethod;
	private int transfers;
	private int transfer_duration;
	
	public FareAttributes(String line){
		String txt = line;
		Parser parse = new Parser();
		
		this.fareId = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.price = parse.floatParse(txt);
		txt = parse.removeComma(txt);
		
		this.currencyType = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.paymentMethod = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.transfers = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.transfer_duration = parse.intParse(txt);		
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

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getTransfers() {
		return transfers;
	}

	public void setTransfers(int transfers) {
		this.transfers = transfers;
	}

	public int getTransfer_duration() {
		return transfer_duration;
	}

	public void setTransfer_duration(int transfer_duration) {
		this.transfer_duration = transfer_duration;
	}
}
