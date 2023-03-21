package it.softwareInside.MagazzinoStore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//LOMBOK
//l'annotazione Data crea i metodi getters, setters e fa l'Override del toString()
@Data
//l'annotazione AllArgsConstructor crea il costruttore con tutti i parametri
@AllArgsConstructor
//l'annotazione NoArgsCostructor crea il costruttore di default
@NoArgsConstructor
//l'annotation entity permette di creare un collegamento tra la classe e il database (persistenza)
@Entity
public class Item {
	
	//AUTO = gestisce l'id autonomamente
	//IDENTITY = gestisce l'id autonomamente e per ogni oggetto aggiunto al database si incrementa di uno
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	private String marca, tipologia;
	private double prezzo;
	
	public Item(String marca, String tipologia, double prezzo) {
		setMarca(marca);
		setTipologia(tipologia);
		setPrezzo(prezzo);
	}
	
	//faccio l'override del toString generato da lombok perché non mi piace la stampa predefinita
	@Override
	public String toString() {
		return 	"marca: "		+	this.marca		+	"\n"		+
				"tipologia: "	+	this.tipologia	+	"\n"		+	
				"prezzo: "		+	this.prezzo		+	"\n---\n"	;
	}

}
