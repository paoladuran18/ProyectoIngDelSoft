package businessLayer;

public class Category 
{
	private int idCategory;
	private String name;
	private String description;
	
	public Category()
	{
		this.idCategory = 0;
		this.name = "";
		this.description = "";
	}
	
	public Category(int id, String nam, String desc)
	{
		this.idCategory = id;
		this.name = nam;
		this.description = desc;
	}
	
	public int getIdCategory() 
	{
		return idCategory;
	}
	
	public void setIdCategory(int idCategory) 
	{
		this.idCategory = idCategory;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public Category search(String typeSearch)
	{
		//AQUI VA CODIGO
		Category cat = new Category();
		return cat;
	}
	
	public boolean delete(Category cat)
	{
		//AQUI VA CODIGO
		return false;
	}
	
	public boolean modify(String cat)
	{
		return false;
	}
}
