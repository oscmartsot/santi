import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * Created by santi on 21/11/2016.
 */
public class Poblacio{

    private class Node{
        private Vehicle m; private Node seg;
        public Node(Vehicle m, Node n){this.m=m; seg=n; }
    } // fi classe privada



    private Node vehicles[]; //magatzem de vehicles “no vells”
    private AcbEnll vehiclesVells; //magatzem de vehicles “vells”

    public Poblacio(){
        vehicles=new Node[10];
        for (int i=0; i<10; i++) vehicles[i]=null; //seqüència enllaçada buida, sense capçalera
        vehiclesVells= new AcbEnll();
    }

    public void afegirVehicle(Vehicle m) throws Exception {
        /* Exercici 1 */
        Calendar fecha = new GregorianCalendar();
        int any = fecha.get(Calendar.YEAR);
        if (any - m.getAnyCompra() > 10) { //Veil
            // el metode Inserir Alema excepsiO si esth Lentil
            vehiclesVells.Inserir(m);
        } else { //Nou
            int quin = m.getMatricula().charAt(3) - '0';
            Node aux = vehicles[quin];
            while (aux != null) {
                if (aux.m.compareTo(m) == 0) {
                    throw new Exception("ja hi es");
                } else
                    aux = aux.seg;
            }
            vehicles[quin] = new Node(m, vehicles[quin]);
        }// fi else
    }


    public void esborrarVehicle(Vehicle m) throws Exception { /* Exercici 2 */
        Calendar fecha = new GregorianCalendar();
        int any = fecha.get(Calendar.YEAR);
        if (any - m.getAnyCompra() > 10) { // veil
            vehiclesVells.Esborrar(m); // el mitode Esborrar 1100, excepsiO si e
        } else { // nou
            int quin = m.getMatricula().charAt(3) - '0';
            boolean trobat = false;
            Node aux = vehicles[quin];
            // cas especial primer - no tenim node capcalera
            if (aux == null) throw new Exception("no hi es");
            if (aux.m.compareTo(m) == 0)
                vehicles[quin] = vehicles[quin].seg;
            else { // cal anar atrassats
                while (!trobat && aux.seg != null) {
                    if (aux.seg.m.compareTo(m) == 0) {
                        trobat = true;
                        aux.seg = aux.seg.seg;
                    } else aux = aux.seg;
                }
                if (!trobat)
                    throw new Exception("no hi es");
            }
        }// fi else
    }

    public void llistatVells(int quins){ /*Exercici 3*/
        this.vehiclesVells.llistatVells(quins);
    }


    public Map<Long, Integer> trobaVehiclesVells (String matricula) { /*Exercici 4*/
        return this.vehiclesVells.trobaVehiclesVells(matricula);
    }
} //fi classe Població



