package shuo.laoma.cls.c14;

public class Product {
	//唯一id
	private String id; 
	
	//产品名称 
	private String name; 
	
	//产品图片链接	
	private String pictureUrl; 
	
	//产品描述
	private String description;
	
	//产品价格
	private double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	} 
	
	
}


