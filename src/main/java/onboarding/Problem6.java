package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> emails = new LinkedList<>();
        return emails;
    }
    // Function that returns a list of crew's emails if the crew's nickname contain same characters in series.
    private static List<String> getCrewsEmails(List<String> nowCrew, List<String> nextCrew) {
        List<String> crewsEmails = new LinkedList<>();
        for (int k = 0; k < nowCrew.get(1).length()-1; k++) {
            if(nextCrew.get(1).contains(nowCrew.get(1).substring(k,k+2))){
                crewsEmails.add(nowCrew.get(0));
                crewsEmails.add(nextCrew.get(0));
                break;
            }
        }
        return crewsEmails;
    }
}
