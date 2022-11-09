package com.learn.learning.models.repositories;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.learn.learning.models.entities.Human;

public interface HumanRepository extends CrudRepository<Human, Long>{
    @Query("SELECT h FROM Human h WHERE h.name = :name")
    public Human findHumanByName(@PathParam("name") String name);

    @Query("SELECT h FROM Human h WHERE h.name LIKE :name")
    public List<Human> findHumanByNameLike(@PathParam("name") String name);

    @Query("SELECT h FROM Human h WHERE h.status.id = :statusId")
    public List<Human> findHumanByStatusId(@PathParam("statusId") Long statusId);
}
