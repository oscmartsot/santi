import java.util.HashMap;

public class AcbEnll implements Acb{

    private class NodeA{
        private Vehicle inf; private NodeA esq,dret;
        public NodeA(Vehicle m, NodeA e, NodeA d){inf=m;esq=e;dret=d;}

        public void llistatVells(int quins) { /*Exercici 3*/
            if (dret != null) dret.llistatVells(quins);
            if ((quins == 0 && inf instanceof Cotxe) ||
                    (quins == 1 && inf instanceof Moto) || quins == 2)
                System.out.println(inf.getMatricula() + "" + inf.getDniPropietari());
            if (esq != null) esq.llistatVells(quins);
        }

        public void trobaVehiclesVells(String matricula, HashMap<Long, Integer> magatzem) {
            // Cerca intel.ligent
            if (inf.getMatricula().compareTo(matricula) >= 0) {
                if (!magatzem.containsKey (inf.getDniPropietari()))
                    magatzem.put(inf.getDniPropietari(),1);
                else{
                    Integer quants = new Integer(magatzem.get(inf
                            .getDniPropietari()) + 1);
                    magatzem.remove(inf.getMatricula());
                    magatzem.put(inf.getDniPropietari(), quants);
                }
                if (dret!=null)dret.omplenar(magatzem);
                if (inf.getMatricula().compareTo(matricula) > 0) {
                    if (esq!=null) esq.trobaVehiclesVells(matricula, magatzem);
                }
        } else{ if (dret!=null)dret.trobaVehiclesVells(matricula, magatzem);
        }
        }

        public void omplenar(HashMap<Long, Integer> magatzem) {
            // this referencia al node subarbre a recorrer
            if (!magatzem.containsKey(inf.getDniPropietari()))
                magatzem.put(inf.getDniPropietari(), 1);
            else {
                Integer quants = new Integer(magatzem.get(inf.getDniPropietari()) + 1);
                magatzem.remove(inf.getMatricula());
                magatzem.put(inf.getDniPropietari(), quants);
            }
            if (esq != null) esq.omplenar(magatzem);
            if (dret != null) dret.omplenar(magatzem);
        }


        } //fi classe privada

    private NodeA arrel;
    public AcbEnll(){arrel=null;}

/* implementació de totes les operacions de la interfície*/

    public void llistatVells(int quins) { /*Exercici 3*/
        if (this.arrel != null)
            arrel.llistatVells(quins);
    }

    public HashMap<Long, Integer> trobaVehiclesVells(String matricula) {
        HashMap<Long, Integer> magatzem = new HashMap();
        if (    arrel == null) return magatzem;
        arrel.trobaVehiclesVells(matricula, magatzem);
        return magatzem;
    }



    @Override
    public void Inserir(Comparable e) throws Exception {

    }

    @Override
    public void Esborrar(Comparable e) throws Exception {

    }

    @Override
    public boolean Membre(Comparable e) {
        return false;
    }

    @Override
    public Comparable Arrel() throws Exception {
        return null;
    }

    @Override
    public Acb FillEsquerre() {
        return null;
    }

    @Override
    public Acb FillDret() {
        return null;
    }

    @Override
    public boolean ArbreBuit() {
        return false;
    }

    @Override
    public void Buidar() {

    } //no hereta de AbEnll
} // fi classe
