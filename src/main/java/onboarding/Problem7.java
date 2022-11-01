package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import onboarding.problem7.Crew;
import onboarding.problem7.CrewRecommender;
import onboarding.problem7.RecommendPoint;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Crew> crewMap = new HashMap<>();
        CrewRecommender crewRecommender = new CrewRecommender();

        crewRecommender.addCrewToMap(List.of(user), crewMap);
        crewRecommender.addCrewToMap(visitors, crewMap);

        for(List<String> i : friends){
            crewRecommender.addCrewToMap(i, crewMap);
            crewRecommender.relateFriendship(i, crewMap);
        }


        Crew userCrew = crewMap.get(user);

        for(Crew unknownCrew : crewMap.values()){
            if(crewRecommender.isRelatedCrewExist(userCrew, unknownCrew)){
                unknownCrew.addPoint(RecommendPoint.FRIEND.getPoint());
            }
        }


        for(String i : visitors){
            Crew visitorCrew = crewMap.get(i);
            visitorCrew.addPoint(RecommendPoint.VISITOR.getPoint());
        }


        return new ArrayList<>(crewMap.values())
            .stream()
            .filter(crews -> crews.getPoint() != 0)
            .sorted(Comparator.comparing(Crew::getPoint).reversed()
                .thenComparing(Crew::getName))
            .map(Crew::getName)
            .filter(name -> !name.equals(user))
            .filter(name -> !userCrew.getKnownFriendsSet().contains(crewMap.get(name)))
            .limit(5)
            .collect(Collectors.toList());
    }
}
