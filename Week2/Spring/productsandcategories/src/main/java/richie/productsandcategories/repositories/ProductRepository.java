package richie.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import richie.productsandcategories.models.Category;
import richie.productsandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

    List<Product> findByCategoriesNotContains(Category category);

    List<Product> findAllByCategories(Category category);
}
