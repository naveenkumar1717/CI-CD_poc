package com.Accenture.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Accenture.Entity.BikesEntity;
@Repository
public interface BikeDAO extends CrudRepository<BikesEntity,Integer> 
{

}
