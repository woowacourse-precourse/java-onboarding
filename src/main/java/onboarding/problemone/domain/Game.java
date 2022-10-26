package onboarding.problemone.domain;

import java.util.List;

public class Game {

	private User user1;
	private User user2;


	public Game(List<Integer> user1Pages, List<Integer> user2Pages){
		this.user1=new User(user1Pages);
		this.user2=new User(user2Pages);
	}

	public int play(){
		if (!validatePage(user1) || !validatePage(user2)){
			return -1;
		}

		user1.calculateScore();
		user2.calculateScore();

		return 0;
	}

	private boolean validatePage(User user){
		if (user.getLeftPage()<1 || user.getLeftPage()>400){
			return false;
		} else if (user.getLeftPage()%2==0 || user.getRightPage()%2==1) {
			return false;
		} else if (user.getLeftPage()+1!=user.getRightPage()) {
			return false;
		}
		return true;
	}


}
