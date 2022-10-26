package onboarding.problemone.domain;

import java.util.List;

public class Game {

	private User user1;
	private User user2;


	public Game(List<Integer> user1Pages, List<Integer> user2Pages){
		this.user1=new User(user1Pages);
		this.user2=new User(user2Pages);
	}

	public int play() {
		return 0;
	}
}
