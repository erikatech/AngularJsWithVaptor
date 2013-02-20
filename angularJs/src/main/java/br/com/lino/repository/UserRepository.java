package br.com.lino.repository;

import java.util.List;

import br.com.lino.model.User;

public interface UserRepository {

	public void save(User user);

	public void update(User user);

	public void delete(User user);

	public List<User> list();

}
