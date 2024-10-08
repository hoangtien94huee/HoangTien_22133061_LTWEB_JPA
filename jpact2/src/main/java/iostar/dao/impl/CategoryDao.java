package iostar.dao.impl;

import java.util.List;

import iostar.configs.JPAConfig;
import iostar.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CategoryDao {
	void insert(CategoryDao category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {

			trans.begin();
			enma.persist(category);
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}
	}
	void update(CategoryDao category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {

			trans.begin();
			enma.merge(category);
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}
	}
	void delete(CategoryDao category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {

			trans.begin();
			enma.remove(category);
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}
	}
	public Category findById(int cateid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Category category = enma.find(Category.class, cateid);
		return category;
	}
	
	public List<Category> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		//TypedQuery<Category> query = enma.createNamedQuery("Category.findALL",Category.class);
	}
}
