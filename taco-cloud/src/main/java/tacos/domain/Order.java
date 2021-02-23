package tacos.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import lombok.Data;

@Data
public class Order {
	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "street is required")
	private String street;
	@NotEmpty(message = "city is required")
	private String city;
	@NotEmpty(message = "state is required")
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
}