/**
 * Created by santi on 21/11/2016.
 */
public class Moto extends Vehicle {
    private float calibratge;
    public Moto(String matricula, float calibratge, long dni, int any){
        super(matricula,dni,any);
        this.calibratge=calibratge;}
    public float getCalibratge() {return this.calibratge;}
} // fi classe


