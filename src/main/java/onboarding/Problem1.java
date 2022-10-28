package onboarding;

import java.util.*;
import java.util.List;

class Problem1 {
    // 예외처리 함수
    public static boolean exception(List<Integer> list){
        // 1. pobi와 crong의 길이가 2가 아닌 경우
        // 2. 왼쪽 페이지가 짝수, 오른쪽 페이지가 홀수 인 경우
        // 3. 시작, 끝 페이지가 나오는 경우
        // 4. 페이지 간 차이가 1이 아닌 경우
        if(list.size() != 2 ||
                list.get(0)%2 == 0 || list.get(1)%2 == 1 ||
                list.contains(1) || list.contains(400) ||
                list.get(1) - list.get(0) !=1){
            return false;
        }
        else{
            return true;
        }
    }
    // 최대값 찾는 함수
    public static int find_max(List<Integer> list){
        // 2~3과정을 한번에 처리 => 모든 경우의 수 (총 4가지) 중 최대값 구하기
        // 사람별 경우의 수 : 네가지 값 저장할 리스트 선언
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i=0; i<2; i++){ // 왼쪽 페이지 -> 오른쪽 페이지
            // 페이지 선언
            int page = list.get(i);
            // 초기 값 설정
            int plus = 0, multiply = 1;
            // 자리수 더한 값, 곲한 값 구하기
            while(page > 0){
                plus += page%10;
                multiply *= page%10;
                page /= 10;
            }
            // 경우의 수에 추가
            res.add(plus);
            res.add(multiply);
        }
        // 네가지 경우의 수 중 가장 큰 값 = 본인의 점수
        int max = res.isEmpty() ? -1 : Collections.max(res);
        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 1단계 : 예외처리
        if(exception(pobi) && exception(crong)){
            // 2단계 : 최대값 비교
            int max_pobi = find_max(pobi);
            int max_crong = find_max(crong);
            // pobi의 max값 > crong의 맥스값 => 1
            if(max_pobi > max_crong){
                answer = 1;
            }
            // pobi의 max값 < crong의 맥스값 => 2
            else if (max_pobi < max_crong) {
                answer = 2;
            }
            // pobi의 max값 = crong의 맥스값 => 0
            else {
                answer = 0;
            }
        }
        // 예외 경우 시 => -1
        else{
            answer = -1;
        }

        return answer;
    }

}
