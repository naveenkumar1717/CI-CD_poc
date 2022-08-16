package com.Accenture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Accenture.Entity.BikesEntity;
import com.Accenture.Service.BikeService;

@RestController
public class BikeController {
	
	@Autowired
	BikeService bikeService;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
    public String index() {
    	return("Hello");
    }
	
	@RequestMapping("/myservice/hello")
	public String getdetails() {
		String url="http://localhost:8080/hello";
		RestTemplate rt=new RestTemplate();
		String result=rt.getForObject(url,String.class);
		return result;
	}
	
	@RequestMapping("/GetallBikes")
	public List<BikesEntity> getAllBikes() {
		return bikeService.getAllBikes();
	}
	@GetMapping("/getbike/{id}")
	public BikesEntity getBike(@PathVariable("id")int id) {
		return bikeService.getBikebyRegNo(id);
	}
	
	@PostMapping("/addbike")
	public int saveBike(@RequestBody BikesEntity bikesEntity) 
	{
		bikeService.save(bikesEntity);
		return bikesEntity.getId();	
	}
		
	}

