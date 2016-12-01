package assegur;

import java.util.Date;
import persona.*;

public class AssegurancaVehicleTotRisc extends AssegurancaVehicle {

	private float franquicia;
	private int anysVehicle;

	public float getFranquicia() {
		return franquicia;
	}
	public void setFranquicia(float franquccia) {
		this.franquicia = franquccia;
	}

	public int getAnysVehicle() {
		return anysVehicle;
	}
	public void setAnysVehicle(int anysVehicle) {
		this.anysVehicle = anysVehicle;
	}

	public AssegurancaVehicleTotRisc(Date dateEmissio, Client client, float valorImport, Agent corredor,
			String matricula, int edatConductorHabitual, float bonificacions,float franquccia, int anysVehicle) {
		super(dateEmissio, client, valorImport, corredor, matricula, edatConductorHabitual, bonificacions);
		this.franquicia = franquccia;
		this.anysVehicle = anysVehicle;
	}
	
	public String toString(){
		return super.toString()
	    + "\n franquccia: "+ this.getFranquicia() +" (c)"
		+ "\n anysVehicle: "+ this.getAnysVehicle()
		;
	}	
}
