package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();
        for (List<String> form : forms) {
            emails.add(form.get(0));
            nicknames.add(form.get(1));
        }

        List<Integer> duplicatedIndexes = checkNicknames(nicknames);
        for (int index : duplicatedIndexes) {
            answer.add(emails.get(index));
        }
        
        Collections.sort(answer);
        return answer;
    }

    private static List<Integer> checkNicknames(List<String> nicknames) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < nicknames.size()-1; i++) {

            String checkingNickname = nicknames.get(i);     // 이번에 검사할 닉네임
            List<String> checkingNicknameSlices = devideIntoTwo(checkingNickname);  // 검사할 닉네임을 2글자씩 조각으로 분리

            List<String> others = new ArrayList<>(nicknames.subList(i+1,nicknames.size()));
            for (String other : others) {
                for (String nowChecking : checkingNicknameSlices) {
                    if (isDuplicated(nowChecking, other)) {     // 중복일 경우
                        if (!indexes.contains(i)) {
                            indexes.add(i);         // 두글자로 검사한 닉네임의 인덱스 추가
                        }
                        if (!indexes.contains(nicknames.indexOf(other))){
                            indexes.add(nicknames.indexOf(other));      // 검사 대상이 된 닉네임의 인덱스 추가
                        }
                    }
                }
            }
        }
        return indexes;
    }

    private static boolean isDuplicated(String nowChecking, String otherNickname) {
        boolean tf = otherNickname.contains(nowChecking);
        return tf;
    }

    private static List<String> devideIntoTwo(String nickname) {
        List<String> twoLetters = new ArrayList<>();
            for (int i = 0; i < nickname.length() - 2; i++) {
                String slicedStr = nickname.substring(i, i + 2);
                if (!twoLetters.contains(slicedStr)) {
                    twoLetters.add(slicedStr);
                }
            }
        return twoLetters;
    }
}
