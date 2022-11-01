package onboarding.problem7;

import java.util.Set;

public class Crew {
	private String name;
	private long point;
	private Set<Crew> knownFriendsSet;


	public Crew(String name, long point, Set<Crew> knownFriendsSet){
		this.name = name;
		this.point = point;
		this.knownFriendsSet = knownFriendsSet;
	}

	public String getName(){
		return this.name;
	}

	public long getPoint(){
		return this.point;
	}

	public void addPoint(long point){
		this.point += point;
	}

	public void addKnownFriend(Crew friendCrew){
		this.knownFriendsSet.add(friendCrew);
	}

	public Set<Crew> getKnownFriendsSet(){
		return this.knownFriendsSet;
	}
}
