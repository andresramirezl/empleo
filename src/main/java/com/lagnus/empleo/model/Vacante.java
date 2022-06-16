package com.lagnus.empleo.model;

import java.awt.Image;
import java.util.Date;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

	@ToString
	public class Vacante{
	
		private @Getter @Setter Integer id;
		private @Getter @Setter String 	name;
		private @Getter @Setter String 	description;
		private @Getter @Setter Date 	date;
		private @Getter @Setter	Double 	salary;
		private @Getter @Setter Integer destacado;
		private @Getter @Setter String	imagen="no-image.png";
	
	}

	