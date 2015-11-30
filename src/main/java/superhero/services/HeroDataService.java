package superhero.services;

import java.util.List;
import superhero.entities.Hero;
import org.springframework.beans.factory.annotation.Autowired;

public interface HeroDataService {

	public List<Hero> getHeroData();
	
	Hero getHeroById(Integer heroId)throws InvalidInputException;
	
	public void add(Hero hero);
	
	public void update(Hero hero);
	
	public void delete(Hero hero);
	
}
