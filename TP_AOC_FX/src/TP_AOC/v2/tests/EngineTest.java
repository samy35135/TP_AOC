package TP_AOC.v2.tests;


import TP_AOC.v2.main.Controller.Controller;
import TP_AOC.v2.main.Engine.Command.MarquerMesure;
import TP_AOC.v2.main.Engine.Command.MarquerTemps;
import TP_AOC.v2.main.Engine.Command.UpdateTemps;
import TP_AOC.v2.main.Engine.Engine;
import TP_AOC.v2.main.Engine.Horloge.Horloge_Tempo;
import TP_AOC.v2.main.Engine.SignalMoteur;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EngineTest {


    @Spy
    Engine engine;
    @Spy
    Controller controller;

    @BeforeMethod
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        controller = Mockito.spy(new Controller());
        engine = Mockito.spy(new Engine());
        controller.setMoteur(engine);
    }
    @Test
    public void testGetTempo() throws Exception {
        Assert.assertEquals(engine.getTempo(), 60);
    }

    @Test
    public void testSetTempo() throws Exception {

        Assert.assertEquals(engine.getTempo(), 60);

        try {
            engine.setTempo(20);
            Assert.fail( "Exception non retournée" );
        } catch (Exception expectedException) {

        }
        // On fait un mock ici pour empecher tout appel à updt.execute()
        UpdateTemps updt =  Mockito.spy(new UpdateTemps(controller));
        Mockito.doNothing().when(updt).execute();
        engine.addCommand(SignalMoteur.UpdateTemps, updt);
        Mockito.doNothing().when(engine).marquerTempo();

        engine.setEtatMarche(true);
        engine.setTempo(40);
        Assert.assertEquals(engine.getTempo(),40);
        engine.setTempo(30);
        Assert.assertEquals(engine.getTempo(),30);
        engine.setTempo(10);
        Assert.assertNotEquals(engine.getTempo(),10);
    }

    @Test
    public void testGetNbTempsMesures() throws Exception {
        Assert.assertEquals(engine.getNbTempsMesures(),2);
    }

    @Test
    public void testSetNbTempsMesures() throws Exception {
        engine.setNbTempsMesures(3);
        Assert.assertEquals(engine.getNbTempsMesures(),3);

        // test valeur < min
        engine.setNbTempsMesures(1);
        Assert.assertEquals(engine.getNbTempsMesures(),3);
        // test valeur == min
        engine.setNbTempsMesures(2);
        Assert.assertEquals(engine.getNbTempsMesures(),2);
        // test valeur > max
        engine.setNbTempsMesures(8);
        Assert.assertEquals(engine.getNbTempsMesures(),2);
        // test valeur == max
        engine.setNbTempsMesures(7);
        Assert.assertEquals(engine.getNbTempsMesures(),7);
    }

    @Test
    public void testMarquerTempo() throws Exception {

        // test appel à MarquerTemps
        MarquerTemps mt =  Mockito.spy(new MarquerTemps(controller));
        Mockito.doNothing().when(controller).marquerTemps();
        engine.addCommand(SignalMoteur.MarquerTemps, mt);
        engine.marquerTempo();
        Mockito.verify(mt).execute();

        // test appl a MarquerMesure
        MarquerMesure mm =  Mockito.spy(new MarquerMesure(controller));
        Mockito.doNothing().when(controller).updateMesure();
        engine.addCommand(SignalMoteur.MarquerMesure, mm);
        engine.marquerTempo();
        Mockito.verify(mm).execute();

    }

    @Test
    public void testAddCommand() throws Exception {

        Assert.assertEquals( engine.getMap_commandes().size(), 0);
        MarquerMesure mm =  new MarquerMesure(controller);

        engine.addCommand(SignalMoteur.MarquerMesure, mm);
        Assert.assertEquals( engine.getMap_commandes().size(), 1);

        Assert.assertEquals( engine.getMap_commandes().get(SignalMoteur.MarquerMesure), mm);

        engine.addCommand(SignalMoteur.MarquerMesure, mm);
        Assert.assertEquals( engine.getMap_commandes().size(), 1);
    }

    @Test
    public void testSetEtatMarche() throws Exception {


        // test à l'initialisation
        Assert.assertEquals( engine.getEtatMarche(), false);
        UpdateTemps updt =  Mockito.spy(new UpdateTemps(controller));
        Mockito.doNothing().when(updt).execute();
        engine.addCommand(SignalMoteur.UpdateTemps, updt);
        Mockito.doNothing().when(engine).marquerTempo();
        Assert.assertEquals( engine.getHorloge_marquer_tempo(), null);


        // démarrage
        Horloge_Tempo horloge_marquer_tempo = Mockito.spy(new Horloge_Tempo(engine, 60/engine.getTempo()));
        Mockito.doNothing().when(horloge_marquer_tempo).demarrer();
        engine.setHorloge_marquer_tempo(horloge_marquer_tempo);
        engine.setEtatMarche(true);
        Mockito.verify(horloge_marquer_tempo).demarrer();

        Assert.assertNotEquals( engine.getHorloge_marquer_tempo(), null);
        Assert.assertEquals( engine.getHorloge_marquer_tempo(), horloge_marquer_tempo);

        // arrêt
        Mockito.doNothing().when(horloge_marquer_tempo).stop();
        engine.setEtatMarche(false);
        Assert.assertEquals( engine.getHorloge_marquer_tempo(), horloge_marquer_tempo);
        Mockito.verify(horloge_marquer_tempo).stop();


        // redémarrage
        horloge_marquer_tempo = Mockito.spy(new Horloge_Tempo(engine, 60/engine.getTempo()));
        Mockito.doNothing().when(horloge_marquer_tempo).demarrer();
        engine.setHorloge_marquer_tempo(horloge_marquer_tempo);
        engine.setEtatMarche(true);
        Mockito.verify(horloge_marquer_tempo).demarrer();

    }

}