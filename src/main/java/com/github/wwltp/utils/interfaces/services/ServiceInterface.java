package com.github.wwltp.utils.interfaces.services;

import com.github.wwltp.utils.interfaces.entities.EntityInterface;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public interface ServiceInterface<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>,
        Repository extends CrudRepository<EntityType,IdType>> {

    Repository getRepository();

    EntityType update(EntityType entity);

    default void delete(EntityType user) {
        getRepository().delete(user);
    }

    default EntityType create(EntityType entity) {
        return getRepository().save(entity);
    }

}
