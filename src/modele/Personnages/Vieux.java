package modele.Personnages;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.Personnage;

public class Vieux extends Personnage{

	private StringProperty orientation;
	private StringProperty paroles;
	
	public Vieux(String nom, int posX, int posY) {
		super(nom, posX, posY);
		this.orientation = new SimpleStringProperty();
		this.paroles = new SimpleStringProperty();
	}
	

	public StringProperty parolesProperty() {
		return paroles;
	}

	public void setParoles(String paroles) {
		this.paroles.set(paroles);
	}
	
	public String getParoles() {
		return this.paroles.get();
	}

	public void parler(KeyEvent e) {
			if(monde.getLink().getArme() != null) {
				setParoles("Vieux : Tu es armé ! Super ! Tu peux aller\ncombattre le grand méchant\nours tueur !"
					+ " À l'attaque !");
		} else {
			setParoles("Vieux : Oh non ! Ne continue pas ce chemin si\ntu n'es pas armé !"
					+ " Tu y trouveras un\nméchant ours tueur ! Il te faut une arme.\n"
					+ "Si tu souhaite continuer sur ce chemin,\n à tes risques et périls !");
		}
		
	}
	
	
	
//	GETTER ET SETTER ORIENTATION
	public StringProperty OrientationProperty() {
		return this.orientation;
	}

	public StringProperty getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation.set(orientation);
	}

}
