package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.model.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine, Integer>{
	@Query("Select m from Medicine m where m.mName LIKE %?1%"+"OR m.category LIKE %?1%")
	public List<Medicine> searchByNameOrCategory(String keyword);
	
	@Query("Select m from Medicine m where m.mName LIKE %?1% and m.status='Enabled'")
	public List<Medicine> searchByNameOrCategoryuser(String keyword);
	
	@Query("Select m from Medicine m where m.category=?1")
	public List<Medicine> filterByCat(String keyword);
	
	@Query("Select m from Medicine m where m.category=?1 and m.status='Enabled'")
	public List<Medicine> filterByCatuser(String keyword);
	
	@Query("Select m from Medicine m where m.status='Enabled'")
	public List<Medicine> showToUser();
	
	@Query("Select m from Medicine m where m.status='Enabled' ORDER BY m.mPrice ASC")
	public List<Medicine> sortASC();
	
	@Query("Select m from Medicine m where m.status='Enabled' ORDER BY m.mPrice DESC")
	public List<Medicine> sortDESC();
}
