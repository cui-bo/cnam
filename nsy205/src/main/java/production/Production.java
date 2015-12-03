package production;

import administration.Produits;

public interface Production {

	public boolean commanderProduit(Produits produit_id);	// Maj la quantité du produit s'il n'est pas vide

}
