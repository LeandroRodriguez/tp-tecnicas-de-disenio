package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CajaTest.class, OfertaPorDiaTest.class,
	OfertaPorVolumenFactoryTest.class,
	OfertaPorUnidadFactoryTest.class,
	LectorProductosTest.class,
		OfertaPorUnidadTest.class, OfertaPorVolumenTest.class })
public class AllTests {

}
