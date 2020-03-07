/**
 * Clasa Familie contine un vector de tip Persoana
 * cu scorul initial 10 
 */
public class Familie extends Pasager {
	/**Vectorului de persoane
	 */
	Persoana[] p;
	/**
	 Dimensiunea vectorului
	 */
	int size;
	/**
	 * Constructorul preia id -ul din clasa Pasager , instantiaza
	 * un vector de Persoane cu un nr maxim de 100, initializeaza 
	 * dimensiunea initiala a vectorului in care o sa fie adaugati
	 * persoanele cu 0
	 * @param id Id-ul pasagerului
	 */
	public Familie(String id) {
		super(id);
		size = 0;
		score = 10;
		p = new Persoana[100];
	}
	/**Metoda adauga persoana in vector
	 * @param pers Acest parametru este persoana care trebuie adaugata
	 */
	public void addPersoana(Persoana pers) {	
		p[size] = pers;
		size++;
		
	}
	/**Metoda calculeaza prioritatea in functie de varsta, tip bilet,
	 * nevoi speciala si tipul de imbarcare
	 */
	public void CalculateScore() {
		for(int i = 0; i < size; i++) {
			Persoana pas = p[i];
			if (pas.varsta >= 0 && pas.varsta < 2)
				score += 20;
			if(pas.varsta < 5 &&pas.varsta >= 2 )
				score += 10;
			if (pas.varsta < 10 && pas.varsta >= 5 )
				score += 5;
			if (pas.varsta >= 60 )
				score += 15;
			if(pas.tipBilet == 'e')
				score += 0;
			if(pas.tipBilet == 'b')
				score += 35;
			if(pas.tipBilet == 'p')
				score += 20;
			if(pas.imbarcare)
				score += 30;
			if(pas.nevoie)
				score += 100;
		}
	}
}