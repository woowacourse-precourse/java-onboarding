package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        // 1. HashSet to store email information
        HashSet<String> answer = new HashSet<>();

        // 2. Check all crew's nickname
        for (List<String> crew : forms) {
            String currCrewNickname = crew.get(1);

            for (int i = 0; i < currCrewNickname.length() - 2; i++) {

                String duplicateToCheck = currCrewNickname.substring(i, i + 2);     // parse the nickname into two letters

                for (List<String> anotherCrew : forms) {    // Compare with other crews

                    if (currCrewNickname.equals(anotherCrew.get(1))) {  // Skip the underlying logic if two crews are same
                        continue;
                    }

                    String anotherNickname = anotherCrew.get(1);
                    if (anotherNickname.contains(duplicateToCheck)) {   // If the nickname overlaps, add it to hashset
                        answer.add(anotherCrew.get(0));
                    }
                }
            }
        }

        return answer.stream().sorted().collect(Collectors.toList());   // return answer
    }
}
