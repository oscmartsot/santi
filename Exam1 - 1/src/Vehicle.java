public class Vehicle implements Comparable, java.lang.Comparable{
    private String matricula; //identificador
    private long dniPropietari;
    private int anyCompra; //any matriculació
    public Vehicle(String matricula, long dni, int any){
        this.matricula=matricula; this.dniPropietari=dni; this.anyCompra=any;
    }
    public long getDniPropietari() {return this.dniPropietari;}
    public int getAnyCompra() {return this.anyCompra;}
    public String getMatricula() {return this.matricula;}
    public boolean MajorQue(Comparable o){
        return matricula.compareTo(((Vehicle)o).matricula)>0;
    }
    public boolean MenorQue(Comparable o){
        return matricula.compareTo(((Vehicle)o).matricula)<0;
    }
    public int compareTo(Object o){
        return matricula.compareTo(((Vehicle)o).matricula);
    }
} // fi classe