package com.pett4j.skipthedishes.jpa;

import org.springframework.data.repository.CrudRepository;

import com.pett4j.skipthedishes.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
