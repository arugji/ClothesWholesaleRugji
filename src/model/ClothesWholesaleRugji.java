package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * arugji
 * CIS171 12928
 */


@Entity
@Table(name="clothes")

public class ClothesWholesaleRugji {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="Brand")
	private String brand;
	
	@Column(name="Item")
	private String item;
	
	
	public  ClothesWholesaleRugji() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public  ClothesWholesaleRugji(String brand, String item) {
		super();
		this.brand = brand;
		this.item = item;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
	 brand = brand;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	public String returnClothesInfo( ) {
		return brand + ": " + item;
	}

	


}
