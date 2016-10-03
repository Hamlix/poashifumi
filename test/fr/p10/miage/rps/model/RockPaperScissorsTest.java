package fr.p10.miage.rps.model;

import static org.testng.Assert.*;

/**
 * Created by galax on 03/10/2016.
 */

public class RockPaperScissorsTest {

    RockPaperScissors rps;

    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
        rps = new RockPaperScissors();
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() throws Exception {
        rps = null;
    }

    @org.testng.annotations.Test
    public void testPlay() throws Exception {

    }

    @org.testng.annotations.DataProvider(name="WinData")
    public Object[][] createWinData(){
        return new Object[][]{
                {"PAPER","ROCK"},{"ROCK","SCISSORS"},{"SCISSORS","PAPER"}
        };
    }

    @org.testng.annotations.DataProvider(name="TieData")
    public Object[][] createTieData(){
        return new Object[][]{
                {"PAPER","PAPER"},{"ROCK","ROCK"},{"SCISSORS","SCISSORS"}
        };
    }

    @org.testng.annotations.DataProvider(name="LostData")
    public Object[][] createLostData(){
        return new Object[][]{
                {"ROCK","PAPER"},{"SCISSORS","ROCK"},{"PAPER","SCISSORS"}
        };
    }

    @org.testng.annotations.Test(dataProvider="WinData")
    public void testWinPlay(String p1, String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1),RPSEnum.valueOf(p2)), Result.WIN);
    }

    @org.testng.annotations.Test(dataProvider="TieData")
    public void testTiePlay(String p1, String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1),RPSEnum.valueOf(p2)), Result.TIE);
    }

    @org.testng.annotations.Test(dataProvider="LostData")
    public void testLostPlay(String p1, String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1),RPSEnum.valueOf(p2)), Result.LOST);
    }
}