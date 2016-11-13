package assegur;

import java.util.Date;

import persona.*;

public class AssegurancaLlar extends Asseguranca {
	
	private String adrecaAssegurat;
	private float valorContingut;
	private float valorContinent;

	public String getAdrecaAssegurat() {
		return adrecaAssegurat;
	}
	public void setAdrecaAssegurat(String adrecaAssegurat) {
		this.adrecaAssegurat = adrecaAssegurat;
	}

	public float getValorContingut() {
		return valorContingut;
	}
	public void setValorContingut(float valorContingut) {
		this.valorContingut = valorContingut;
	}

	public float getValorContinent() {
		return valorContinent;
	}
	public void setValorContinent(float valorContinent) {
		this.valorContinent = valorContinent;
	}

	public AssegurancaLlar(Date dateEmissio, Client client, float valorImport, Agent corredor) {
		super(dateEmissio, client, valorImport, corredor);
	}
	
	public AssegurancaLlar(Date dateEmissio, Client client, float valorImport, Agent corredor
			,String adrecaAssegurat
			, float valorContingut
			, float valorContinent) {
		super(dateEmissio, client, valorImport, corredor);
		this.adrecaAssegurat = adrecaAssegurat;
		this.valorContingut = valorContingut;
		this.valorContinent = valorContinent;
	}

	public String toString(){
		return super.toString()
	    + "\n adrecaAssegurat: "+ this.getAdrecaAssegurat()
		+ "\n valorContingut: "+ this.getValorContingut()
		+ "\n valorContinent: "+ this.getValorContinent()
		;
	}	
	

}
