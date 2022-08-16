package com.Accenture.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Accenture.Dao.BikeDAO;
import com.Accenture.Entity.BikesEntity;

@Service
public class BikeService {

	@Autowired
	BikeDAO bikeDao;
	
	public List<BikesEntity> getAllBikes(){
		List<BikesEntity> bikeslist=new ArrayList<BikesEntity>();
		bikeDao.findAll().forEach(Bikedata -> bikeslist.add(Bikedata));
		return bikeslist;
	}
	public BikesEntity getBikebyRegNo(int id) {
		return bikeDao.findById(id).get();
		
	}
	public void save(BikesEntity bikesEntity) {
		bikeDao.save(bikesEntity);
		
	}
}
