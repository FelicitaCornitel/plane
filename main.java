import java.util.*;
import java.io.*;

public class main  {
	/**In metoda main am citit datele din fisier si in functie de ele,
	 * am apelat metodele folosite in clasa Heap
	 */
	public static void main(String[] args) throws IOException  {
		
		File in = new File("queue.in");
		if(in.exists() == false) {
			System.out.println("fisierul nu exista");
			return;
		}
		Pasager pasageri[];
		Scanner input = new Scanner(in);
		Scanner sc =  input.useDelimiter("\\W+");
		String id, nume;
		int varsta;
		char bilet, tipPers;
		boolean imbarcare, nevoie;
		int curent = 0;
		int N = sc.nextInt();
		pasageri = new Pasager[N];
		//citesc datele din fisier
		for(int i = 0; i < N; i++) {
			 id = sc.next();
			 nume = sc.next();
			 varsta = sc.nextInt();
			 bilet = sc.next().charAt(0);
			 imbarcare = (sc.next().compareTo("true") == 0);
			 nevoie = (sc.next().compareTo("true") == 0);
			 tipPers = id.charAt(0);
			 Singur s = new Singur(id, nume, varsta, bilet, imbarcare, nevoie);
			 //daca id-ul e s, adaug un pasager de tip singur
			 if(tipPers == 's') {
			 		pasageri[curent] = s;
			 		curent++;	
			 }
			 //daca id-ul e g, adaug un pasager de tip grup				 
			 else if(tipPers == 'g') {
				int gasit = 0;
				Grup grup = null;

				for(int j = 0; j < curent; j++) {
					//adaug persoana intr un grup
					if(pasageri[j].getId().compareTo(id) == 0) {
						gasit = 1;
						grup = (Grup)pasageri[j];
						Persoana p = new Persoana(nume, varsta, bilet, imbarcare, nevoie);
						grup.addPersoana(p);
					}
				}
				//creez grupul si adaug in grup
				if(gasit == 0) {
					Grup g = new Grup(id);
					Persoana p = new Persoana(nume, varsta, bilet, imbarcare, nevoie);
					g.addPersoana(p);
					pasageri[curent] = g;
					curent++;
					
				}
			}
			//daca id-ul e g, adaug un pasager de tip familie				 
			else if(tipPers == 'f') {
				int gasit = 0;
				Familie familie = null;
				for(int j = 0; j < curent; j++) {
					//adaug persoana intr o familie
					if(pasageri[j].getId().compareTo(id) == 0) {
						gasit = 1;
						familie = (Familie)pasageri[j];
						Persoana p = new Persoana(nume, varsta, bilet, imbarcare, nevoie);
						familie.addPersoana(p);
					}
				}
				//creez familia si adaug persoana in ea
				if(gasit == 0) {
					Familie g = new Familie(id);
					Persoana p = new Persoana(nume, varsta, bilet, imbarcare, nevoie);
					g.addPersoana(p);
					pasageri[curent] = g;
					curent++;
				}
			}
		}

		Heap heap = new Heap(N);
		//calculez prioritatea fiecarui pasager
		for(int i = 0; i < curent; i++){
			pasageri[i].CalculateScore();
		}
		while(sc.hasNext() == true) {
			String comanda = sc.next();
			//daca am comanda embark
			if(comanda.equals("embark")) {
				heap.embark();
			}	
			//daca am comanda insert
			if(comanda.equals("insert")) {
				comanda = sc.next();		
				Pasager p = null;
				for(int k = 0; k < curent; k++)
					//caut pasagerului cu id-ul din comanda
					if(pasageri[k].getId().compareTo(comanda) == 0)
						p = pasageri[k];
				heap.insert(p, p.getScore());		
			}	
			//daca am comanda list
			if(comanda.equals("list")) {
				heap.list();
			}			
		}
		heap.wr.close();
		input.close();
		sc.close();
	}
} 
	

		

