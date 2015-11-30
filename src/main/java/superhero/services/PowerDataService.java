package superhero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import superhero.entities.Power;
import superhero.entities.Hero;

public interface PowerDataService {
	
	public List<Power> getPowerData();
	
	Power getPowerById(Integer powerId) throws InvalidInputException;
	
	public void add(Power power);
	
	public void update(Power power);
	
}
