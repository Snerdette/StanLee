package superhero.daos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import superhero.dao.PowerDataDao;
import superhero.entities.Power;

@Repository
@Transactional
public class PowerDataDaoHibernate implements PowerDataDao {

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void add(Power power) {
		em.persist(power);
	}

	public void update(Power power) {
		em.merge(power);
	}

	public void delete(Integer powerId) {
		Power power = getPowerById(powerId);
		em.remove(power);
	}

	public Power getPowerById(Integer powerId) {
		return em.createQuery("SELECT e FROM Power e WHERE e.PowerId = :id", Power.class)
				.setParameter("id", powerId)
				.getSingleResult();

	}

	@Override
	public List<Power> getPowerData() {
		// TODO Auto-generated method stub
		return null;
	}

}
