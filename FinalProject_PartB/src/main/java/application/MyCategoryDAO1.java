package application;

import com.FinalProject.Category;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MyCategoryDAO1 implements IMyCategoryDAO {
    private Map<Integer, Category> categories = new HashMap<Integer, Category>();
    public Category find(int id){
        System.out.println("Use MyCategoryDAO1");
        return categories.get(id);
    }
    public void save(Category category){
        categories.put(category.getId(), category);
        System.out.println("New category: " + category);
    }
}