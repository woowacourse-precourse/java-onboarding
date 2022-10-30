package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        Map<String, Set<String>> continuousThings = new HashMap<String, Set<String>>();
        findContinuousStringInNickname(continuousThings, forms);

        Set<String> overlappingEmailList = checkingWordUsingMoreThanTwoTimes(continuousThings);
        sortList(answer, overlappingEmailList);

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

    /**
     * Function for finding all email that contains overlapped 2-length string in name
     * */
    private static Set<String> checkingWordUsingMoreThanTwoTimes(Map<String, Set<String>> continuousThings) {

        Set<String> overlappingEmailList = new HashSet<>();
        for (String name : continuousThings.keySet()) {
            if (continuousThings.get(name).size() >= 2) {
                for (String email : continuousThings.get(name)) {
                    overlappingEmailList.add(email);
                }
            }
        }
        return overlappingEmailList;
    }

    /**
     * Function for sorted email
     * */
    private static void sortList(List<String> answer, Set<String> overlappingEmailList) {
        for (String email : overlappingEmailList) {
            answer.add(email);
        }
        Collections.sort(answer);
    }
}
