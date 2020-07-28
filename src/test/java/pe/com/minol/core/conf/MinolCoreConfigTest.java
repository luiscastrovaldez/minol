package pe.com.minol.core.conf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MinolCoreConfig.class })
public class MinolCoreConfigTest {

	@Test
	public void testCustomerCoreConfig() {
		MinolCoreConfig minolCoreConfig = new MinolCoreConfig();
		Assert.isTrue(minolCoreConfig != null, "Objeto nulo");
	}
}
