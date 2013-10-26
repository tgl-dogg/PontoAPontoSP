package inovapap.sp.gtfs;

import inovapap.sp.util.Parser;

public class Agency {
	private int agencyId;
	private String agencyName;
	private String agencyUrl;
	private String agencyTimezone;
	private String agencyLang;

	public Agency(String line){
		String txt = line;
		Parser parse = new Parser();
		
		this.agencyId = parse.intParse(txt);
		txt = parse.removeComma(txt);
		
		this.agencyName = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.agencyUrl = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.agencyTimezone = parse.stringParse(txt);
		txt = parse.removeComma(txt);
		
		this.agencyLang = parse.stringParse(txt);
	}
	
	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyUrl() {
		return agencyUrl;
	}

	public void setAgencyUrl(String agencyUrl) {
		this.agencyUrl = agencyUrl;
	}

	public String getAgencyTimezone() {
		return agencyTimezone;
	}

	public void setAgencyTimezone(String agencyTimezone) {
		this.agencyTimezone = agencyTimezone;
	}

	public String getAgencyLang() {
		return agencyLang;
	}

	public void setAgencyLang(String agencyLang) {
		this.agencyLang = agencyLang;
	}

}
