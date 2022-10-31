package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static Queue<List<String>> nicknameEmailQ;
    private static final int MIN_NICKNAME_LENGTH = 1;
    private static final int MAX_NICKNAME_LENGTH =  20;
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH =  20;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        nicknameEmailQ = new LinkedList<>();
        initValidData(forms);

        collectDuplicateUsersEmail(answer);

        Collections.sort(answer);

        return getTop5RecommendList(answer);
    }

    private static void collectDuplicateUsersEmail(List<String> answer) {
        int qLength = nicknameEmailQ.size();

        for (int i = 0; i < qLength; i++) {
            List<String> checkNicknameEmail = nicknameEmailQ.poll();
            String email = checkNicknameEmail.get(0);
            List<String> nicknameUnits = separateNickname(checkNicknameEmail.get(1));

            if (isExistDuplicateNickname(nicknameUnits)) {
                answer.add(email);
            }

            nicknameEmailQ.add(checkNicknameEmail);
        }
    }

    private static List<String> getTop5RecommendList(List<String> answer) {
        return answer.stream()
                .distinct()
                .collect(Collectors.toList());
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
    }
    public static boolean isValidateEmail (String email){
        return email.length() >= MIN_EMAIL_LENGTH && email.length() < MAX_EMAIL_LENGTH && email.endsWith("email.com");
    }

    public static boolean isExistDuplicateNickname(List<String> nicknameUnits){
        return nicknameEmailQ.stream()
                .map(x -> x.get(1)).anyMatch(nickname -> isDuplicate(nickname, nicknameUnits));
    }

    public static boolean isValidNickname(String nickname) {
        String nicknameRegex = "^[ㄱ-ㅎ가-힣ㅏ-ㅣ]*";
        return nickname.length() >= MIN_NICKNAME_LENGTH && nickname.length() < MAX_NICKNAME_LENGTH
                && nickname.matches(nicknameRegex);
    }

}
