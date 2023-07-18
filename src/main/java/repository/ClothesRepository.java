package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Clothes;

public interface ClothesRepository extends JpaRepository <Clothes, Long>{
	
	@Query("SELECT s FROM Clothes s WHERE s.name =?1")
	Optional<Clothes> findClothesByName(String name); 
}
