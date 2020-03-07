
/**
 * Clasa Persoana contine informatiile despre persoana
 */
public class Persoana {
	String nume;
	int varsta;
	char tipBilet;
	boolean imbarcare;
	boolean nevoie;
	/**
	 * Iniatializeaza un obiect de tip Persoana
	 * @param nume Numele pasagerului
	 * @param varsta Varsta pasagerului
	 * @param tipBilet Tipul biletului cumparat 
	 * @param imbarcare Tipul de imbarcare pasagerului
	 * @param nevoie Nevoile speciale a pasagerului
	 */
	public Persoana(String nume, int varsta, char tipBilet, boolean imbarcare, boolean nevoie) {
		this.nume = nume;
		this.varsta = varsta;
		this.tipBilet = tipBilet;
		this.imbarcare = imbarcare;
		this.nevoie = nevoie;
	}
	

}
