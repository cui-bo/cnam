package administration;

import production.Stocks;

public interface Administration {
	public Catalogues recupererCatalogue();
	public Stocks recupererQuantiteParProduitId(Produits produit_id);
}
