package onboarding;

import java.util.*;

/*
1. 형식 체크하기
2. 문자열 토큰 얻기
3. 중복 확인하기
4. 중복 추가하기
5. 정렬하기
 */

public class Problem6 {

    private static boolean isValidEmail(String email) {
        if (email.matches(".*@email.com") && 10 < email.length() && email.length() < 20)
            return true;
        return false;
    }

    private static boolean isValidName(String name) {
        if (name.matches("^[가-힣]*$") && 0 < name.length() && name.length() < 20)
            return true;
        return false;
    }

    private static Set<String> getNameToken(String name) {
        Set<String> nameToken = new HashSet<>();
        for (int i = 0; i < name.length() - 1; i ++) {
            nameToken.add(name.substring(i, i + 2));
        }
        return nameToken;
    }

    private static Set<String> checkDuplication(List<List<String>> forms, int index) {
        Set<String> duplication = new HashSet<>();
        Set<String> tokenList = new HashSet<>(getNameToken(forms.get(index).get(1)));

        for (int i = 0; i < forms.size(); i ++) {
            if (i == index)
                continue;
            for (String token: tokenList) {
                if (forms.get(i).get(1).matches(".*"+token+".*"))
                    duplication.add(forms.get(i).get(0));
            }
        }
        return duplication;
    }

    private static List<String> addDuplication(List<List<String>> forms) {
        Set<String> duplicationArray = new HashSet<>();
        for (int i = 0; i < forms.size(); i ++) {
            if (isValidName(forms.get(i).get(1)) && isValidEmail(forms.get(i).get(0)))
                duplicationArray.addAll(checkDuplication(forms, i));
            if (!isValidEmail(forms.get(i).get(0)) || !isValidName(forms.get(i).get(1))) {
                duplicationArray.add(forms.get(i).get(0));
                forms.remove(i);
                i -= 1;
            }
        }
        return sortDuplication(duplicationArray);
    }

    private static List<String> sortDuplication(Set<String> duplicationArray) {
        List<String> sortArray = new ArrayList<>(duplicationArray);
        Collections.sort(sortArray);
        return sortArray;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList(addDuplication(forms));
        return answer;
    }
}
