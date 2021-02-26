package tacos.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Taco {
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long!")
	private String name;

	private Date createdAt;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToMany
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;

	@PrePersist
	public void createdAt() {
		createdAt = new Date();
	}
}