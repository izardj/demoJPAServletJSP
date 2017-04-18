package dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Adresse;
import metier.Contact;

public class Dao implements IDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");

	@Override
	public int ajouterAdresse(Adresse a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(a);
		tx.commit();
		em.close();
		return a.getId();
	}

	@Override
	public int ajouterContactAdresse(Contact c, Adresse a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		c.setAdresse(a);
		em.persist(c);
		tx.commit();
		em.close();
		return c.getId();
	}

	@Override
	public int modifierAdresse(Adresse a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(a);
		tx.commit();
		em.close();
		return a.getId();
	}

	@Override
	public Collection<Contact> findAllContacts() {
		EntityManager em = emf.createEntityManager();
		Collection<Contact> contacts = em.createNamedQuery("Contact.findAll").getResultList();
		em.close();
		return contacts;
	}

	@Override
	public Adresse findAdresse(int id) {
		EntityManager em = emf.createEntityManager();
		Adresse a = em.find(Adresse.class, id);
		em.close();
		return a;
	}

	@Override
	public void deleteAdresse(Adresse a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(a);
		tx.commit();
		em.close();

	}

}
