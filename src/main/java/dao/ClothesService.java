package dao;

import java.util.List;
import model.Clothes;
import repository.ClothesRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesService {
	@Autowired
	ClothesRepository clothesRepository;
	
	public List<Clothes> getClothes() {
		return List.of(
				new Clothes(1L, "T-shirt", "Shirts", "ABC Brand", 19.99, "Blue", "Medium", "Cotton", false, 10, null, null)
				);
//		"INSERT INTO public.clothes (name, category, brand, price, color, size, material, issold, quantity, created_at, updated_at) "
//		+ "VALUES ('T-shirt', 'Shirts', 'ABC Brand', 19.99, 'Blue', 'Medium', 'Cotton', false, 10, current_timestamp(), current_timestamp());";
//		 
	}
	public Iterable<Clothes> getAllClothes() {
		return clothesRepository.findAll(); 
	}
	
	public void addNewClothes(Clothes clothes) {
//		Optional<Clothes>
		
		clothesRepository.save(clothes);
	}
	
	public void deleteClothes(Long clothesId) {
		boolean exists = clothesRepository.existsById(clothesId);
		if(!exists) {
			throw new IllegalStateException("student with id" + clothesId + "doesn't exist");
		}
		
		clothesRepository.deleteById(clothesId);
	}
}
