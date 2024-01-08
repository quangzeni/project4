package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.Category;
import ra.repository.CategoryRepository;
import ra.service.CategoryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    @Transactional
    public boolean save(Category category) {
        Category categoryNew = categoryRepository.save(category);
        return categoryNew != null ? true : false;
    }

    @Override
    @Transactional
    public boolean update(Category categoryUpdate) {
        boolean result = false;
        try {
            Category existingCategory  = categoryRepository.findById(categoryUpdate.getId()).orElse(null);
            if (existingCategory != null){
                existingCategory.setCategoryName(categoryUpdate.getCategoryName());
                existingCategory.setDescription(categoryUpdate.getDescription());
                existingCategory.setStatus(categoryUpdate.isStatus());
                categoryRepository.save(existingCategory);
                result = true;
            }else {
                result = false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public boolean delete(Long categoryId) {
        boolean result = false;
        try {
            categoryRepository.deleteById(categoryId);
            result = true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Category> searchByName(String categoryName) {
        return categoryRepository.findByCategoryNameContainingIgnoreCase(categoryName);
    }

    @Override
    public List<Category> sortByName(String sortValue) {
        Sort sort = "asc".equals(sortValue) ? Sort.by(Sort.Order.asc("categoryName")) : Sort.by(Sort.Order.desc("categoryName"));
        return categoryRepository.findAll(sort);
    }
}

