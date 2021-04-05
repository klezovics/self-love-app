package com.klezovich.iloveme.repository;

import com.klezovich.iloveme.entity.Quality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QualityRepository extends CrudRepository<Quality,Long> {
    Optional<List<Quality>> findAllByUser(String user);
}
