package com.ritesh.hazelcast.cache.api.dao;

import com.ritesh.hazelcast.cache.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
