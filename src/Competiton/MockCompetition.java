package Competiton;

import java.util.List;

public class MockCompetition extends Competition{
	
	private int test;
	
	public MockCompetition(List<Competitor> competitors){
		super(competitors);
		this.test = 0;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	@Override
	protected void play(List<Competitor> competitors) {
		this.test ++;
	}

}
