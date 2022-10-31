package onboarding;

import java.util.*;

public class Problem6 {

    static HashMap<String, List<String>> nickNameList = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {

        Set<String> emailList = new HashSet<>();
        String nickName, email;

        for (List<String> form : forms) {
            email = form.get(0);
            nickName = form.get(1);

            if ("@email.com".equals(email.substring(email.length() - 10))) {
                saveEmailByDivideNickName(nickName, email);
            }
        }

        for (List<String> emails : nickNameList.values()) {

            if (emails.size() >= 2) {
                emailList.addAll(emails);
            }
        }

        ArrayList<String> answer = new ArrayList<>(emailList);
        Collections.sort(answer);

        return answer;
    }

    //닉네임을 두글자씩 나눈 것 기준으로 email과 함께 저장
    static void saveEmailByDivideNickName(String nickName, String email) {

        String key;

        for (int i = 0; i < nickName.length() - 1; i++) {
            key = nickName.substring(i, i + 2);

            if (nickNameList.get(key) == null) {
                List<String> list = new ArrayList<>();
                list.add(email);
                nickNameList.put(key, list);

            } else {
                nickNameList.get(key).add(email);
            }
        }
    }


}
