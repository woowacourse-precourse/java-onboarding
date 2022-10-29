package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static Queue<List<String>> nicknameEmailQ;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        nicknameEmailQ = new LinkedList<>();
        for (List<String> form : forms) {
            nicknameEmailQ.offer(form);
        }
        int qLength = nicknameEmailQ.size();

        for (int i = 0; i < qLength; i++) {
            List<String> checkNicknameEmail = nicknameEmailQ.poll();
            String email = checkNicknameEmail.get(0);
            List<String> nicknameUnits = separateNickname(checkNicknameEmail.get(1));

            long count = nicknameEmailQ.stream()
                    .map(x -> x.get(1))
                    .filter(nickname -> isDuplicate(nickname, nicknameUnits))
                    .count();
            if (count > 0) {
                answer.add(email);
            }

            nicknameEmailQ.add(checkNicknameEmail);
        }
        Collections.sort(answer);
        answer.stream()
                .distinct()
                .collect(Collectors.toList());

        return answer;
    }

    public static List<String> separateNickname(String nickname) {
        List<String> returnList = new ArrayList<>();
        for (int i = 2; i < nickname.length()+1; i++) {
            for (int j = 0; j < nickname.length()+1 - i; j++) {
                returnList.add(nickname.substring(j, i+j));
            }
        }
        return returnList;
    }

    public static boolean isDuplicate(String nickname, List<String> nicknameUnits) {
        for (String nicknameUnit : nicknameUnits) {
            if (nickname.matches(".*" + nicknameUnit + ".*")) {
                return true;
            }
        }
        return false;

//        return ;
    }
}
