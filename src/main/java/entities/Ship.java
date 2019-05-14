package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
@Entity
@Table(name = "ship")
public class Ship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	
	
	
	
	
	
	@Column(name = "surface_area")
	private double surfaceArea;








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








	public double getSurfaceArea() {
		return surfaceArea;
	}








	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}








	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(surfaceArea);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Ship other = (Ship) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(surfaceArea) != Double.doubleToLongBits(other.surfaceArea))
			return false;
		return true;
	}








	@Override
	public String toString() {
		return "Ship [id=" + id + ", name=" + name + ", surfaceArea=" + surfaceArea + "]";
	}








	public Ship(int id, String name, double surfaceArea) {
		super();
		this.id = id;
		this.name = name;
		this.surfaceArea = surfaceArea;
	}








	public Ship() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
