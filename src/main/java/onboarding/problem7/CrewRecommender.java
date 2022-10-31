package onboarding.problem7;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CrewRecommender {

	public void relateFriendship(List<String> crewList, Map<String, Crew> crewMap){
		String firstFriendName = crewList.get(0);
		String secondFriendName = crewList.get(1);

		Crew firstCrew = crewMap.get(firstFriendName);
		Crew secondCrew = crewMap.get(secondFriendName);

		crewMap.get(firstFriendName).addKnownFriend(secondCrew);
		crewMap.get(secondFriendName).addKnownFriend(firstCrew);
	}


	public void addCrewToMap(List<String> crewList, Map<String, Crew> crewMap){
		for(String i : crewList){
			if(!crewMap.containsKey(i)){
				crewMap.put(i, new Crew(i,0, new HashSet<>()));
			}
		}
	}


	public boolean isRelatedCrewExist(Crew user, Crew unknownFriend){
		for(Crew ableToKnownFriend : unknownFriend.getKnownFriendsSet()){
			if(user.getKnownFriendsSet().contains(ableToKnownFriend)){
				return true;
			}
		}

		return false;
	}

}
