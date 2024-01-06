package ra.service;

import ra.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long categoryId);

    boolean save(Category category);

    boolean update(Category category);

    boolean delete(Long categoryId);
}
