import com.example.model.Person;
import com.example.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * Created by Admin on 2017/2/17.
 */
public class TestA {
    private static Logger logger = Logger.getLogger(TestA.class.toString());
    @Resource
    private PersonService userService = null;

    @Before
    public void before() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        userService = (PersonService) ac.getBean("personService");
    }

    @Test
    public void test1() {
        Person user = userService.getUserById("id_01");
    }
}
