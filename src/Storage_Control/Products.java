package Storage_Control;

public class Products extends Supplier{

	
	
	private int Id_products;	
	private String nom_product;
	private double sell_price;
	private double purchase_price;
	private int quantity;
	
	private int ID_supplier;

	public int getId_products() {
		return Id_products;
	}

	public void setId_products(int id_products) {
		Id_products = id_products;
	}

	public String getNom_product() {
		return nom_product;
	}

	public void setNom_product(String nom_product) {
		this.nom_product = nom_product;
	}

	public double getSell_price() {
		return sell_price;
	}

	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}

	public double getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(double purchase_price) {
		this.purchase_price = purchase_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getID_supplier() {
		return ID_supplier;
	}

	public void setID_supplier(int iD_supplier) {
		ID_supplier = iD_supplier;
	}
	
	
}
