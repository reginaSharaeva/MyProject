package ru.kpfu.itis.toyshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.toyshop.domain.Category;
import ru.kpfu.itis.toyshop.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regina on 14.03.2016.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Отображение всех категорий по категории родителя
     * @param parent
     * @return
     */
    public List<Category> getCategoryByParent(Long parent) {
        if (parent == 45L) {
            List<Category> categories = categoryRepository.getCategoryByParent(parent);
            List<Long> par_id = new ArrayList<>();
            for (int i = 0; i < categories.size(); i++) {
                if (categories.get(i).getId() != parent) {
                    par_id.add(categories.get(i).getId());
                }
            }
            return categoryRepository.getCategoryByParent(par_id);
        }
        return categoryRepository.getCategoryByParent(parent);
    }

    public List<Category> getCategoryForMenu(Long parent) {
        return categoryRepository.getCategoryByParent(parent);
    }
}
