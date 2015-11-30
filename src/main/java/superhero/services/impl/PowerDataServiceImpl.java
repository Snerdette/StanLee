package superhero.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import superhero.dao.PowerDataDao;
import superhero.entities.Power;
import superhero.services.InvalidInputException;
import superhero.services.PowerDataService;

@Service
public class PowerDataServiceImpl implements PowerDataService{

	@Autowired
	PowerDataDao powerDataDao;
	
	public void setPowerDataDao(PowerDataDao powerDataDao){
		this.powerDataDao = powerDataDao;
	}
	
	@Override
	public List<Power> getPowerData() {
		
		List<Power> Power = powerDataDao.getPowerData();
		
		List<Power> allPower = new ArrayList<>();
		for(Power e : Power) {
			allPower.add(e);
		}
		
		return allPower;
	}
	
	@Override
	public Power getPowerById(Integer powerId) throws InvalidInputException {
		if(powerId == null || powerId < 0) {
			throw new InvalidInputException("PowerId.NullOrNegative");
		}
		return powerDataDao.getPowerById(powerId);
	}
	
	@Override
	public void add(Power power) {
		if(power == null) {
			throw new DataIntegrityViolationException("Please Select a Power");
		} else {
			powerDataDao.add(power);
		}
	}
	
	public void update(Power power) {
		if(power == null) {
			throw new DataIntegrityViolationException("Please Select a Power");
		}else{
			powerDataDao.update(power);
			}
	}
	
	public void delete(Integer i){
		powerDataDao.delete(i);
	}
}
