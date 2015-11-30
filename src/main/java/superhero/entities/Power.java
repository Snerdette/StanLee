package superhero.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity

@Table(name="Power", schema="public")
public class Power {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String power;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getPower(){
		return power;
	}
	
	public void setPower(String power){
		this.power = power;
	}
	
	public Object getPowerId() {
		return this.getId();
	}
	
}
