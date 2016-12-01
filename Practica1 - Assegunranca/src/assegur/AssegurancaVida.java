package assegur;

import java.util.Arrays;
import java.util.Date;

import persona.*;

public class AssegurancaVida extends Asseguranca {

	private int edat;
	private String professic;
	private String beneficiaris[]; 
	private float cobertura;
	
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}

	public String getProfessio() {
		return professic;
	}
	public void setProfessic(String professic) {
		this.professic = professic;
	}

	public String[] getBeneficiaris() {
		return beneficiaris;
	}
	public void setBeneficiaris(String[] beneficiaris) {
		this.beneficiaris = beneficiaris;
	}

	public float getCobertura() {
		return cobertura;
	}
	public void setCobertura(float cobertura) {
		this.cobertura = cobertura;
	}

	public AssegurancaVida(Date dateEmissio, Client client, float valorImport, Agent corredor
			,int edat, String professio, float cobertura) {
		super(dateEmissio, client, valorImport, corredor);
		this.edat = edat;
		this.professic = professio;
		this.cobertura = cobertura;		
		
		this.beneficiaris = new String[0];
	}
	
	public void afegirBeneficiari(String nom){
		String[] s = new String[beneficiaris.length+1];
		for(int i = 0; i< beneficiaris.length;i++) {
			s[i] = beneficiaris[i];
		}
		s[s.length-1] = nom;
		beneficiaris = s;
		
	}
	public void eliminarBeneficiari(String nom){

		int index = -1;
		for(int i = 0; i< beneficiaris.length;i++) {
			if(beneficiaris[i].equals(nom)) {
				index = i;
				break;
			}
		}
		if(index>=0){
			int added = 0;
			String[] s = new String[beneficiaris.length-1];
			for(int i = 0; i< beneficiaris.length;i++) {
				if(index != i) {
					s[added] = beneficiaris[i];
					added++;
				}
			}
			beneficiaris = s;
		}
	}

	public String toString(){
		return  super.toString()
		+ "\n edat: "+ this.getEdat()
		+ "\n professic: "+ this.getProfessio()
		+ "\n beneficiaris: "+ Arrays.toString(this.beneficiaris)
		+ "\n cobertura: "+ this.getCobertura()
		;
	}	


}
