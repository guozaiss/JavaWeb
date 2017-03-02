import com.example.model.Person;
import com.example.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * Created by Admin on 2017/2/17.
 */
public class TestA {
    private final static Logger logger = LoggerFactory.getLogger(TestA.class);
    @Resource
    private PersonService personService = null;

    @Before
    public void before() {
        personService = (PersonService) new ClassPathXmlApplicationContext("spring-mybatis.xml").getBean("personService");
    }

    @Test
    public void test1() {
        Person user = personService.getUserById("iiiddd");
        logger.info(user.getName());
    }
}
