package richie.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.productsandcategories.models.Category;
import richie.productsandcategories.models.Product;
import richie.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService (CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public List<Category> getAssignedCategories(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	
	public List<Category> getUnassignedCategories(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}

    public void createNewCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category findById (Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }
}
