package onboarding.problem6;

import java.util.*;

public class NicknameChecker {

    private static final String ALLOWED_EMAIL_DOMAIN = "@email.com$";
    private static final String ALLOWED_EMAIL_FORMAT = ".+"+ALLOWED_EMAIL_DOMAIN;

    private List<Crew> crews;
    private TreeSet<String> similarUserEmails;

    public NicknameChecker(){
        crews = new LinkedList<>();
        similarUserEmails = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String email1 = o1.split(ALLOWED_EMAIL_DOMAIN)[0];
                String email2 = o2.split(ALLOWED_EMAIL_DOMAIN)[0];
                return email1.compareTo(email2);
            }
        });
    }

    public NicknameChecker checkSimilarNickname(){
        List<Crew> checkedCrews = new ArrayList<>();
        for(Crew crew : crews){
            addSimilarNicknameFromList(crew, checkedCrews);
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
        if(email.matches(ALLOWED_EMAIL_FORMAT)) {
            crews.add(new Crew(email, nickName));
        }
    }

    public void addCrews(List<List<String>> crewsInfo){
        for(List<String> crewInfo : crewsInfo){
            addCrew(crewInfo);
        }
    }

    private void addSimilarNicknameFromList(Crew crew, List<Crew> targetCrewList) {
        for(Crew targetCrew : targetCrewList){
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
