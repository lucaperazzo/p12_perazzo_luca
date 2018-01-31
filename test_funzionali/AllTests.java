package test_funzionali;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UC10ModificareDatiPersonali.class, UC11Deautenticarsi.class, UC17Pagamento.class, UC2RicercaVolo.class,
		UC3Autenticarsi.class, UC4PrenotareVolo.class, UC5ModificareUnaPrenotazione.class,
		UC6VisualizzareAbbonamenti.class, UC7ScegliereUnAbbonamento.class, UC8ScrivereUnaRecensione.class,
		UC9VisualizzareProfiloUtente.class })
public class AllTests {

}
