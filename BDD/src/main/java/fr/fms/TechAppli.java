package fr.fms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

import fr.fms.business.ImplTechAppli;
import fr.fms.dao.ArticlesDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class TechAppli {

	public static void main(String[] args) {
		//Initialization
		//ArrayList<Article> cart = new ArrayList<Article>();
		
		User user = new User();
		
		boolean loop = true;
		boolean isLogged = false;
		
		Scanner scanner = new Scanner(System.in);
		
		ImplTechAppli techApp = new ImplTechAppli();
		
		//ArrayList<Article> cart = techApp.displayCart();
		//End init
		
		System.out.println("Bonjour et bienvenus sur notre application de commande de produits technologiques.\n");
		
		
		while(loop) {
			displayMenu();
			
			checkInt(scanner);
			int choice = scanner.nextInt();
			
			switch(choice) {
			
			case 1 :
				printArticles(techApp);
				break;
				
			case 2 :
				System.out.println("Quel article souhaitez-vous ajouter à votre panier ?");
				printArticles(techApp);
				
				checkInt(scanner);
				int art = scanner.nextInt();
				
				if(techApp.getArticleById(art) != null) {
					techApp.addToCart(techApp.getArticleById(art));
					System.out.println("Vous avez ajouté " + techApp.getArticleById(art).getDescription() + " - " + techApp.getArticleById(art).getBrand() + ".\n");
				} else {
					System.out.println("L'article n'existe pas.\n");
				}
				
				break;
				
			case 3 :
				if(!techApp.displayCart().isEmpty()) {
					System.out.println("Quel article souhaitez-vous supprimer votre panier ?");
					printCart(techApp);
					System.out.println();
					
					checkInt(scanner);
					art = scanner.nextInt();

					if(techApp.inCart(art)) {
						techApp.deleteArt(techApp.getArticleById(art));
						System.out.println("L'article " + techApp.getArticleById(art).getDescription() + " a bien été supprimé.\n");
					} else {
						System.out.println("L'article selectionné n'est pas présent dans votre panier. \n");
					}
					
				} else {
					System.out.println("Votre panier est vide.\n");
				}
				
				break;
				
			case 4 :			
				if(!techApp.displayCart().isEmpty()) {
					printCart(techApp);
					System.out.println();
				} else {
					System.out.println("Votre panier est vide.\n");
				}
				break;
				
			case 5 :
				if(!techApp.displayCart().isEmpty()) {
					System.out.println("Voulez vous vraiment vider votre panier ? Taper O pour confirmer.");
					String answer = scanner.next();
					
					if (answer.equalsIgnoreCase("o")) {
						techApp.resetCart();
						System.out.println("Votre panier a bien été vidé.\n");
					} else {
						System.out.println("La réponse n'est pas valide.\n");
					}
				} else {
					System.out.println("Votre panier est vide.\n");
				}
				break;
				
			case 6 :
				if(!techApp.displayCart().isEmpty()) {
					//auth();
					while(!isLogged) {
						System.out.println("Veuillez saisir un login : ");
						String log = scanner.next();
						
						if(log.equals("0")) {
							break;
						}
						
						System.out.println("Veuillez saisir un mot de passe : ");
						String pwd = scanner.next();
						
						user = new User(log, pwd);
						
						if(techApp.isUser(user)) {
							isLogged = true;
							System.out.println("Vous êtes bien connecté.");
						}
					}
						
					if(techApp.isUser(user)) {
						System.out.println("Votre panier : \n");
						printCart(techApp);
						System.out.println("\nVoulez-vous valider votre commande ? Tapez O pour valider ou 0 pour revenir au menu principal.");
						String answer = scanner.next();
						
						if(answer.equalsIgnoreCase("o")) {
							techApp.pay();
							System.out.println("Votre commande a bien été validée. Votre panier est vide.\n");
						} else if (answer.equals("0")) {
							break;
						} else {
							System.out.println("Choix non valide, retour au menu.\n");
						}

						
					} else {
						System.out.println("Votre compte n'existe pas. Veuillez ressayer ou taper 0 pour revenir au menu principal.\n");
					}

				} else {
					System.out.println("Votre panier est vide, vous ne pouvez pas passer commande.\n");
				}
				break;
				
			case 7 :
				System.out.println("Au revoir !");
				loop = false;
				break;
			}
			
		} 	
		scanner.close();
	}

	public static void displayMenu() {
		System.out.println("Que souhaitez-vous faire ?");
		System.out.println("--------------------------");
		System.out.println("1. Afficher la liste complète des articles.");
		System.out.println("2. Ajouter un article à ma commande.");
		System.out.println("3. Supprimer un article du panier.");
		System.out.println("4. Visualiser le panier");
		System.out.println("5. Vider mon panier.");
		System.out.println("6. Passer commande.");
		System.out.println("7. Quitter l'application.");
	}
	
	/**
	 * Vérifie que la réponse donnée par l'utilisateur soit bien un int
	 * @param scanner
	 */
	public static void checkInt(Scanner scanner) {
		while(!scanner.hasNextInt()) scanner.next();
	}
	
	/**
	 * Affiche le panier 
	 * @param ImplTechAppli
	 */
	public static void printCart(ImplTechAppli techApp) {
		techApp.displayCart().forEach((n) -> 
		System.out.println("Ref : " + n.getIdArticle() + " - " + n.getDescription() + " - " + n.getBrand() + " - " + n.getPrice() + "€ - quantité : " + n.getQty()));	
	}
	
	/**
	 * Affiche la liste des articles organisée
	 * @param ImplTechAppli
	 */
	public static void printArticles(ImplTechAppli techApp) {
		String format  = "%1$-4s | %2$-30s | %3$-20s | %4$-8s |\n";
		
		System.out.println(String.join("", Collections.nCopies(73, "-")));
		System.out.format(format, "REF", "DESCRIPTION", "MARQUE", "PRIX");
		System.out.format(format, "----", String.join("", Collections.nCopies(30, "-")), String.join("", Collections.nCopies(20, "-")), "--------");
		
		techApp.displayArticles().forEach((n) -> 
		System.out.format(format, n.getIdArticle(), n.getDescription(), n.getBrand(), n.getPrice() + "€", n.getQty()));
		
		System.out.println(String.join("", Collections.nCopies(73, "-")) + "\n");
	}
	
//	public static void auth() {
//		while(!isLogged) {
//			System.out.println("Veuillez saisir un login : ");
//			String log = scanner.next();
//			
//			if(log.equals("0")) {
//				break;
//			}
//			
//			System.out.println("Veuillez saisir un mot de passe : ");
//			String pwd = scanner.next();
//			
//			user = new User(log, pwd);
//			
//			if(techApp.isUser(user)) {
//				isLogged = true;
//				System.out.println("Vous êtes bien connecté.");
//			}
//		}
//	}
}
