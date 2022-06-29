package com.lagnus.empleo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Categoria {

	private @Getter @Setter Integer id;
	private @Getter @Setter String name;
	private @Getter @Setter String description;


}
