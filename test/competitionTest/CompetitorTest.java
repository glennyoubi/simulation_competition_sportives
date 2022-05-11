package competitionTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Competiton.*;



public class CompetitorTest{

@Test
public void competitorsTest(){

Competitor c1 = new Competitor("Wydad Casablanca");
assertEquals(0,c1.getPoints());
c1.addPoints();
assertEquals(1,c1.getPoints());

}





}
