/**
 * Created by santi on 21/11/2016.
 */
public class Examen1_Exercici1 {

    public static void main (String[] args) {


        Poblacio mataro = new Poblacio();

        try {
            mataro.afegirVehicle(new Moto("7137CHW", 0.2f , 43530083, 2015));

            System.out.println(mataro);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
