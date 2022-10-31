package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private static Map<String,String> duplicateNames =new HashMap<>(); //<이름, 이메일>
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();

        for (List<String> crew : forms) {
            String nickName = crew.get(1);
            if (nickName.length() < 2) {
                continue;
            }

            String email = crew.get(0);
            for (int i = 0; i < nickName.length() - 1; i++) {
                String partialName = nickName.substring(i, i+2);
                String userEmailWithDuplicatedName = duplicateNames.getOrDefault(partialName,"");

                if(isDuplicatedName(userEmailWithDuplicatedName,email)){
                    answer.add(email);
                    answer.add(userEmailWithDuplicatedName);
                }

                duplicateNames.put(partialName, email);
            }
        }

        return new ArrayList<>(answer).stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean isDuplicatedName(String userEmailWithDuplicatedName, String email){
        return (!userEmailWithDuplicatedName.isBlank()) && (!userEmailWithDuplicatedName.equals(email));
    }
}
