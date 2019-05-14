package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
@Entity
@Table(name = "pirates")
public class Pirate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	private String role;
	
	
	
	
	
	private DevilFruit devilFruit;
	
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.MERGE, CascadeType.DETACH}) // @OneToMany - dictates that this relationship is one-to-many
    // where one is the Cave and Many are the Bears
    @JoinColumn(name = "captain_id") // Creates a JoinColumn for holding this relationship

	private List<Pirate> crew;
	
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "pirate_ships", joinColumns = { @JoinColumn(name = "pirate_id") }, inverseJoinColumns = {
			@JoinColumn(name = "ship_id") })
	private List<Ship> ships;





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public DevilFruit getDevilFruit() {
		return devilFruit;
	}





	public void setDevilFruit(DevilFruit devilFruit) {
		this.devilFruit = devilFruit;
	}





	public List<Pirate> getCrew() {
		return crew;
	}





	public void setCrew(List<Pirate> crew) {
		this.crew = crew;
	}





	public List<Ship> getShips() {
		return ships;
	}





	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crew == null) ? 0 : crew.hashCode());
		result = prime * result + ((devilFruit == null) ? 0 : devilFruit.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ships == null) ? 0 : ships.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pirate other = (Pirate) obj;
		if (crew == null) {
			if (other.crew != null)
				return false;
		} else if (!crew.equals(other.crew))
			return false;
		if (devilFruit == null) {
			if (other.devilFruit != null)
				return false;
		} else if (!devilFruit.equals(other.devilFruit))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ships == null) {
			if (other.ships != null)
				return false;
		} else if (!ships.equals(other.ships))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "Pirate [id=" + id + ", name=" + name + ", devilFruit=" + devilFruit + ", crew=" + crew + ", ships="
				+ ships + "]";
	}





	public Pirate(int id, String name, DevilFruit devilFruit, List<Pirate> crew, List<Ship> ships) {
		super();
		this.id = id;
		this.name = name;
		this.devilFruit = devilFruit;
		this.crew = crew;
		this.ships = ships;
	}





	public Pirate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
