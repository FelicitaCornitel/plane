import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
/**
 * In clasa Heap este implementata "coada de prioritati"
 */
public class Heap {
	/**
	 * Dimensiunea vectorului de pasageri
	 */
	int size;
	/**
	 * Vectorul de pasageri
	 */
	Pasager pasageri[];
	/**
	 * Fisierul de iesire 
	 */
	FileWriter  wr;
	/**Constructorul creeaza o instanta a clasei Pasager si a fisierului
	 * de iesire. Dimensiunea initiala a vectorului este 0
	 * @param maxSize Acest parametru reprezinta dimensiunea vectorului
	 * de pasageri
	 * 
	 */
	Heap(int maxSize) throws IOException{
		size = 0;
		pasageri = new Pasager[maxSize];
		File out = new File("queue.out");
		this.wr = new FileWriter(out);
	}
	
	/**Metoda interschimba doua noduri.
	 * @param i Este primul parametru, care va fi nodul curent
	 * @param max Este al doilea parametru, care va fi nodul 
	 * cu prioritate maxima
	 */
	public void swap (int i, int max) {
		Pasager aux = pasageri[i];
		pasageri[i] = pasageri[max];
		pasageri[max] = aux;
		
	}
	/**Metoda verifica daca nodul nu are niciun copil
	 * @param i Parametru i este nodul
	 * @return boolean Returneaza true, daca nu are copil si false, 
	 * daca are
	 */
	public boolean isFrunza(int i) {
		if ( i >= (size / 2) && i <= size)
			return true;
		else
			return false;
	}
	/**Metoda sorteaza arborele, dupa caracteristicile MaxHeap-ului
	 * si in functie de prioritatea pasagerilor, sortarea incepe
	 * de la nodul parinte prin compararea prioritatii lui cu prioritatea
	 * copiilor lui
	 * @param i Parametru i este nodul care va fi sortat si pus 
	 * in locul potrivit
	 */
	public void Sort(int i) { 
		//calculez nodul stang si nodul drept
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if(!isFrunza(i)) {
		if(pasageri[left] == null && pasageri[right] == null) 
			return;
		int max = i;
		//verific prioritatile
		if(left < size  && pasageri[left].getScore() > pasageri[max].getScore() )
			max = left;
		if(right < size && pasageri[right].getScore() > pasageri[max].getScore())
			max = right;
		if(max != i) {
			 swap(i, max);
			 Sort(max);

		}
		else 
			Sort(max + 1);
		}
	}
	/**Metoda insereaza nodul in locul potrivit, dupa regula lui MaxHeap,
	 * dupa prioritate, inserarea incepe de la nivelul cel mai de jos  
	 * @param i Parametru i este nodul care va fi inserat
	 */
	public void insert1(int i) {
		int parinte = 0;
		if (i == 0)
			return;
		//calculez parintele in functie de nodul intrat ca parametru
		if ( i % 2 == 1)
			parinte = i/2;
		if ( i % 2 == 0)
			parinte = i/2 - 1;
		while(pasageri[i].getScore() > pasageri[parinte].getScore()) {
			swap(i, parinte);
			i = parinte;
			if (i == 0)
				 return;
			else 
			{
				if ( i % 2 == 1)
					parinte = i / 2;
				if( i % 2 == 0)
					parinte = i / 2 - 1;
			}
		}
	}
	/**Metoda insert adauga pasagerul in coada de prioritati
	 * @param p Parametru p este pasagerul care urmeaza sa fie adaugat
	 * @param prioritate Acest parametru reprezinta prioritatea pasagerului
	 */
	public void insert(Pasager p, int prioritate) {
		pasageri[size] = p;
		size++;
		insert1(size -1);
	}
	/**Metoda afiseaza elementele in traversare preordine
	 * @param i Acest parametru este nodul "parinte"
	 */
	public void list1(int i) throws IOException {
		if(i >= size)
			return;
		else {
			if(i > 0)
				//adaug spatii intre id-uri
				this.wr.write(" ");
			this.wr.write(pasageri[i].getId());
			list1(2*i+1);
			list1(2*i+2);
		}
	}
	/**Metoda afiseaza elementele din heap in preodine incepand
	 * de la nodul 0, parinte
	 */
	public void list() throws IOException {
		list1(0);
		this.wr.write("\n");
	}
	/**Metoda imbarca in avion root-ul heap-ului,
	 * adica pasagerul cu prioritate maxima. Root-ul devine ultimul
	 * pasager adaugat, iar ultimul pasager adaugat devine null
	 * 
	 */
	public void embark() {
		if ( size == 0)
			return;
		pasageri[0] = pasageri[size - 1];
		pasageri[size - 1] = null;
		size--;
		Sort(0);
		

	}
	
		
}