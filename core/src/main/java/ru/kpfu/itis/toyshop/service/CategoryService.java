package ru.kpfu.itis.toyshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.toyshop.domain.Category;
import ru.kpfu.itis.toyshop.repository.CategoryRepository;

import java.util.List;

/**
 * Created by Регина on 14.03.2016.
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
        return categoryRepository.getCategoryByParent(parent);
    }

    /**
     * Отображение всех дочерних категорий
     * @return
     */
    public List<Category> getCategoryByParent() {
        return categoryRepository.getCategoryByParent();
    }

}
