package com.github.wwltp.utils.interfaces.entities;

import java.io.Serializable;

public interface EntityInterface<IdType extends Serializable> {

    IdType getId();
    void setId(IdType id);
}
