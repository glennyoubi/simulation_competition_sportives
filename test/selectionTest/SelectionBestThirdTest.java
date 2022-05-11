package selectionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Competiton.Competitor;
import Competiton.League;
import Selection.Selection;
import Selection.SelectionBestThird;

class SelectionBestThirdTest {
	
	
	private List<Competitor> competitors;
	private List<Competitor> competitorsTwo;
	private List<Competitor> competitorsThree;
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
		Competitor steeve = new Competitor("steeve");
		Competitor jeff = new Competitor("jeff");
		Competitor travis = new Competitor("travis");
		Competitor walker = new Competitor("walker");
		this.competitors = new ArrayList<Competitor>();
		this.competitorsTwo = new ArrayList<Competitor>();
		this.competitorsThree = new ArrayList<Competitor>();
		competitors.add(roger);
		competitorsTwo.add(marco);
		competitors.add(rafael);
		competitorsTwo.add(lonzo);
		competitors.add(serena);
		competitorsTwo.add(dulcy);
		competitors.add(maty);
		competitorsTwo.add(chiara);
		competitorsThree.add(jeff);
		competitorsThree.add(steeve);
		competitorsThree.add(travis);
		competitorsThree.add(walker);
		this.hens = new ArrayList<League>();
		League hensOne = new League(this.competitors);
		League hensTwo = new League(this.competitorsTwo);
		League hensThree = new League(this.competitorsThree);
		this.hens.add(hensOne);
		this.hens.add(hensTwo);
		this.hens.add(hensThree);
		this.selection = new SelectionBestThird();
	}
	

	@Test
	void selectionFinalistTest() {
		List<Competitor> check = this.selection.selectionFinalist(this.hens);
		assertEquals(8,check.size());
	}

}
