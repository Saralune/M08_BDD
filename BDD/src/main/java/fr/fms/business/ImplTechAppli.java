package fr.fms.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;

import fr.fms.dao.ArticlesDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class ImplTechAppli implements ITechAppli {
	
	HashMap<Integer, Article> cart = new HashMap<Integer, Article>();

	@Override
	public void addToCart(Article article) {

		if(article != null) {
			int getArt = article.getIdArticle();
			
			if(cart.get(getArt) == null) {
				cart.put(getArt, article);
			}
			cart.get(getArt).setQty(cart.get(getArt).getQty() + 1);
			
		} else {
			throw new NullPointerException("L'article n'existe pas"); 
		}
	}

	@Override
	public boolean resetCart() {
		if(cart != null) {
			cart.clear();
			return true;
		}
		return false;
	}

	@Override
	public void deleteArt(Article article) {
		int qtyArt = cart.get(article.getIdArticle()).getQty();
		Article artInCart = cart.get(article.getIdArticle());
		
		if (artInCart != null && qtyArt > 1) {
			artInCart.setQty(qtyArt - 1);
			
		} else if (artInCart == null || qtyArt <= 1){
			cart.remove(article.getIdArticle());
			
		}
	}

	@Override
	public ArrayList<Article> displayCart() {	//streammmm	
		ArrayList<Article> list = new ArrayList<Article>();
		
		for(Map.Entry<Integer, Article> entry : cart.entrySet()) {
			list.add(entry.getValue());
		}
		
		return list;
	}
	

	@Override
	public void pay() {
		resetCart();
	}

	@Override
	public ArrayList<Article> displayArticles() {
		return new ArticlesDao().readAll();
	}

	@Override
	public Article getArticleById(int id) {
		return new ArticlesDao().read(id);
	}
	
	/**
	 * 
	 * */
	@Override
	public boolean isUser(User user) {
		return new UserDao().isUser(user);
	}

	/**
	 * 
	 * */
	public boolean inCart(int id) {

		for(Map.Entry<Integer, Article> entry : cart.entrySet()) {
			if(entry.getKey() == id) {
				return true;
			}
		}
		
		return false;
	}
	

}
