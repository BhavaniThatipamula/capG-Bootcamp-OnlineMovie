package com.cg.onlinemovie.entity;
 
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/*************************************************************************************************************************
 *         @author          BhavaniThatipamula
 *         Description      It is an entity class of Theatre, which maps to a database table theatre_tbl , consists
 *          				of its private data members, setters and getters , parameterized and default constructors..
 *         Version          1.0
 *         Created Date     12-AUG-2020
 *************************************************************************************************************************/

@Entity
@Table(name="theatre_tbl")
public class Theatre {
	
	
	public Theatre() {
		super();
	}
	
	public Theatre(int theatreId, String theatreName, String theatreCity) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		 
	}

	@Id
	@Column(name="theatre_Id", length=4)
	private int theatreId;
	
	@Column(name="theatreName",length=15)
	private String theatreName;
	
	@Column(name="theatreCity",length=15)
	private String theatreCity;
	
	@OneToMany(mappedBy="theatre")
    @JsonIgnore
	private List<Screen> listOfScreens;
	
	@Column(name="managerName",length=15)
	private String managerName;
	
	@Column(name="managerContact",length=10)
	private String managerContact;
	
	
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreCity() {
		return theatreCity;
	}
	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}
	public List<Screen> getListOfScreens() {
		return listOfScreens;
	}
	public void setListOfScreens(List<Screen> listOfScreens) {
		this.listOfScreens = listOfScreens;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	 

}
