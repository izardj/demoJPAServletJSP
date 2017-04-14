package service;

import java.util.Collection;

import dao.Dao;
import dao.IDao;
import metier.Adresse;
import metier.Contact;

public class IServiceImpl implements IService {

	private IDao dao = new Dao();

	@Override
	public int ajouterAdresse(Adresse a) {
		return dao.ajouterAdresse(a);
	}

	@Override
	public int ajouterContactAdresse(Contact c, Adresse a) {
		return dao.ajouterContactAdresse(c, a);
	}

	@Override
	public int modifierAdresse(Adresse a) {
		return dao.modifierAdresse(a);
	}

	@Override
	public Collection<Contact> findAllContacts() {
		return dao.findAllContacts();
	}

	@Override
	public Adresse findAdresse(int id) {
		return dao.findAdresse(id);
	}

	@Override
	public void deleteAdresse(Adresse a) {
		dao.deleteAdresse(a);

	}

}
