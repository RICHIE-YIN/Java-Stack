package richie.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import richie.productsandcategories.models.Category;
import richie.productsandcategories.models.Product;
import richie.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> getAssignedProducts(Category category){
		return productRepository.findAllByCategories(category);
	}
	
	public List<Product> getUnassignedProducts(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}

    public void createNewProduct(Product product) {
        productRepository.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

}
