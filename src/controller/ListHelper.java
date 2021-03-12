package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.ClothesWholesaleRugji;

/**
 * arugji
 * CIS172
 */
public class ListHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ClothesWholesaleRugji");
	public void insertCloth(ClothesWholesaleRugji c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();

	}
	
	public List<ClothesWholesaleRugji> showAllClothes(){
		EntityManager em = emfactory.createEntityManager();
			List<ClothesWholesaleRugji> allClothes = em.createQuery("SELECT c FROM  ClothesWholesaleRugji c").getResultList();
			return allClothes;
			}
	public void deleteCloth(ClothesWholesaleRugji toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ClothesWholesaleRugji> typedQuery = em.createQuery("select cw from ClothesWholesaleRugji cw where cw.brand = :selectedBrand and cw.item = :selectedItem", ClothesWholesaleRugji.class);

		typedQuery.setParameter("selectedBrand", toDelete.getBrand());
		typedQuery.setParameter("selectedItem", toDelete.getItem());

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		ClothesWholesaleRugji result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public ClothesWholesaleRugji searchForClothById(int idToEdit) {
		// TODO Auto-generated method stub
		

		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ClothesWholesaleRugji found = em.find(ClothesWholesaleRugji.class, idToEdit);
		em.close();
		return found;

	}
	public List<ClothesWholesaleRugji> searchForClothByBrand(String BrandName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ClothesWholesaleRugji> typedQuery = em.createQuery("select b from ClothesWholesaleRugji b where b.brand = :selectedBrand", ClothesWholesaleRugji.class);
		typedQuery.setParameter("selectedBrand", BrandName);

		List<ClothesWholesaleRugji> foundCloth = typedQuery.getResultList();
		em.close();
		return foundCloth;
	}

	
	public List<ClothesWholesaleRugji> searchForItemByClothModel(String modelName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ClothesWholesaleRugji> typedQuery = em.createQuery("select cw from ClothesWholesaleRugji cw where cw.item = :selectedItem", ClothesWholesaleRugji.class);
		typedQuery.setParameter("selectedModel", modelName);

		List<ClothesWholesaleRugji> foundCloth = typedQuery.getResultList();
		em.close();
		return foundCloth;
}


	/**
	 * @param toEdit
	 */
	public void updateCloth(ClothesWholesaleRugji toEdit) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				
				em.merge(toEdit);
				em.getTransaction().commit();
				em.close();

		
	}
	
	public void cleanUp(){
		emfactory.close();
	}


}
