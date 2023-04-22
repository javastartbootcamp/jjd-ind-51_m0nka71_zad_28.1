package pl.javastart.restoffers.category;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/categories")
@RestController
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/names")
    public List<String> categoriesNames() {
        return categoryService.findByName();
    }

    @PostMapping("")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
