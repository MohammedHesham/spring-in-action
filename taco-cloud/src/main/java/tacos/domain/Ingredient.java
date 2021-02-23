package tacos.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Ingredient {

	public Ingredient(String id, String name, Type type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	private String id;
	private String name;
	private Type type;
	
	public enum Type{
		WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE
	}
	
	
}
