package onboarding;

import java.util.*;

public class Problem6 {

    //두 글자씩 문자 나누기
    private static List<String> divideByTwoChars(String nickNames) {
        List<String> eachTwoChars = new ArrayList<>();

        for (int i = 0; i < nickNames.length() - 1; i++) {
            eachTwoChars.add("" + nickNames.charAt(i) + nickNames.charAt(i + 1));
        }

        return eachTwoChars;
    }

    //중복 제거하기
    private static List<String> removeRepeated(List<String> containRepeated) {

        Set<String> set = new HashSet<>(containRepeated);
        List<String> singleList = new ArrayList<>(set);
        return singleList;
    }

    //중복되는 문자 list 반환
    private static List<String> findRepeatedWords(List<String> allTwoChars) {

        List<String> repeatedWords = new ArrayList<>();

        for (String word : allTwoChars) {
            if (2 <= Collections.frequency(allTwoChars, word)) {
                repeatedWords.add(word);
            }
        }

        return repeatedWords;
    }

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        List<String> emails = new ArrayList<>();

        List<List<String>> indexTwoChars = new ArrayList<>();
        List<String> allTwoChars = new ArrayList<>();
        List<String> repeatedWords = new ArrayList<>();

        String nickname;

        //닉네임을 두 글자씩 나눠 중복을 제거한 후 각 리스트에 담기
        for (int i = 0; i < forms.size(); i++) {
            nickname = forms.get(i).get(1);

            //닉네임을 나눈 리스트의 인덱스가 forms 닉네임 인덱스와 같은 이중리스트
            indexTwoChars.add(removeRepeated(divideByTwoChars(nickname)));
            //중복 단어를 찾기 위한 리스트
            allTwoChars.addAll(removeRepeated(divideByTwoChars(nickname)));
        }

        //다른 크루와 중복되는 문자 list 받기
        if (allTwoChars.size() != allTwoChars.stream().distinct().count()) {
            repeatedWords.addAll(removeRepeated(findRepeatedWords(allTwoChars)));
        }

        //이중리스트에 담은 분리문자들 중 중복문자가 있을 경우 같은 인덱스로 forms에서 이메일 찾기
        for (int i = 0; i < indexTwoChars.size(); i++) {
            for (String repeatedWord : repeatedWords) {
                if (indexTwoChars.get(i).contains(repeatedWord)) {
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
