import com.example.Student;
import com.example.service.PersonService;
import com.example.utils.FactoryUtils;
import com.example.utils.LogUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by Admin on 2017/2/17.
 */
public class TestA {
    @Resource
    private PersonService personService = null;

    @Autowired
    Student student;

    @Before
    public void before() {
        personService = FactoryUtils.getInstance().getBean("personService", PersonService.class);
    }

    @Test
    public void test1() {
//        Person user = personService.getUserById("iiiddd");
//        logger.info(user.getName());
        Student stu = FactoryUtils.getInstance().getBean("student", Student.class);
        Student stu2 = FactoryUtils.getInstance().getBean("student", Student.class);
        LogUtils.log((stu == stu2) + "");
    }
}