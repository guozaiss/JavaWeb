import com.example.model.Person;
import com.example.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Admin on 2017/2/17.
 */
public class TestA {
    private  Logger logger;
    @Resource
    private PersonService personService = null;

    @Before
    public void before() {
        logger = Logger.getLogger(TestA.class.toString());
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        personService = (PersonService) ac.getBean("personService");
    }

    @Test
    public void test1() {
        Person user = personService.getUserById("iiiddd");
        logger.log(Level.ALL,user.getName());
    }
}
