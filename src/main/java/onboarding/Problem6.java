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
            List<String> appliedCrew = forms.get(i);
            for (int j=0; j<appliedCrew.get(1).length()-1; j++) {
                for (int k=i+1; k<forms.size(); k++) {
                    if(forms.get(k).get(1).contains(appliedCrew.get(1).substring(j, j+2))) {
                        needAnnounceCrew.add(appliedCrew.get(0));
                        needAnnounceCrew.add(forms.get(k).get(0));
                    }
                }
            }
        }
        return new ArrayList<>(needAnnounceCrew);
    }
}
