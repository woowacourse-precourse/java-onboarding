package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer=Collections.emptyList();

        return answer;
    }

    private static boolean isDuplicatedName(String userEmailWithDuplicatedName, String email){
        return (!userEmailWithDuplicatedName.isBlank()) && (!userEmailWithDuplicatedName.equals(email));
    }
}
