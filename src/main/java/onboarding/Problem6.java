package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {

    private static List<String> answer = new ArrayList<>();
    private static List<List<String>> list;

    public static List<String> solution(List<List<String>> forms) {

        list = forms;

        String curr;
        for (int i = 0; i < forms.size(); i++) {
            curr = forms.get(i).get(1);
            check(i, curr);
        }

        Collections.sort(answer);
        return answer;

    }

    // 현재 글자를 2글짜씩 잘라서 전체 리스트에 있는지 체크해보는 메소드
    private static void check(int idx, String curr) {
        String temp;
        int count = 0;
        for (int j = 0; j < curr.length()-1; j++) {
            //2글자씩 자르고 일치하는게 있는지 탐색해보기
            temp = curr.substring(j, j+2);
            for (int k = 0; k < list.size(); k++) {
                if(k != idx && search(k, temp)){
                    count++;
                    break;
                }
            }
        }
        if (count > 0) answer.add(list.get(idx).get(0));
    }

    // 2글자를 통해 검색하는 메소드
    private static boolean search(int idx, String keyword) {
        return list.get(idx).get(1).matches(".*" + keyword+".*");
    }

}
