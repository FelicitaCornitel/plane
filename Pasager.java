
/**
 * Clasa Pasager contine informatiile 
 *	despre pasager : id - ul si prioritatea(score)
 */
public abstract class Pasager {
	/**
	 * Id-ul pasagerului la care nu are acces oricine
	 */
	protected String id;
	/**
	 * Prioritatea pasagerului la care nu are acces oricine
	 */
	protected int score;
	/**
	 * COnstructorului initializeaza id-ul
	 * @param id Id-ul pasagerului
	 */
	Pasager(String id){
		this.id = id;
	}
	/**Metoda returneaza prioritatea
	 * @return int Returneaza prioritatea fiecarui pasager
	 */
	public int getScore() {
		return score;
	}
	/**Metoda returneaza id-ul
	 * @return String Returneaza id-ul fiecarui pasager
	 */
	public String getId() {
		return id;
	}
	/**Metoda calculeaza prioritatea fiecarui pasager
	 */
	public abstract void CalculateScore();
}
