
/**
 * Clasa Singur initializeaza un obiect de tip Singur
 * si preia id- ul din clasa pasager
 */
public class Singur extends Pasager{
	Persoana pers;
	/**
	 * Constructorul preia id-ul pasagerului si creeaza o instanta a
	 * clasei Persoana
	 * @param id Id-ul pasagerului
	 * @param nume Numele pasagerului
	 * @param varsta Varsta pasagerului
	 * @param tipBilet Tipul biletului cumparat 
	 * @param imbarcare Tipul de imbarcare pasagerului
	 * @param nevoie Nevoile speciale a pasagerului
	 */
	public Singur(String id, String nume, int varsta, char tipBilet, boolean imbarcare, boolean nevoie) {
		super(id);
		pers = new Persoana(nume, varsta, tipBilet,imbarcare, nevoie);
	}
	
	/**Metoda calculeaza prioritatea in functie de varsta, tip bilet,
	 * nevoi speciala si tipul de imbarcare
	 */
	public void CalculateScore() {
		if (pers.varsta <= 0 && pers.varsta < 2)
			score += 20;
		else if(pers.varsta >= 2 && pers.varsta < 5 )
			score += 10;
		else if (pers.varsta >= 5 && pers.varsta < 10)
			score += 5;
		else if (pers.varsta >= 10 && pers.varsta < 60)
			score += 0;
		else if (pers.varsta >= 60 )
			score +=15;
		if(pers.tipBilet == 'e')
			score += 0;
		if(pers.tipBilet == 'b')
			score +=  35;
		if(pers.tipBilet == 'p')
			score +=  20;
		if(pers.imbarcare)
			score += 30;
		if(pers.nevoie)
			score += 100;
	
	}
}