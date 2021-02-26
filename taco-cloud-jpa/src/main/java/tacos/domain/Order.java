package tacos.domain;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import lombok.Data;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "street is required")
	private String street;
	@NotEmpty(message = "city is required")
	private String city;
	@NotEmpty(message = "state is required")
	@Size(max = 2,message = "State length must be 2")
	private String state;
	@NotEmpty(message = "zip is required")
	private String zip;
	@CreditCardNumber(message = "ccNumber is required")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
			message="Must be formatted MM/YY")
	private String ccExpiration;
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	private String ccCVV;
	
	private Date placedAt;

	@ManyToMany(targetEntity = Taco.class)
	private List<Taco> designs=new ArrayList<>();
	
	public void addDesign(Taco design) {
		designs.add(design);
	}
	
	@PrePersist
	public void placedAt() {
		placedAt = new Date();
	}
}