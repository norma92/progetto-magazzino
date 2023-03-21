package it.softwareInside.MagazzinoStore.RestControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.services.ItemService;

@RestController
public class ItemRestControl {

	//creo un oggetto ItemService per poter invocare tramite esso i metodi di quella classe
	@Autowired
	ItemService itemS;
	
	@PostMapping("/add-item")
	public String aggiungiItem(@RequestBody Item item) {
		return itemS.addItem(item);		
	}
	
	@PostMapping("/update-item")
	public String modificaItem(@RequestBody Item item) {
		return itemS.addItem(item);
	}
	
	@PostMapping("/delete-item")
	//l'id deve essere passato tramite url e non deve essere inserito nei campi name - value di rested
	//posso non inserire le tonde successive al RequestParam
	public Item rimuovi(@RequestParam ("id") int id) {
		return itemS.deleteItem(id);
	}
	
	@PostMapping("/database")
	public String visualizzaItems() {
		return itemS.findAll().toString();
	}
	
	@PostMapping("/value-items")
	public double somma() {
		return itemS.sumItems();
	}
	
	@PostMapping("/find-item")
	//l'id deve essere passato tramite url e non deve essere inserito nei campi name - value di rested
	public Item cercaItem(@RequestParam ("id") int id) {
		return itemS.findItem(id);
	}
	
	
}
