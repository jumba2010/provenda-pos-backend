package provenda.pos.backend.user.service;

import java.util.Set;

import provenda.pos.backend.user.entity.UserEntity;
import reactor.core.publisher.Flux;

public interface UserQueryService {
	
	Flux<UserEntity> findUserBySucursalIds(Set<Long> sucursalIds );
}
