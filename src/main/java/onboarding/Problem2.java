package onboarding;

import java.util.*;
class Solution {
    public String solution(String cryptogram) {
        return decode(cryptogram);
    }
    private String decode(String str) {    //분석
        String reuslt = "";     //결과값
        boolean check = true;
        String[] array = str.split("");     //분할하기
        List<String> list = Arrays.asList(array);

        while (check) {
            check = false;
            List<String> cur_string = new ArrayList<>();
            cur_string.addAll(list);

            for (int i = 0; list.size() - 1 > i; i++)       //문자 중복 제거 구간 시작
                if (list.get(i).equals(list.get(i + 1))) {
                    cur_string.remove(i + 1);
                    cur_string.remove(i);
                    list = cur_string;
                    check = true;
                }
            list = cur_string;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s);     //출력을 위해 합치기
        reuslt = sb.toString();
        return reuslt;
    }
}