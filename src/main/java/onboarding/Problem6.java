package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        Map<String, Set<String>> continuousThings = new HashMap<String, Set<String>>();
        findContinuousStringInNickname(continuousThings, forms);
        return answer;
    }

    /**
     * Function for continuousString that contains all 2-length string in nickname of everyone
     * And Everyone is separated bt email
     * */
    private static void findContinuousStringInNickname(Map<String, Set<String>> continuousThings,
                                                   List<List<String>> forms) {
        for (List<String> info : forms) {
            String nickname = info.get(1);
            String email = info.get(0);

            for (int j = 0; j < nickname.length()-1; j++) {
                String nameForCheck = nickname.substring(j,j+2);

                if (!continuousThings.containsKey(nameForCheck)) {
                    continuousThings.put(nameForCheck, new HashSet<String>());
                }
                continuousThings.get(nameForCheck).add(email);
            }
        }
    }
}
