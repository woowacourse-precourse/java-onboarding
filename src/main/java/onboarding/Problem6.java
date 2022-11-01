package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // forms 인자에 제공된 이메일과 닉네임
        for (List<String> emailAndNickname : forms) {
            String targetName = emailAndNickname.get(1);

            // 일치하는지 확인해야하는 닉네임을 두글자씩 잘라 리스트에 넣는다.
            ArrayList<String> cutNameList = cutNickname(targetName);

            // 두글자씩 잘린 닉네임이 다른 닉네임과 일치하는지 확인한다.
            for (String cutName : cutNameList) {
                Boolean matchResult = isThereMatch(forms, cutName, targetName);

                // 일치하는 경우, 이미 기록된 이메일이 없다면 이메일을 기록한다.
                if (matchResult) {
                    String email = emailAndNickname.get(0);
                    if(!answer.contains(email)){
                        answer.add(emailAndNickname.get(0));
                    }
                    break;
                }
            }
        }

        // 결과를 오름차순으로 정렬
        Collections.sort(answer);
        return answer;
    }

    /**
     * 두글자씩 잘린 닉네임이 다른 닉네임과 일치하는지 확인한다.
     * @param forms 제공된 이메일과 닉네임
     * @param cutName 두글자씩 잘린 닉네임
     * @param targetName 일치하는지 확인해야하는 닉네임
     * @return 참 거짓
     */
    private static Boolean isThereMatch(List<List<String>> forms, String cutName, String targetName) {
        String regex = "(.*)"+cutName+"(.*)";

        // 이메일과 닉네임에서 닉네임을 가져온다.
        for (List<String> emailAndNickname : forms) {
            String nickname = emailAndNickname.get(1);

            // 일치하는지 확인해야하는 닉네임이 본인 닉네임이 아니라면
            if (!nickname.equals(targetName)) {

                // 닉네임과 두글자씩 잘린 닉네임의 일치 여부를 확인한다.
                Boolean result = nickname.matches(regex);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 일치하는지 확인해야하는 닉네임을 두글자씩 잘라 리스트에 넣는다.
     * @param targetName 일치하는지 확인해야하는 닉네임
     * @return 두글자씩 잘린 닉네임 리스트
     */
    private static ArrayList<String> cutNickname(String targetName) {
        ArrayList<String> cutNameList = new ArrayList<> ();
        for (int i = 0; i < targetName.length() - 1; i++) {
            cutNameList.add(targetName.substring(i, i + 2));
        }
        return cutNameList;
    }
}
