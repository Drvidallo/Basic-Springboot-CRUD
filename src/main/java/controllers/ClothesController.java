package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import constants.Queries;
import dao.ClothesService;
import helper.Utilities;
import model.Clothes;



@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

	
	private final ClothesService clothesService;
	
	@Autowired
	public ClothesController(ClothesService clothesService) {
		this.clothesService = clothesService;
	}
	 
	@GetMapping("/get")
	public Iterable<Clothes> getClothes(){
		return clothesService.getAllClothes();
	}
	
	@PostMapping("/post")
	public void addClothes(@RequestBody Clothes clothes) {
		clothesService.addNewClothes(clothes);
	}
	
	@DeleteMapping(path="{clothesId}")
	public void deleteClothes(@PathVariable("clothesId") Long id) {
		clothesService.deleteClothes(id);
	}

}
 