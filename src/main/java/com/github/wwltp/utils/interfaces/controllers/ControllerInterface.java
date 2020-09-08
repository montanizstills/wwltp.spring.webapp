package com.github.wwltp.utils.interfaces.controllers;

import com.github.wwltp.utils.interfaces.entities.EntityInterface;
import com.github.wwltp.utils.interfaces.services.ServiceInterface;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import java.io.Serializable;

@Controller
public interface ControllerInterface
        <IdType extends Serializable,
        EntityType extends EntityInterface<IdType>,
        Repository extends CrudRepository<EntityType,IdType>,
        Service extends ServiceInterface<IdType, EntityType, Repository>> {

    Service getService();

//    @PutMapping ResponseEntity put()
//    @PostMapping ResponseEntity post();
//    @GetMapping ResponseEntity get();
//    @DeleteMapping ResponseEntity delete();


}
