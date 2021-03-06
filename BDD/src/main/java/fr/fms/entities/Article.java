package fr.fms.entities;

public class Article {
	private int idArticle;
	private String description;
	private String brand;
	private double price;
	private int idCat;
	
	private int qty;
	
	/** Constructor
	 * @param idArticle
	 * @param description
	 * @param brand
	 * @param price
	 */
	public Article(int idArticle, String description, String brand, double price) {
		setIdArticle(idArticle);
		setDescription(description);
		setBrand(brand);
		setPrice(price);
	}

	/** Constructor
	 * @param idArticle
	 * @param description
	 * @param brand
	 * @param price
	 * @param idCat
	 */
	public Article(int idArticle, String description, String brand, double price, int idCat) {
		setIdArticle(idArticle);
		setDescription(description);
		setBrand(brand);
		setPrice(price);
		setIdCat(idCat);
	}

	/** Constructor
	 * @param description
	 * @param brand
	 * @param price
	 * @param idCat
	 */
	public Article(String description, String brand, double price, int idCat) {
		setDescription(description);
		setBrand(brand);
		setPrice(price);
		setIdCat(idCat);
	}
	
	/** Constructor
	 * @param idArticle
	 * @param price
	 */
	public Article(int IdArticle, double price) {
		setIdArticle(IdArticle);
		setPrice(price);
	}
	
	/** Constructor
	 * @param idArticle
	 */
	public Article(int IdArticle) {
		setIdArticle(IdArticle);
	}

	public Article() {
	}

	/**
	 * @return the idArticle
	 */
	public int getIdArticle() {
		return idArticle;
	}

	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the idCat
	 */
	public int getIdCat() {
		return idCat;
	}

	/**
	 * @param idCat the idCat to set
	 */
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	
	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "\n[idArticle = " + idArticle + ", description = " + description + ", brand = " + brand + ", price = "
				+ price +  "]"; //Article ", quantit?? = " + qty +
	}
	
	
}
