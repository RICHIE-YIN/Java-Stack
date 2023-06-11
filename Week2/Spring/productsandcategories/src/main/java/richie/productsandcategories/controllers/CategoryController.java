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
public class CategoryController {
        
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    //create category
    @GetMapping("/categories/new")
    public String newCategory(Model model) {
        model.addAttribute("category", new Category());
        return "categories/newCategory.jsp";
    }
    @PostMapping("/newcategory")
    public String createCategory(@ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categories/newCategory.jsp";
        }

        categoryService.createNewCategory(category);;
        return "redirect:/";
    }

    //categories page
	@GetMapping("/categories/{id}")
	public String viewCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);
		model.addAttribute("assignedProducts", productService.getAssignedProducts(category));
		model.addAttribute("unassignedProducts", productService.getUnassignedProducts(category));
		return "categories/categoryEdit.jsp";
	}
	
    //category + products
	@PostMapping("/categories/{id}/updates")
	public String updateCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId, Model model) {
		Category category = categoryService.findById(id);
		Product product = productService.findById(productId);
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		return "redirect:/categories/"+id;
	}
}
