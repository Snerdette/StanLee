package superhero.dao;

import java.util.List;

import superhero.entities.Hero;

public interface HeroDataDao {
	
	public List<Hero> getHeroData();
	
	void add(Hero hero);
	void update(Hero hero);
	void delete(Hero hero);
	public Hero getHeroById(Integer heroId);

}
