package onboarding;

import java.util.List;

class Problem1 {

    //input으로 들어오는 list가 문제 조건에 맞는지 체크하는 함수
    public static boolean check_input(List<Integer> list){
        if(list.size() != 2) // 리스트의 길이가 2가 맞는지 확인
            return false;
        if(list.get(0) % 2 == 0) // 왼쪽페이지 숫자가 홀수가 맞는지 확인
            return false;
        if(list.get(1) - list.get(0) != 1) // 오른쪽페이지 숫자가 더 크고, 왼쪽페이지과의 차이가 1이 맞는지 확인
            return false;
        if(list.get(0) <= 1 || list.get(1) >= 400) // 페이지 숫자 범위가 첫번째장과 마지막장을 제외한 1~400 이내가 맞는지 확인.
            return false;

        //다음 조건들을 다 만족하면 true 리턴
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //입력으로 들어오는 리스트 pobi,crong이 문제 조건에 맞는지 확인
        //pobi와 crong 둘중에 하나라도 문제 조건에 맞지 않으면 -1을 리턴
        if(!check_input(pobi) || !check_input(crong)){
            answer = -1;
        }
        else{
            
        }

        return answer;
    }
}