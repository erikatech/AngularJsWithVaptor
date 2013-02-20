package br.com.lino.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.caelum.vraptor.ioc.Component;
import br.com.lino.model.User;
import br.com.lino.repository.UserRepository;

@Component
@Qualifier("users")
public class UserDAO implements UserRepository {

	private final Session session;

	public UserDAO(Session session) {
		this.session = session;
	}

	@Override
	public void save(User user) {
		session.save(user);
	}

	@Override
	public void update(User user) {
		session.update(user);
	}

	@Override
	public void delete(User user) {
		session.delete(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> list() {
		return session.createCriteria(User.class).list();
	}

}
