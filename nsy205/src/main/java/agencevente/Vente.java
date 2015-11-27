package agencevente;

import administration.Catalogues;
import administration.Produits;
import production.Stocks;

public interface Vente {
	
	public Catalogues recupererCatalogue();
	public Stocks recupererQuantiteParProduitId(Produits produit_id);
	
	public boolean commanderProduit(Produits produit_id);	// Maj la quantité du produit s'il n'est pas vide

}
