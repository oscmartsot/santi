package persona;

public abstract class Persona {
	
	String nom; 
	String adreca;
	long telefon; 
	long DNI; 
	String poblacio;
	
	public Persona(String nom, long DNI) {
		this.nom = nom;
		this.DNI = DNI;
	}
	
	public Persona(String nom,String adreca, long telefon, long DNI, String poblacio) {
		this.nom = nom;
		this.adreca = adreca;
		this.telefon = telefon;
		this.DNI = DNI;
		this.poblacio = poblacio;
	}
	
	public void setNom(String value){nom = value;}
	public String getNom(){	return nom;	}		
	
	public void setAdreca(String value){ adreca = value;}
	public String getAdreca(){ return adreca;}		

	public void setTelefon(long value){ telefon = value;}
	public long getTelefon(){ return telefon;	}
	
	public void setDNI(long value){ DNI = value;}
	public long getDNI(){ return DNI;	}	

	public void setPoblacio(String value){ poblacio = value;}
	public String getPoblacio(){ return poblacio; }	
	

	
	public String toString(){
		return "\n Nom: "+  this.getNom()
		+"\n DNI: "+ this.getDNI()
		+"\n Adreca: "+ this.getAdreca()
		+"\n Poblacio: "+ this.getPoblacio()
		;
		
	}	
}
