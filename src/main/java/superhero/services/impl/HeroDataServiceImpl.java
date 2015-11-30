package superhero.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import superhero.dao.HeroDataDao;
import superhero.dao.PowerDataDao;
import superhero.entities.Hero;
import superhero.entities.Power;
import superhero.services.HeroDataService;
import superhero.services.InvalidInputException;

@Service
public class HeroDataServiceImpl implements HeroDataService {
	
	@Autowired
	HeroDataDao heroDataDao;
	@Autowired
	PowerDataDao powerDataDao;


	// setter for object UserDataDao
	public void setHeroDataDao(HeroDataDao heroDataDao) {
		this.heroDataDao = heroDataDao;
	}

	// finds all the different objects and returns all of them.
	@Override
	public List<Hero> getHeroData() {
		List<Hero> hero = heroDataDao.getHeroData();
		List<Hero> allHero = new ArrayList<>();
		
		for (Hero e : hero) {
			allHero.add(e);
		}

		return allHero;
	}

	// searches for a specific id in the collections list so the item
	// corresponding to that id can be manipulated.
	@Override
	public Hero getHeroById(Integer heroId) throws InvalidInputException {
		if (heroId == null || heroId < 0) {
			throw new InvalidInputException("KeywordId.NullOrNegative");
		}
		return heroDataDao.getHeroById(heroId);
	}

	public void add(Hero hero) {
		
		if (hero == null) {
			throw new DataIntegrityViolationException("Hero number is null");
		}
		List<Hero> heroList = heroDataDao.getHeroData();
		Integer SRAN = hero.getSRAN();
		for (int i = 0; i < heroList.size(); i++) {
			Hero heroInHeroList = heroList.get(i);
			if (heroInHeroList.getSRAN().equals(SRAN)) {
				throw new DataIntegrityViolationException("Catalog number is already in use");
			}
		}

		validatePower(hero);
		validateName(hero);
		heroDataDao.add(hero);
	}

	public void update(Hero hero) {
		if (hero == null) {
			throw new DataIntegrityViolationException("Hero number is null");
		}

		validatePower(hero);
		validateName(hero);
		heroDataDao.update(hero);
	}

	public boolean validatePower(Hero hero) {
		Power heroPower = hero.getPower();
		String power = heroPower.getPower();
		boolean result = false;
		if (power == null || power.equals("")) {
			throw new DataIntegrityViolationException("Power is Null or Empty");
		}
		if (power.length() > 50) {
			throw new DataIntegrityViolationException("Power is too long");
		} else {
			result = true;
		}
		for (Power p : powerDataDao.getPowerData()) {
			if (p.getPower().equals(power)) {
				hero.setPower(p);
			}
		}

		return result;
	}

	public boolean validateName(Hero hero) {
		String name = hero.getName();
		boolean result = false;
		if (name == "" || name == null) {
			throw new DataIntegrityViolationException("Name is Null or Empty");
		}
		if (name.length() > 255) {
			throw new DataIntegrityViolationException("Name is too long");
		} else {
			result = true;
		}
		return result;
	}

	// deletes based on Integer ID of the object
	public void delete(Integer i) {
		heroDataDao.delete(i);

	}

	public PowerDataDao getPowerDataDao() {
		return powerDataDao;
	}

	public void setPowerDataDao(PowerDataDao powerDataDao) {
		this.powerDataDao = powerDataDao;
	}

	@Override
	public void delete(Hero hero) {
		// TODO Auto-generated method stub
		
	}

}
