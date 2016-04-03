package businessLayer;

public class Product {
	private long idProduct;
	private String name;
	private int stock;
	private double buyPrice;
	private double salePrice;
	private String description;
	private Category category;
	
	public Product()
	{
		this.idProduct = 0;
		this.name = "";
		this.stock = 0;
		this.buyPrice = 0.0;
		this.salePrice = 0.0;
		this.description = "";
		this.category = new Category();
	}
	
	public Product(int id, String nam, int stock, double buyP, double saleP, String desc, Category cat)
	{
		this.idProduct = id;
		this.name = nam;
		this.stock = stock;
		this.buyPrice = buyP;
		this.salePrice = saleP;
		this.description = desc;
		this.category = cat;
	}

	public long getIdProduct() 
	{
		return idProduct;
	}
	
	public void setIdProduct(long idProduct) 
	{
		this.idProduct = idProduct;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getStock() 
	{
		return stock;
	}
	
	public void setStock(int stock) 
	{
		this.stock = stock;
	}
	
	public double getBuyPrice() 
	{
		return buyPrice;
	}
	
	public void setBuyPrice(double buyPrice) 
	{
		this.buyPrice = buyPrice;
	}
	
	public double getSalePrice() 
	{
		return salePrice;
	}

	public void setSalePrice(double salePrice) 
	{
		this.salePrice = salePrice;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public Category getCategory() 
	{
		return category;
	}
	
	public void setCategory(Category category) 
	{
		this.category = category;
	}
	
}
