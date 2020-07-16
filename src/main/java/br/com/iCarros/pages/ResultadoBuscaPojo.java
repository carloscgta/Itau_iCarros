package br.com.iCarros.pages;

import com.google.gson.annotations.SerializedName;

public class ResultadoBuscaPojo {

	
	
	@SerializedName("id")
	private Integer id;
	@SerializedName("username")
	private String username;
		
	@SerializedName("firstName")
	private String firstName;
	
	@SerializedName("lastName")
	private String lastName;
	
	@SerializedName("email")
	private String email;

}
