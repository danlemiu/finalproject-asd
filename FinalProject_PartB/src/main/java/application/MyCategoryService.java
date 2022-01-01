package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinalProject.Category;
import com.custom.aop.Qualifier;

@Service
public class MyCategoryService implements IMyCategoryService {
    @Autowired
    @Qualifier("myCategoryDAO2")
    IMyCategoryDAO myCategoryDAO;

    @Override
    public void addCategory(){
        Category category = new Category(111, "insurance");
        myCategoryDAO.save(category);
    }

}
