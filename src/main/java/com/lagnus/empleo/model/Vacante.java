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
		private @Getter @Setter Integer outstanding;
		private @Getter @Setter String	image="no-image.png";
		private @Getter @Setter String 	status;
		private @Getter @Setter String  detail;
		private @Getter @Setter String  vacant;
	
	}

	