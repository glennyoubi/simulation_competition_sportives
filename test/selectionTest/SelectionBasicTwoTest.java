package selectionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Competiton.Competitor;
import Competiton.League;
import Selection.Selection;
import Selection.SelectionBasicTwo;

class SelectionBasicTwoTest {
	
	
	private List<Competitor> competitors;
	private List<Competitor> competitorsTwo;
	private List<League> hens;
	private Selection selection;
	
	
	@BeforeEach
	void setUp() throws Exception {
		Competitor roger = new Competitor("Roger");
		Competitor marco = new Competitor("Marco");
		Competitor rafael = new Competitor("Rafael");
		Competitor lonzo = new Competitor("Lonzo");
		Competitor serena = new Competitor("Serena");
		Competitor dulcy = new Competitor("Dulcy");
		Competitor maty = new Competitor("Maty");
		Competitor chiara = new Competitor("Chiara");
		this.competitors = new ArrayList<Competitor>();
		this.competitorsTwo = new ArrayList<Competitor>();
		competitors.add(roger);
		competitorsTwo.add(marco);
		competitors.add(rafael);
		competitorsTwo.add(lonzo);
		competitors.add(serena);
		competitorsTwo.add(dulcy);
		competitors.add(maty);
		competitorsTwo.add(chiara);
		this.hens = new ArrayList<League>();
		League hensOne = new League(this.competitors);
		League hensTwo = new League(this.competitorsTwo);
		this.hens.add(hensOne);
		this.hens.add(hensTwo);
		this.selection = new SelectionBasicTwo();
		
	}

	@Test
	void selectionFinalistTest() {
		List<Competitor> check = this.selection.selectionFinalist(this.hens);
		assertEquals(4,check.size());
	}
	

}
