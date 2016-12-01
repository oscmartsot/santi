package Exercici22;

import edlineals.*;
import ednolineals.*;

public class Barca {
	private Acb<Soci>[]socis; 
	/* l�Acb de la primera posici� emmagatzema els socis amb un n�mero de soci acabat en 0, 
	 * el de la posici� 1 els acabats en 1, ...... Els Acb�s emmagatzemen objectes Soci. */
	private Pila seccions; /* Magatzem de les diferents seccions del club */

	/*
	 * TODO Soluci� Exercici 5.1
	 */
	public Barca(){ // Class Bar�a
		socis = new Acb[10];
		for (int i=0; i<10; i++) 
			socis[i]=new AcbEnll<Soci>();
		seccions=new PilaEnll();		
	}
	/*
	 * TODO Soluci� Exercici 5.2
	 */
	public void addSoci(Soci p) throws Exception{ // Class Bar�a
		socis[(int) (p.getNumeroSoci()%10)].Inserir(p);
	}

	/*
	 * TODO Soluci� Exercici 5.3
	 */
	public void remSoci(Soci q) throws Exception{ // Class Bar�a
		socis[(int) (q.getNumeroSoci()%10)].Esborrar(q);
	}
	
	@Override
	public String toString(){
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0; i< socis.length; ++i){
			stringBuilder.append("Socis["+ i +"] ");
			stringBuilder.append(" "+((AcbEnll)socis[i]).inordre().toString());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}	
}