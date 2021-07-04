package provenda.pos.backend.user.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import provenda.pos.backend.user.dao.UserRepository;
import provenda.pos.backend.user.entity.UserEntity;
import reactor.core.publisher.Flux;

public class UserQueryServiceImpl implements UserQueryService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public Flux<UserEntity> findUserBySucursalIds(Set<Long> sucursalIds) {
		return userRepo.findUserBySucursalIds(sucursalIds);
	}

}
