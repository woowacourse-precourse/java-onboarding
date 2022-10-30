package onboarding.problem6;

import java.util.*;

public class NicknameChecker {

    private static final String ALLOWABLE_EMAIL_FORMAT = ".+@email.com$";

    private List<Crew> crews;
    private TreeSet<String> similarUserEmails;

    public NicknameChecker(){
        crews = new LinkedList<>();
        similarUserEmails = new TreeSet<>();
    }

    public NicknameChecker checkSimilarNickname(){
        List<Crew> checkedCrews = new ArrayList<>();
        for(Crew crew : crews){
            addSimilarNicknameCrews(crew, checkedCrews);
            checkedCrews.add(crew);
        }
        return this;
    }

    public List<String> getSimilarNicknameCrewEmail(){
        return new LinkedList<>(similarUserEmails);
    }


    public void addCrew(List<String> crewInfo){
        String email = crewInfo.get(0);
        String nickName = crewInfo.get(1);
        if(email.matches(ALLOWABLE_EMAIL_FORMAT)) {
            crews.add(new Crew(email, nickName));
        }
    }

    public void addCrews(List<List<String>> crewsInfo){
        for(List<String> crewInfo : crewsInfo){
            addCrew(crewInfo);
        }
    }

    private void addSimilarNicknameCrews(Crew crew, List<Crew> targetCrews) {
        for(Crew targetCrew : targetCrews){
            if(isSimilar(crew.getNickname(), targetCrew.getNickname())){
                similarUserEmails.add(crew.getEmail());
                similarUserEmails.add(targetCrew.getEmail());
            }
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
