package onboarding;

import java.util.*;

public class Problem6 {
    private static HashSet<String> twoWord; //모든 두글자 리스트
    private static List<String> searchTwoWord; //포함친구가 2명이상인 두글자 리스트
    private static List<String> sortEmail; //정렬할 이메일
    public static List<String> solution(List<List<String>> forms) {
        twoWord = new HashSet<>();
        searchTwoWord = new ArrayList<>();
        sortEmail = new ArrayList<>();

        //두글자씩 중복없이 twoWord에 넣는 기능
        for(int i = 0 ; i < forms.size() ; i++) {
            //총 반복할 횟수 = 해당 닉네임 글자수 -1
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                twoWord.add(forms.get(i).get(1).substring(j, j + 2));
            }
        }

        // twoWord의 두글자가 몇개의 닉네임에 해당하는지 확인
        for (String two : twoWord) {
            int count = 0;
            for(int i = 0 ; i < forms.size() ; i++) {
                if(forms.get(i).get(1).contains(two)) count += 1;
            }

        }


        List<String> answer = sortEmail;
        return answer;
    }
}
