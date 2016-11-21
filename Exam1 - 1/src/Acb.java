public interface Acb { //no hereta de Ab
    void Inserir(Comparable e) throws Exception;
    //excepció si l’element a inserir ja està a l’arbre
    void Esborrar(Comparable e) throws Exception;
    //excepció si l’element a esborrar no està a l’arbre
    boolean Membre(Comparable e);
    //true si l’element està a l’arbre, false en cas contrari
    Comparable Arrel() throws Exception;
    //excepció si l’arbre és buit
    Acb FillEsquerre();
    //no llença excepció, tan si l’arbre this és buit com si no té fill esquerra retorna un arbre buit
    Acb FillDret();
    //no llença excepció, tan si l’arbre this és buit com si no té fill dret retorna un arbre buit
    boolean ArbreBuit();
    //true si l’arbre no té cap element
    void Buidar();
} //fi interfície
