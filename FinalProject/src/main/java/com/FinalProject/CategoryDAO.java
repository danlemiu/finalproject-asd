package com.FinalProject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
public class CategoryDAO implements ICategoryDAO {
    private Map<Integer, Category> categories = new HashMap<Integer, Category>();

    public void save(Category category){
        categories.put(category.getId(), category);
        System.out.println("New category: " + category);
    }

    public Category find(int id){
        System.out.println("Use CategoryDAO");
        return categories.get(id);
    }

    public void remove(int id){
        categories.remove(id);
    }
}
