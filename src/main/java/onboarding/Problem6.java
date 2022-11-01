package onboarding;

import java.util.*;

public class Problem6 {

    private final static int NUM_OF_DUPLICATE_CRITERIA = 2; //중복 기준 글자 수

    //중복 기준 글자로 문자 나누기
    private static List<String> divideChars(String nickNames) {
        List<String> eachChars = new ArrayList<>();
        String eachChar;

        for (int i = 0; i < nickNames.length() - (NUM_OF_DUPLICATE_CRITERIA-1); i++) {
            eachChar = "";
            for (int j = 0; j < NUM_OF_DUPLICATE_CRITERIA; j++) {
                eachChar += nickNames.charAt(i + j);
            }
            eachChars.add(eachChar);
        }

        return eachChars;
    }

    //중복 제거하기
    private static List<String> removeRepeated(List<String> includeRepeated) {

        Set<String> set = new HashSet<>(includeRepeated);
        List<String> excludeRepeated = new ArrayList<>(set);
        return excludeRepeated;
    }

    //중복되는 문자 list 반환
    private static List<String> findRepeatedChars(List<String> allChars) {

        List<String> repeatedChars = new ArrayList<>();

        for (String chars : allChars) {
            if (2 <= Collections.frequency(allChars, chars)) {
                repeatedChars.add(chars);
            }
        }

        return repeatedChars;
    }

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        List<String> emails = new ArrayList<>();

        List<List<String>> dividedCharsWithSameFormsIndex = new ArrayList<>();
        List<String> allChars = new ArrayList<>();
        List<String> repeatedChars = new ArrayList<>();

        String nickname;

        //닉네임을 두 글자씩 나눠 중복을 제거한 후 각 리스트에 담기
        for (int i = 0; i < forms.size(); i++) {
            nickname = forms.get(i).get(1);

            dividedCharsWithSameFormsIndex.add(removeRepeated(divideChars(nickname)));
            //중복 단어를 찾기 위한 리스트
            allChars.addAll(removeRepeated(divideChars(nickname)));
        }

        //다른 크루와 중복되는 문자 list 받기
        if (allChars.size() != allChars.stream().distinct().count()) {
            repeatedChars.addAll(removeRepeated(findRepeatedChars(allChars)));
        }

        //이중리스트에 담은 분리문자들 중 중복문자가 있을 경우 같은 인덱스로 forms에서 이메일 찾기
        for (int i = 0; i < dividedCharsWithSameFormsIndex.size(); i++) {
            for (String repeatedWord : repeatedChars) {
                if (dividedCharsWithSameFormsIndex.get(i).contains(repeatedWord)) {
                    emails.add(forms.get(i).get(0));
                }
            }
        }
        //중복제거와 오름차순정렬
        answer.addAll(removeRepeated(emails));
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
