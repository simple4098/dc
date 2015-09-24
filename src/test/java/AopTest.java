import com.fanqie.dc.aop.AopTestCom;
import com.fanqie.dc.service.IInnActiveService;
import com.fanqie.dc.service.IOrderSourceService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
@ActiveProfiles("dev")
public class AopTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private AopTestCom aaa;
    @Autowired
    private IOrderSourceService service;
    @Autowired
    private IInnActiveService service2;
	@Test
    @Ignore
	public void test(){
        aaa.test();
    }

    @Test
    @Ignore
    public void test2(){
        service.findOrderSource("", "");
    }

    @Test
    @Ignore
    public void test3(){
        service2.findDayInnActive("","");
    }

}
