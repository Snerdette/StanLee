package superhero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import superhero.entities.Power;
import superhero.services.PowerDataService;

public class PowerDataContoller {
	
	@Autowired
	private PowerDataService powerDataService;
	
	public void setPowerDataService(PowerDataService powerDataService){
		this.powerDataService = powerDataService;
	}
	
	@RequestMapping(value="/power", method=RequestMethod.GET)
	public List<Power> getPowerData() {
		return powerDataService.getPowerData();
	}

}
