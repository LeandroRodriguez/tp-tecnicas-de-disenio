package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CajaTest.class, CuponTest.class, LectorProductosTest.class,
		OfertaJubiladosTest.class, OfertaPorDiaTest.class,
		OfertaPorUnidadFactoryTest.class, OfertaPorUnidadTest.class,
		OfertaPorVentaTotalFactoryTest.class, OfertaPorVentaTotalTest.class,
		OfertaPorVolumenFactoryTest.class, OfertaPorVolumenTest.class })
public class AllTests {

}
