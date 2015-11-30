package superhero.dao;

import java.util.List;

import superhero.entities.Power;

public interface PowerDataDao {
	
	public List<Power> getPowerData();
	
	void add(Power power);
	
	void update(Power power);
	
	void delete(Integer powerId);
	
	public Power getPowerById(Integer powerId);
	
}
