package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getCrew(forms);
        return answer;
    }

    private static List<String> getCrew(List<List<String>> forms) {
        Set<String> needAnnounceCrew = new TreeSet<>();

        for (int i=0; i<forms.size(); i++) {
            String appliedCrewEmail = forms.get(i).get(0);
            String appliedCrewNickName = forms.get(i).get(1);
            for (int j=0; j<appliedCrewNickName.length()-1; j++) {
                for (int k=i+1; k<forms.size(); k++) {
                    String appliedNextCrewEmail = forms.get(k).get(0);
                    String appliedNextCrewNickName = forms.get(k).get(1);
                    if(appliedNextCrewNickName.contains(appliedCrewNickName.substring(j, j+2))) {
                        needAnnounceCrew.add(appliedCrewEmail);
                        needAnnounceCrew.add(appliedNextCrewEmail);
                    }
                }
            }
        }
        return new ArrayList<>(needAnnounceCrew);
    }
}
