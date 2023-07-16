package application;

import com.FinalProject.Category;
import com.FinalProject.ICategoryDAO;
import com.FinalProject.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyCategoryService implements IMyCategoryService {
    @Autowired
    @Qualifier("myCategoryDAO")
    IMyCategoryDAO myCategoryDAO;

    @Override
    public void addCategory(){
        Category category = new Category(111, "insurance");
        myCategoryDAO.save(category);
    }

}
