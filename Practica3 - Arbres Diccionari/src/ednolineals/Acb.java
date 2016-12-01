package ednolineals;

public interface Acb<E extends Comparable<E>> extends Ab<E> {

	/*
	 * llen�a una excepci� si l�element que s�insereix est� repetit
	 */
	public void inserir(E e) throws ArbreException;
	
	/*
	 * @return retorna true si ha trobat l'element i l'ha esborrat
	 * 		   ull!!!! retorna false en cas contrari 
	 */
	public boolean esborrar(E e) throws ArbreException;

	/*
	 * @return retorna true si l�arbre cont� un element com el donat com a par�metre
	 */
	public boolean membre(E e) throws ArbreException;
	
}
