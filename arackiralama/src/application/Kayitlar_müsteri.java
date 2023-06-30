package application;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Kayitlar_müsteri{
	
	public String getTc() {
		return tc;
	}




	public void setTc(String tc) {
		this.tc = tc;
	}




	public String getIsim() {
		return isim;
	}




	public void setIsim(String isim) {
		this.isim = isim;
	}




	public String getSoyisim() {
		return soyisim;
	}




	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}




	public String getTelno() {
		return telno;
	}




	public void setTelno(String telno) {
		this.telno = telno;
	}




	public String getAdres() {
		return adres;
	}




	public void setAdres(String adres) {
		this.adres = adres;
	}




	private String tc;
	private String isim;
	private String soyisim;
	private String telno;
	private String adres;
	
	
	
	
	Kayitlar_müsteri(String tc ,String isim,String soyisim,String telno,String adres){
		this.tc=tc;
		this.isim=isim;
		this.soyisim=soyisim;
		this.telno=telno;
		this.adres=adres;
		
		
	}
	
	
	
	
	
	
	
	
}
