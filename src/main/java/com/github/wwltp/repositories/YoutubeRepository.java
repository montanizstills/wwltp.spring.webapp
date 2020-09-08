package com.github.wwltp.repositories;

import com.github.wwltp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YoutubeRepository extends CrudRepository<User, Long> {
}
