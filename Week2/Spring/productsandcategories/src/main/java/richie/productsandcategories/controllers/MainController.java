package richie.productsandcategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import richie.productsandcategories.models.Category;
import richie.productsandcategories.models.Product;
import richie.productsandcategories.repositories.CategoryRepository;
import richie.productsandcategories.repositories.ProductRepository;

@Controller
public class MainController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository cateogryRepository;
    
    @GetMapping ("/")
    public String getAll(Model model) {
        List<Product> products = productRepository.findAll();
        List<Category> categories = cateogryRepository.findAll();

        model.addAttribute("products", products);
        model.addAttribute("categories", categories);

        return "index.jsp";
    }
}
