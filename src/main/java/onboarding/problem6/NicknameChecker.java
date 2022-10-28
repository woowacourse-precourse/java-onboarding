package onboarding.problem6;

import java.util.*;

public class NicknameChecker {

    private List<Crew> crews;
    private TreeSet<String> similarUserEmails;

    public NicknameChecker(){
        crews = new LinkedList<>();
        similarUserEmails = new TreeSet<>();
    }

    public NicknameChecker checkSimilarNickname(){
        List<Crew> checkedCrews = new ArrayList<>();
        for(Crew crew : crews){
            if(hasSimilarNickname(crew, checkedCrews)){
                similarUserEmails.add(crew.getEmail());
            }
            checkedCrews.add(crew);
        }
        return this;
    }

    public List<String> getSimilarNicknameCrewEmail(){
        return new LinkedList<>(similarUserEmails);
    }


    public void addCrew(List<String> crewInfo){
        crews.add(new Crew(crewInfo.get(0), crewInfo.get(1)));
    }

    public void addCrews(List<List<String>> crewsInfo){
        for(List<String> crewInfo : crewsInfo){
            addCrew(crewInfo);
        }
    }

    private boolean hasSimilarNickname(Crew crew, List<Crew> targetCrews) {
        for(Crew targetCrew : targetCrews){
            if(isSimilar(crew.getNickname(), targetCrew.getNickname())){
                return true;
            }
        }
        return false;
    }

    private boolean isSimilar(String nickname1, String nickname2){
        for(int index1 = 0; index1 < nickname1.length()-1; index1++){
            String pattern = nickname1.substring(index1, index1+2);
            if(nickname2.contains(pattern)){
                return true;
            }
        }
        return false;
    }
}
