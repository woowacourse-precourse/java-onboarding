package onboarding;

import java.util.*;

public class Problem6 {
    static final Set<String> twoChars = new HashSet<>(); //연속 글자들의 저장소
    static final Set<String> duplicated = new HashSet<>(); //중복 글자들의 저장소

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (List<String> info:forms) {
            String nickName = info.get(1);
            //닉네임에 연속글자가 이미 존재했으면 duplicated에 추가
            checkDuplicated(nickName);
            //닉네임들을 2글자씩 나눠 저장
            saveTwoChars(nickName);
        }

        //같은 연속글자 포함하는 이메일들 얻기
        for (List<String> info:forms) {
            String email = getDuplicatedEmail(info);

            if (email != null) {
                answer.add(email);
            }
        }

        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    private static void checkDuplicated(String nickName) {
        for (String twoChar :twoChars) {
            if (nickName.contains(twoChar)) {
                duplicated.add(twoChar);
            }
        }
    }

    private static void saveTwoChars(String nickName) {
        for (int i=0; i<nickName.length()-1; i++) {
            String twoChar = nickName.substring(i,i+2);
            twoChars.add(twoChar);
        }
    }

    private static String getDuplicatedEmail(List<String> info) {
        String nickName = info.get(1);

        for (String dupString:duplicated) {
            if (nickName.contains(dupString)) {
                String Email = info.get(0);
                return Email;
            }
        }

        return null;
    }
}
