/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahathoor
 */
public class StatisticsTest {
    
 
    Statistics stats;
    Reader readerStub = new Reader() {
 
        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
    
    public StatisticsTest() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void testSearch() {
        System.out.println("search");
        Player result = stats.search("Semenko");
        assertEquals(4, result.getGoals());
    }

    @Test
    public void testSearchEiLöydy() {
        System.out.println("search");
        Player result = stats.search("Ekke");
        assertEquals(null, result);
    }
    @Test
    public void testTeam() {
        System.out.println("team");
        List<Player> result = stats.team("EDM");
        assertEquals("Semenko", result.get(0).getName());
        assertEquals("Kurri", result.get(1).getName());
        assertEquals("Gretzky", result.get(2).getName());
    }

    @Test
    public void testTopScorers() {
        System.out.println("topScorers");
        System.out.println("team");
        List<Player> result = stats.topScorers(3);
        assertEquals("Gretzky", result.get(0).getName());
        assertEquals("Lemieux", result.get(1).getName());
        assertEquals("Yzerman", result.get(2).getName());
    }
}