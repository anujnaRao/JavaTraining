

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="PRODUCTS")
public class Product {
	@id;
	private String name;
	private String description;
	private String brand;
	private String category;
	@Column(name="quantity_Per_Unit");
	@Column(name="unit_price");
	private double discount;
	private String picture;
	
	
}
