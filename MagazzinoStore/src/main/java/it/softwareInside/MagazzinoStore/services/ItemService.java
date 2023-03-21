package it.softwareInside.MagazzinoStore.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemR;
	
	/**
	 * metodo che permete di aggiungere un elemento di tipo Item al database
	 * a patto che il suo valore non sia null
	 * nel caso in cui l'operazione sia andata a buon fine viene restituito il valore booleano true
	 * altrimenti viene restituito il valore false
	 * 
	 * uso il try - catch per gestire eventuali errori
	 * 
	 * @param item
	 * @return boolean
	 */
	public String addItem(Item item) {
		if(item == null)
			return null;
	
		try {
			itemR.save(item);
			return "Elemento aggiunto";
			
		} catch (Exception e) {
			return "Non è stato possibile aggiungere l'elemento";
			
		}
	}
	
	/**
	 * metodo che passato come parametro un id restotuisce l'elemento a cui l'id corrisponde
	 * e contemporaneamente lo rimuove dall'elenco di elementi contenuti nel database
	 * 
	 * uso il try - catch per gestire eventuali errori
	 * 
	 * @param id
	 * @return Item
	 */
	public Item deleteItem(int id) {
		try {
			Item rimosso = itemR.findById(id).get();
			itemR.deleteById(id);
			return rimosso;
			
		} catch (Exception e) {
			return null;
			
		}	
	}
	
	/**
	 * metodo che stampa la tabella con tutti gli oggetti presenti nel database
	 * 
	 * @return Iterable<Item>
	 */
	public Iterable<Item> findAll(){
		try {
			return itemR.findAll();
			
		} catch (Exception e) {
			return null;
			
		}
	}
	
	/**
	 * metodo che mostra la somma dei prezzi di tutti gli oggetti presenti nel database
	 * uso il medoto findAll definito precedentemente per poter scorrere con il foreach tra gli elementi
	 * 
	 * @return double
	 */
	public double sumItems() {
		double somma = 0;
		try {
			for (Item elemento : findAll()) 
				somma+= elemento.getPrezzo();
			return somma;
			
		} catch (Exception e) {
			return 0;
			
		}
	}
	
	/**
	 * metodo che restituisce l'oggetto all'interno del database,
	 * che corrisponde all'id passato come parametro
	 * 
	 * @param id
	 * @return Item
	 */
	public Item findItem(int id) {
		try {
			return itemR.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}
	
}
