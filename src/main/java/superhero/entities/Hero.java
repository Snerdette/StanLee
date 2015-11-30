package superhero.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import superhero.entities.Power;


@Entity
@Table(name = "Heros", schema = "public")
public class Hero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "power_id")
	private Power power;

	@NotNull
	@Length(max = 250)
	private String name;
	
	@NotNull
	@Length(max = 16)
	@Column(name = "sran", unique = true)
	private Integer sran;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeroId() {
		return this.getId();
	}

	public Integer getSRAN() {
		return this.getSRAN();
	}
	
	public void setSRAN(Integer sran){
		this.sran = sran;
	}
	
}
