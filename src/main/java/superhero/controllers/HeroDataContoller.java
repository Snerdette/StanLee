/*package superhero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HeroDataContoller {


	@Autowired
	private HeroDataService heroDataService;
	
	
	public void setHeroDataService(HeroDataService heroDataService) {
		this.heroDataService = heroDataService;
	}
	

	@RequestMapping(value="/hero", method=RequestMethod.GET)  
	public List<Hero> getHeroData() {
		
		return heroDataService.getHeroData();
	}
	
	@RequestMapping(value="/hero", method=RequestMethod.POST)  
	public void add(@RequestBody Hero hero) { 
		
		System.out.println(hero);
		heroDataService.add(hero);
	}
	
	@RequestMapping(value="/hero/{id}", method=RequestMethod.PUT)
	public void updateById(@PathVariable Integer id, @RequestBody Hero hero){ 
		hero.setId(id);
		heroDataService.update(hero);
	}
}
*/