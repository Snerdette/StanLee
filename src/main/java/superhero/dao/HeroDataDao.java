package superhero.dao;

import java.util.List;

import superhero.entities.Hero;

public interface HeroDataDao {
	
	public List<Hero> getHeroData();
	
	boolean add(Hero hero);
	
	void update(Hero hero);
	
	void delete(Integer heroId);
	
	public Hero getHeroById(Integer heroId);

}
