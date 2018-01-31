package test_strutturali;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AbbonamentoTest.class, AssicurazioneTest.class, BagaglioTest.class, ExtraTest.class,
		PagamentoTest.class, PostoTest.class, PrenotazioneTest.class, RecensioneTest.class, SistemaTest.class,
		UtenteTest.class, VoloTest.class})
public class AllTests {

}
