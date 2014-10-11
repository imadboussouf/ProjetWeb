package Favoris;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Favoris  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id = -1;
    private String nom;
    private String adresse;
    private String categorie;

    public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = '#'+categorie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}