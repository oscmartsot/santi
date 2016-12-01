package assegur;

import java.util.Date;

import assegur.Asseguranca;
import persona.*;

public class AssegurancaVehicle extends Asseguranca {

	private String matricula;
	private int edatConductorHabitual;
	private float bonificacions; //expressat en %

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getEdatConductorHabitual() {
		return edatConductorHabitual;
	}
	public void setEdatConductorHabitual(int edatConductorHabitual) {
		this.edatConductorHabitual = edatConductorHabitual;
	}

	public float getBonificacions() {
		return bonificacions;
	}
	public void setBonificacions(float bonificacions) {
		this.bonificacions = bonificacions;
	}

	public AssegurancaVehicle(Date dateEmissio, Client client, float valorImport, Agent corredor) {
		super(dateEmissio, client, valorImport, corredor);
	}

	public AssegurancaVehicle(Date dateEmissio, Client client, float valorImport, Agent corredor
			,String matricula, int edatConductorHabitual, float bonificacions) {
		super(dateEmissio, client, valorImport, corredor);
		this.matricula = matricula;
		this.edatConductorHabitual = edatConductorHabitual;
		this.bonificacions = bonificacions;
	}

	public String toString(){
		return super.toString()
	    + "\n matricula: "+ this.getMatricula()
		+ "\n edatConductorHabitual: "+ this.getEdatConductorHabitual()
		+ "\n bonificacions: "+ String.format("%.2f (%%)", this.getBonificacions()*100.0f)
		;
	}	

}
