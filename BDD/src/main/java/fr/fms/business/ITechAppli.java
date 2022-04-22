/**
 * 
 */
package fr.fms.business;

import java.util.ArrayList;
import fr.fms.entities.Article;
import fr.fms.entities.User;

/**
 * @author Stagiaires10P
 *
 */

public interface ITechAppli {
	public void addToCart(Article article); //update
	public boolean resetCart();
	public void deleteArt(Article article);
	public ArrayList<Article> displayCart(); //retourne l'arrayList pour ne pas toucher à notre structure HashMap
	public void pay();
	public ArrayList<Article> displayArticles(); //On n'utilise pas la méthode de la couche DAO car l'appli ne doit pas avoir accès direct à la couche dao mais bien passer par la couche métier
	public Article getArticleById(int id);
	public boolean isUser(User user);
}
