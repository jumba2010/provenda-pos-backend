package provenda.pos.backend.user.service;

import provenda.pos.backend.security.UserContext;
import provenda.pos.backend.user.entity.UserEntity;
import reactor.core.publisher.Mono;

public interface UserService {
	
	public abstract Mono<UserEntity> createUser(UserContext userContext,Mono<UserEntity> user);
	
}
