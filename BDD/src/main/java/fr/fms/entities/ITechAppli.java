/**
 * 
 */
package fr.fms.entities;

import java.util.ArrayList;

/**
 * @author Stagiaires10P
 *
 */
public interface ITechAppli {
	public boolean addToCart(Article article); //update
	public boolean resetCart();
	public boolean deleteArt(Article article);
	public ArrayList<Article> displayCart();
	public boolean pay();
}
