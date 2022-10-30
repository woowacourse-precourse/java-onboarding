package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        Map<String, List<String>> continuousThings = new HashMap<String, List<String>>();
        Set<String> overlappingEmailList = new HashSet<>();

        findEmailListUsingOverlappedSubString(continuousThings, forms, overlappingEmailList);

        sortList(answer, overlappingEmailList);

        return answer;
    }

    /**
     * Function for emailList that contains overlapped all 2-length string in nickname
     * */
    private static void findEmailListUsingOverlappedSubString(Map<String, List<String>> continuousThings,
                                                       List<List<String>> forms, Set<String> overlappingEmailList) {
        for (List<String> info : forms) {
            String nickname = info.get(1);
            String email = info.get(0);

            for (int j = 0; j < nickname.length()-1; j++) {
                String nameForCheck = nickname.substring(j,j+2);

                if (!continuousThings.containsKey(nameForCheck)) {
                    continuousThings.put(nameForCheck, new ArrayList<>());
                    continuousThings.get(nameForCheck).add(email);
                } else {
                    if (!continuousThings.get(nameForCheck).contains(email)) {
                        overlappingEmailList.add(email);
                        overlappingEmailList.add(continuousThings.get(nameForCheck).get(0));
                    }
                }
            }
        }
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
