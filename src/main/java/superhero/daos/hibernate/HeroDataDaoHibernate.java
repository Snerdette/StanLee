package superhero.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import superhero.dao.HeroDataDao;
import superhero.entities.Hero;

@Repository
@Transactional
public class HeroDataDaoHibernate implements HeroDataDao{
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Hero> getHeroData() {
		return em.createQuery("SELECT t FROM Hero t", Hero.class).
			getResultList();
	}
	
	@Override
	public boolean add(Hero hero) {
		boolean result = false;
		
		if(hero != null) {
			em.merge(hero);
			result = true;
		}
		
		return result;
	}
	
	@Override
	public void update(Hero hero) {
		em.merge(hero);
	}
	
	public Hero getHeroById(Integer heroId) {
		
		return em.
				createQuery("SELECT e FROM Hero e WHERE e.heroId = :id", Hero.class)
				.setParameter("id", heroId)
				.getSingleResult();
	}
	
	@Override
	public void delete(Integer heroId){
		
		Hero hero = getHeroById(heroId);
		em.remove(hero);
	}

}
