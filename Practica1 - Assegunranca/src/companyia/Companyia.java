package companyia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import persona.*;
import assegur.*;


public class Companyia {

	//taula dcuna dimensic on scemmagatzemen seqcencialment totes les assegurances que la companyia tc contractades
	private Asseguranca[] assegurances;
	private int maxAssegurances; // Lcmit d'assegurances que es poden contractar
	private int quantesAssegurances; // ncmero dcassegurances contractades, cs a dir la dimensic real de la taula
	
	// objecte de la colleccic parametritzada List<Agent>
	private List<Agent> agents;
	
	//seqccncia enllacada de nodes, aquesta no tc node capcalera i cs lineal
	private Node clients;

	private String nom;
	private String adreca;
	private long telefon;
	
	private int contadorPolisses;
	
	public Companyia(String nom, String adreca, long telefon, int maxAssegurances){

		this.contadorPolisses = 0;
		
		this.setNom(nom);
		this.setAdreca(adreca);
		this.setTelefon(telefon);

		//
		this.maxAssegurances = maxAssegurances;
		this.assegurances = new Asseguranca[maxAssegurances];
		this.agents = new ArrayList<Agent>();
		//this.clients // La seqccncia enllacada no tc capcelera
		
	}
	
		public void addAsseguranca(Asseguranca a) throws Exception {
			
			// Hi ha lloc?
			if( this.quantesAssegurances+1 > this.maxAssegurances)
				throw new Exception("La companyia no pot contractar mcs assegurances (Max:"+ this.maxAssegurances +")");
			
			// Estc repetit?
			for( Asseguranca item : this.assegurances){
				if(item != null){
					if(item.equals(a)) {
						throw new Exception("Ja existeix l'assegur "+ a.toString());
					};
				}
			}

			// Agent contractat?
			boolean trobat = false;
			for( Agent item : this.agents){
				if(item.equals(a.getCorredor())) {
					trobat = true;
				}
			}
			if(!trobat) {
				throw new Exception("Agent no estc contractat "+ a.toString());
			};
			
			
//			Si la persona que fa la contractacic no era client de la companyia tambc scha dcafegir al corresponent	magatzem de clients
				if(!this.existsClient(a.getClient())) {
					Node nouClient = new Node(a.getClient(), null);

					// Si no hi ha clients, afegir la referencia
					if(this.clients == null)
						this.clients = nouClient;
					else {
						// Afegir el node a l'ultim de la seqcencia enllacada.
						this.getLastNode().setSeguent(nouClient);
					}
						
				}
				
				this.contadorPolisses++;
				a.setNumeroPolissa(this.contadorPolisses);
			
			this.assegurances[quantesAssegurances] = a;
			quantesAssegurances++;
			
			
		};
		public void remAsseguranca(Asseguranca a) throws Exception {
			
			// Existeix?
			boolean trobat = false;
			for(int i=0;i<this.assegurances.length;i++) {
				Asseguranca item = this.assegurances[i];		
				if(item != null){
					if(item.equals(a)){
						trobat = true;

						Client client = item.getClient();
						// Donar de baixa el client??
						if(this.assegurancesClient(client)==1) {
							remClient(client);
						}
						
						//Com que no importa l'ordre a la taula es pot posar l'ultim sobre l'element a eliminar
						// Si l'element a eliminar cs l'ultim, possar null
						if(item.equals(this.assegurances[this.quantesAssegurances-1]))
							this.assegurances[i] = null;
						else {						
							this.assegurances[i] = this.assegurances[this.quantesAssegurances-1];
							this.assegurances[this.quantesAssegurances-1] = null;
						}
						this.quantesAssegurances--;
						
						break;
					}
				}
			}			
			if(!trobat) {
				throw new Exception("Error: No s'ha trobat la polissa a eliminar "+ a.toString());
			};

			
			
		}

		public void addAgent(Agent a) throws Exception {
			if( this.agents.contains(a)) throw new Exception("L'agent ja existeix "+ a.toString() );
			agents.add(a);
		}
		public void remAgent(Agent a) throws Exception {
			if( !this.agents.contains(a)) throw new Exception("L'agent no existeix "+ a.toString() );
			agents.remove(a);
		}
		
		public Map<Integer, Agent> calculComissio(int mes) {
			Map<Integer, Agent> m1 = new TreeMap<Integer, Agent>();
			for(int i = 0; i < this.assegurances.length; i++) {
				Asseguranca a = this.assegurances[i];
				if(a != null) {
					int AssegurancaMes = a.getDateEmissio().getMonth()+1;
					if( AssegurancaMes == mes) {
						m1.put(a.getNumeroPolissa(), a.getCorredor());
					}
				}
			}
			return m1;
		}
		
		public int quantesAsssegurancesVehicleTotRisc(){
			return quantesAsssegurancesVehicleTotRisc(0);
		}
		public int quantesAsssegurancesVehicleTotRisc(int franquicia){
			int counter = 0;
			for(Asseguranca a : this.assegurances) {
				if(a instanceof AssegurancaVehicleTotRisc){
					AssegurancaVehicleTotRisc b = (AssegurancaVehicleTotRisc)a;
					if(b.getFranquicia() >= franquicia )
						counter++;
				}
			}
			return counter;
		}
		
		public int quantsClients(String poblacio){
			if (this.clients == null) return 0;
			return this.clients.getCount(poblacio);
		}
		public void modificacioBonificacioPenalitzacio(int Bonificacio, float Penalitzacio){
			
			for( Asseguranca item : this.assegurances){
				if(item != null){
					if(item instanceof AssegurancaVehicle) {
						AssegurancaVehicle av = ((AssegurancaVehicle) item);
						if( item.getNumeroPolissa() == Bonificacio){
							av.setBonificacions(av.getBonificacions()+ Penalitzacio/100.0f);
						}
					}
				}
			}
			
		}
		public float assegurancaMesCobertura(Agent agent){
			float maximaCobertura = 0.0f;
			for( Asseguranca item : this.assegurances){
				if(item != null){
					if(item instanceof AssegurancaVida) {
						AssegurancaVida av = ((AssegurancaVida) item);
						if( item.getCorredor().equals(agent)){
							if(av.getCobertura() > maximaCobertura) {
								maximaCobertura = av.getCobertura();
							}
						}
					}
				}
			}
			return maximaCobertura;
		}
		
		public String tipusAssegurancaMesContractada(){
			int tipusVida = 0;
			int tipusLlar = 0;
			int tipusVehicle = 0;
			String tipus = "Asseguranca";
			
			for( Asseguranca item : this.assegurances){
				if(item != null){
					if(item instanceof AssegurancaVida)tipusVida++;
					if(item instanceof AssegurancaLlar)tipusLlar++;
					if(item instanceof AssegurancaVehicle) tipusVehicle++;
				}
			}
			if(tipusVida>=tipusLlar && tipusVida>=tipusVehicle) 
				tipus = String.format("AssegurancaVida (%d)",tipusVida);
			if(tipusLlar>=tipusVida && tipusLlar>=tipusVehicle)
				tipus = String.format("AssegurancaLlar (%d)",tipusLlar);
			if(tipusVehicle>=tipusLlar && tipusVehicle>=tipusVida) 
				tipus = String.format("AssegurancaVehicle (%d)",tipusVehicle);
			
			return tipus;
		}
		
	
		
		public boolean existsClient(Client client){

			Node item = this.clients;
			if( item == null) return false; // Si no hi han clients tornem fals
			// Mctode de cerca a sequencia enllacada
			boolean trobat = false;
			while(item != null && trobat != true){
				if(item.client.equals(client))
					trobat = true;
				item = item.seguent;
			}
			return trobat;
		}
		
		
		private int assegurancesClient(Client client){

			int counter = 0;
			for(Asseguranca a : this.assegurances) {
				if(a!=null)
					if(a.getClient().equals(client) )
						counter++;
			}			
			return counter;
		}
		
		private void remClient(Client client){
			// cas 1. no hi es
			if (this.clients == null) return;
			// cas 2. es el primer
			if(this.clients.client.equals(client)) {
				this.clients = this.clients.seguent;
				return;
			}
			// cas 3. es un altre
			Node anterior = this.clients;
			while(anterior.seguent != null){
				if(anterior.seguent.client.equals(client)) {
					anterior.seguent = anterior.seguent.seguent;
					return;
				}
				anterior = anterior.seguent;
			}
		}
		
		private Node getLastNode(){

			Node item = this.clients;
			if (item == null) return null;

			if(item.getSeguent() == null) return item;
			
			// Reccrrer la seqccncia enllacada fins al cltim node
			while(item.getSeguent() != null){
				item = item.getSeguent();
			}
			return item;
		}		


		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getAdreca() {
			return adreca;
		}
		public void setAdreca(String adreca) {
			this.adreca = adreca;
		}

		public long getTelefon() {
			return telefon;
		}
		public void setTelefon(long telefon) {
			this.telefon = telefon;
		}
		
		public String toString(){
			
			String assegurancaListString = "";
			for(Asseguranca a : this.assegurances) {
				if(a != null){
					if (assegurancaListString!="") assegurancaListString = assegurancaListString +"\n";
					assegurancaListString = assegurancaListString +"\n"+ a.getClass().getSimpleName() + a.toString();
				}
			}
			String agentListString = "";
			for(Agent a : this.agents) {
				if(a != null){
					if (agentListString!="") agentListString = agentListString +"\n";
					agentListString = agentListString +"\nAgent"+ a.toString();
				}
			}
			String clientListString = "";
			Node item = this.clients;
			while(item!= null){
				if (clientListString!="") clientListString = clientListString +"\n";
				clientListString = clientListString +"\nClient"+ item.toString();
				item = item.getSeguent();
			}			
			
			
			return "Companyia: "+ getNom() 
			+ "\n Adreca: "+ this.getAdreca() 
			+ "\n\n----- quantsClients: "+ this.quantsClients("")
			+ "\n----- quantsClients (poblacio= Canet de mar): "+ this.quantsClients("Canet de mar")
			+ "\n\n----- Cartera de clients: "+ clientListString
			+ "\n\n----- Agents dcassegurances: "+ agentListString
			+ "\n\n----- Assegurances:"+ this.quantesAssegurances +" polisses (Max:"+ this.maxAssegurances +")"
			+ "\n quantesAsssegurancesVehicleTotRisc: "+ this.quantesAsssegurancesVehicleTotRisc()
			+ "\n quantesAsssegurancesVehicleTotRisc (franquicia>=200): "+ this.quantesAsssegurancesVehicleTotRisc(200)
			+ "\n "+ assegurancaListString
			;
			
		}



		private class Node {

			//Atributs
			private Client client;
			private Node seguent;

			public Node( Client client, Node node) {
				setClient(client);
				setSeguent(node);
			}

			public Node getSeguent() {
				return this.seguent;
			}
			public void setSeguent(Node node) {
				this.seguent = node;
			}

			public Client getClient() {
				return client;
			}
			public void setClient(Client client) {
				this.client = client;
			}
			
			public int getCount(String poblacio){

				int i = 0;
				Node item = this;
				if(item.getSeguent()== null &&(item.getClient().getPoblacio() == poblacio || poblacio == ""))
					return 1;
				while(item != null){
					if(item.getClient().getPoblacio() == poblacio || poblacio == "")
						i++;
					item = item.getSeguent();
				}
				return i;
				
			}			
			
			public String toString(){

				return this.getClient().toString();
				
			}
			
		}	
		
	}

