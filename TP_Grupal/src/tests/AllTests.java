package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CajaTest.class, OfertaPorDiaTest.class,
		OfertaPorUnidadFactoryTest.class,
		OfertaPorUnidadTest.class, OfertaPorVolumenTest.class })
public class AllTests {

}
