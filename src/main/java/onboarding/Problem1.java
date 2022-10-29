package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /*
        * 1~400까지 페이지가 적힌 책을 주움.
        * "왼쪽은 홀수, 오른쪽은 짝수"
        * 왼쪽 페이지(홀수)의 max(각자리 숫자 더한거, 각자리 숫자 곱한거)
        * 이 두 수를 비교해, pobi>crong이면 1 pobi<crong이면 2 pobi==crong이면 0
        * 예외사항이면 -1
        * 내가 생각한 예외 사항들
        * 1.pobi[0]이 짝수 pobi[1]이 홀수 or crong[0]이 짝수 crong[1]이 홀수
        * 2.pobi[0]+1 != pobi[1] or crong[0]+1 != crong[1]
        * 3.시작면(1)이나 마지막면(400)이 있는 경우
        *
        * 이후 풀이는, 숫자배열인 pobi와 crong을 문자열 배열로 만든 다음,
        * 문자열 배열을 문자마다 탐색하여, 숫자로 다시 변환시켜 plus,multiple에 각각 더하거나 곱해준다.
        * 이 둘중 max를 구한다음, 다시 pobi와 crong중 max를 따져 answer값을 정한 다음, return해주는 문제.
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