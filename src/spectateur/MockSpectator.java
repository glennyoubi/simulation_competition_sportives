package spectateur;

import Competiton.Match;

public class MockSpectator implements Spectator{
	
	private int test;
	
	public MockSpectator(){
		this.test = 0;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	@Override
	public void update(Match match) {
		this.test++;
		
	}

}
