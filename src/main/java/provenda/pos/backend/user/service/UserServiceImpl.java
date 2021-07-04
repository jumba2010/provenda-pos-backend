package provenda.pos.backend.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import provenda.pos.backend.generic.service.AbstractService;
import provenda.pos.backend.security.UserContext;
import provenda.pos.backend.user.entity.UserEntity;
import reactor.core.publisher.Mono;

public class UserServiceImpl implements UserService {

	@Autowired
	private AbstractService<UserEntity, Long> userService;

	@Override
	public Mono<UserEntity> createUser(UserContext userContext, Mono<UserEntity> user) {
		user.subscribe(u->{
			 userService.create(userContext, u);
			
		});
		
	return user;
	
	}



}
