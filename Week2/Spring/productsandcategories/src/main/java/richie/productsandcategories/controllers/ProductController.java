package richie.productsandcategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import richie.productsandcategories.models.Category;
import richie.productsandcategories.models.Product;
import richie.productsandcategories.services.CategoryService;
import richie.productsandcategories.services.ProductService;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;

    //create product
    @GetMapping("/products/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "products/newProduct.jsp";
    }
    @PostMapping("/newproduct")
    public String createProduct(@ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/newProduct.jsp";
        }

        productService.createNewProduct(product);
        return "redirect:/";
    }

    //product page
	@GetMapping("/products/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		model.addAttribute("assignedCategories", categoryService.getAssignedCategories(product));
		model.addAttribute("unassignedCategories", categoryService.getUnassignedCategories(product));
		return "products/productEdit.jsp";
	}
	
    //product adding categories
	@PostMapping("/products/{id}/update")
	public String updateProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long categoryId, Model model) {
		Product product = productService.findById(id);
		Category category = categoryService.findById(categoryId);
		product.getCategories().add(category);
		productService.updateProduct(product);
		return "redirect:/products/"+id;
	}
}
