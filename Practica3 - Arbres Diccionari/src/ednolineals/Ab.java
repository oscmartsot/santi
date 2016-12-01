package ednolineals;

public interface Ab<E> {

	/*
	 * cal llen�ar una excepci� si es demana l�arrel d�un arbre buit
	 */
	E arrel() throws ArbreException;

	/*
	 * Exception si l�arbre this �s buit. Si no t� fill esquerre retorna un arbre buit.
	 */
	Ab<E> fillEsquerre()throws ArbreException;

	/*
	 * Excepcion si l�arbre this �s buit. Si no t� fill dret retorna una arbre buit.
	 */
	Ab<E> fillDret()throws ArbreException;

	/*
	 * 
	 */
	boolean abBuit();

	/*
	 * 
	 */
	void buidar();
}
