package de.starwit.databaseexample;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import de.starwit.databaseexample.entities.ClubEntity;

@Repository
public interface ClubRepository extends CrudRepository<ClubEntity, Long> {
    List<ClubEntity> findAll();
}
