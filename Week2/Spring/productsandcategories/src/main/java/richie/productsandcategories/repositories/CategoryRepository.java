package richie.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import richie.productsandcategories.models.Category;
import richie.productsandcategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    List<Category> findByProductsNotContains(Product product);

    List<Category> findAllByProducts(Product product);
}
