package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /*
        기능목록
        1.예외처리
        2.숫자 -> 문자열 전환
        3.문자열 -> 문자 -> 숫자 전환 후 덧셈/곱셈에 값 추가.
        4. pobi,crong의 덧셈/곱셈 중 최대값 구하기
        5. pobi,crong중 큰 값을 탐색하고, 이에 맞는 answer값 할당 후 return.
        * */
        int answer = Integer.MAX_VALUE;

        //예외 사항 처리 1,2번
        if (pobi.get(0) %2==1 && pobi.get(1) %2==0 && crong.get(0) %2==1 && crong.get(1) %2==0 ){
            if ((pobi.get(0)+1) != pobi.get(1) || (crong.get(0)+1) != crong.get(1)){
                //예외사항 넘김.
                return -1;
            }
        }
        else{
            return -1;
        }
        //예외 사항 처리 3번
        if (pobi.get(0)==1 || pobi.get(1)==400 || crong.get(0)==1 || crong.get(1)==400){
            return -1;
        }

        ArrayList<String> pobi_string = new ArrayList<>();
        ArrayList<String> crong_string = new ArrayList<>();

        for (int x: pobi){
            pobi_string.add(Integer.toString(x));
        }
        for (int x: crong){
            crong_string.add(Integer.toString(x));
        }

        int plus_pobi = 0;
        int multiple_pobi = 1;

        int plus_crong = 0;
        int multiple_crong = 1;

        for (String s:pobi_string){
            for (int i=0;i<s.length();i++){
                plus_pobi+=Character.getNumericValue(s.charAt(i));
                multiple_pobi*=Character.getNumericValue(s.charAt(i));
            }
        }

        for (String s:crong_string){
            for (int i=0;i<s.length();i++){
                plus_crong+=Character.getNumericValue(s.charAt(i));
                multiple_crong*=Character.getNumericValue(s.charAt(i));
            }
        }

        int max_pobi = Math.max(plus_pobi,multiple_pobi);
        int max_crong = Math.max(plus_crong,multiple_crong);

        if (max_pobi>max_crong){
            answer = 1;
        }
        else if (max_pobi<max_crong){
            answer = 2;
        }
        else{
            answer = 0;
        }


        return answer;
    }
}