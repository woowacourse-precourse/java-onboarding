package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = List.of("answer");

        List<List<String>> indexTwoChars = new ArrayList<>();
        List<String> allTwoChars = new ArrayList<>();

        String nickname;

        //중복을 제거해 각 리스트에 담기
        for (int i = 0; i < forms.size(); i++) {
            nickname = forms.get(i).get(1);

            //닉네임을 나눈 리스트의 인덱스가 forms 닉네임 인덱스와 같은 이중리스트
            indexTwoChars.add(removeRepeated(divideByTwoChars(nickname)));
            //중복 단어를 찾기 위한 리스트
            allTwoChars.addAll(removeRepeated(divideByTwoChars(nickname)));
        }

        return answer;
    }
}
