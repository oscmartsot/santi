/**
 * Created by santi on 21/11/2016.
 */
public class Cotxe extends Vehicle {
    private int numeroPortes;
    public Cotxe(int portes, String matricula, long dni, int any){
        super(matricula,dni,any);
        this.numeroPortes=portes; }
    public int getNumeroPortes() {return this.numeroPortes;}
} // fi classe