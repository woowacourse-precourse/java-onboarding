package onboarding;

import java.util.*;

public class Problem4 {
    // 변환될 알파벳의 인덱스를 찾는 function
    public static int change(ArrayList<String> list, String s){
        int index = (list.size()-1) - list.indexOf(s);
        return index;
    }
    public static String solution(String word) {
        String answer = "";

        // 알파벳 소문자 list 생성
        ArrayList<String> alp = new ArrayList<String>();
        for (char i = 'a'; i <= 'z'; i++){
            alp.add(Character.toString(i));
        }

        // word 문자별 loop
        for (int j = 0; j< word.length(); j++){
            // 필요한 변수 초기화
            // word의 인덱스별 문자
            char c = word.charAt(j);
            // alp list에서 변환할 문자 index값을 저장할 공간
            int index = 0;
            // 변환될 인덱스를 찾기 위한 알파벳
            String change_c = "";

            // 제한사항 1. 알파벳인 문자만 변환
            if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                // 제한사항 2. 대문자 -> 대문자, 소문자 -> 소문자
                // 대문자일시
                if(Character.isUpperCase(c)){
                    // 소문자화
                    change_c = Character.toString(c).toLowerCase();
                    // 변환 인덱스 구하기
                    index = change(alp, change_c);
                    // alp에서 변환할 문자를 찾은 다음, 대문자화후 answer에 추가
                    answer += alp.get(index).toUpperCase();
                }
                // 소문자일시
                else{
                    change_c = Character.toString(c);
                    index = change(alp, change_c);
                    // alp에서 변환할 문자를 찾은 다음, 그대로 answer에 추가
                    answer += alp.get(index);
                }
            }
            else{
                answer += c;
            }
        }
        return answer;
    }
}