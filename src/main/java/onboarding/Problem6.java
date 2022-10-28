package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        /**
         * 문제 조건
         * 1. 이메일은 이메일 형식에 부합하며 전체 길이가 11자 이상 20자 미만이다
         * 2. 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
         * 3. 닉네임은 한글만 가능하며, 전체 길이는 1자 이상 20자 미만이다
         *
         * 구현 기능
         * 1. 크루들의 닉네임 중 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주하는 기능 구현
         * ( 닉네임이 한 글자이며, 중복되는 경우는 포함하지 않음)
         *  1) 크루들의 닉네임에 접근 해 가능한 모든 두 글자 경우의 수를 Set으로 담음
         *  2) Set으로 담은 가능한 모든 두 글자의 경우를 Map에 담음. key는 글자의 경우, Value는 0으로 초기화
         *  3) 크루들의 닉네임에 접근, contains를 사용해 Map의 value에 ++ 해 줌
         *  4) value가 2 이상인 두 글자 출력
         *  5) 해당 글자를 가지고 있는 유저를 set으로 담음 (중복 제거)
         *
         *  2. 중복 문자를 가지고 있는 유저의 email주소를 담고, 오름차순으로 정렬
         */

        //크루들의 닉네임으로 만들 수 있는 모든 두 글자의 문자
        HashSet<String> referenceWord = makeReferenceWord(forms);

        //두 글자의 문자가 각 크루들의 닉네임에 몇 번이나 속해있는지 구하는 메서드
        HashMap<String, Integer> wordReference_cnt = makeReferenceWordCnt(forms, referenceWord);

        // 2번 이상 나온 문자가 속하여 경고를 보내야 할 크루의 이메일을 구하는 메서드 (중복 제거)
        HashSet<String> alertEmail = makeAlertEmail(forms, wordReference_cnt);

        List<String> answer = new ArrayList<>(alertEmail);
        Collections.sort(answer);

        return answer;
    }


    private static HashSet<String> makeReferenceWord(List<List<String>> forms) {
        HashSet<String> referenceWords = new HashSet<>();
        // forms.size()를 for문으로 돌렸을 때, get(i).get(0)은 이메일, get(i).get(1)은 닉네임이다.
        // 닉네임의 길이가 2 이상인 경우에만 검증을 돌린다.
        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).get(1).length() >= 2) {
                String nickName = forms.get(i).get(1);
                for (int j = 0; j < nickName.length() - 1; j++) {
                    referenceWords.add(nickName.substring(j, j + 2));
                }
            }
        }
        return referenceWords;
    }

    private static HashMap<String, Integer> makeReferenceWordCnt(List<List<String>> forms, HashSet<String> wordReference) {
        HashMap<String, Integer> referenceWordCnt = new HashMap<>();
        for (String s : wordReference) {
            referenceWordCnt.put(s, 0);
        }

        for (int i = 0; i < forms.size(); i++) {
            for (String s : referenceWordCnt.keySet()) {
                if (forms.get(i).get(1).contains(s)) {
                    referenceWordCnt.put(s, referenceWordCnt.get(s) + 1);
                }
            }
        }
        return referenceWordCnt;
    }

    private static HashSet<String> makeAlertEmail(List<List<String>> forms, HashMap<String, Integer> wordReference_cnt) {
        HashSet<String> alertEmail = new HashSet<>();
        for (int i = 0; i < forms.size(); i++) {
            for (String s : wordReference_cnt.keySet()) {
                if (wordReference_cnt.get(s) >= 2 && forms.get(i).get(1).contains(s)) {
                    alertEmail.add(forms.get(i).get(0));
                }
            }
        }
        return alertEmail;
    }

}
