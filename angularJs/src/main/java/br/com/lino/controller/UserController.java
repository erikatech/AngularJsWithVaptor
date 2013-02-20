package br.com.lino.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lino.model.User;
import br.com.lino.repository.UserRepository;

@Resource
public class UserController {

	private Result result;

	private UserRepository users;

	public UserController(Result result, UserRepository users) {
		this.result = result;
		this.users = users;
	}

	@Post("/users")
	@Consumes("application/json")
	public void save(User user) {
		users.save(user);
		result.use(Results.json()).withoutRoot().from(user).serialize();
	}

	@Put("/users/{user.id}")
	@Consumes("application/json")
	public void update(User user) {
		users.update(user);
		result.nothing();
	}

	@Delete("/users/{user.id}")
	public void delete(User user) {
		users.delete(user);
		result.nothing();
	}

	@Get("/users")
	public void list() {
		result.use(Results.json())
				.withoutRoot()
				.from(users.list())
				.serialize();
	}

}
