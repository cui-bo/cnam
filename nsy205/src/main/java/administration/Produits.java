package administration;

public class Produits {
	private int produit_id;
	private String description;
	private double prix;
//	private int catalogue_id;
	
	
	public int getProduit_id() {
		return produit_id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	

}
