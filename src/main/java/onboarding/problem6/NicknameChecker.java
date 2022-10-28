package onboarding.problem6;

import java.util.LinkedList;
import java.util.List;

public class NicknameChecker {

    private List<Crew> crews;

    public NicknameChecker(){
        crews = new LinkedList<>();
    }

    public void addCrew(List<String> crewInfo){
        crews.add(new Crew(crewInfo.get(0), crewInfo.get(1)));
    }

    public void addCrews(List<List<String>> crewsInfo){
        for(List<String> crewInfo : crewsInfo){
            addCrew(crewInfo);
        }
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
