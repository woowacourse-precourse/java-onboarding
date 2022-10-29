package onboarding.problemseven.domain;


import java.util.List;

public class Sns {


	public Sns(List<List<String>> friends) {
		for(List<String> friend:friends){
			User userA=new User(friend.get(0));
			User userB=new User(friend.get(1));

			userA.addFriend(friend.get(1));
			userB.addFriend(friend.get(0));
		}
	}
}
