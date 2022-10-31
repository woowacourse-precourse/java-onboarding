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

    //페이지 숫자가 입력으로 들어오면 (각 자리수 합 or 각 자리수 곱)중에서 큰 값을 리턴하는 함수
    public static int getScore(int num){
        int sum_value = 0;
        int mul_value = 1;

        while(num != 0){
            int temp = num % 10;
            sum_value += temp;
            mul_value *= temp;
            num = num / 10;
        }
        return Math.max(sum_value, mul_value);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //입력으로 들어오는 리스트 pobi,crong이 문제 조건에 맞는지 확인
        //pobi와 crong 둘중에 하나라도 문제 조건에 맞지 않으면 -1을 리턴
        if(!check_input(pobi) || !check_input(crong)){
            answer = -1;
        }
        else{
            //getScore함수를 통해 왼쪽페이지 점수와 오른쪽페이지 점수를 구한 후, 둘중에서 큰 값을 자신의 점수로 결정한다.
            int pobi_score = Math.max(getScore(pobi.get(0)), getScore(pobi.get(1)));
            int crong_score = Math.max(getScore(crong.get(0)), getScore(crong.get(1)));

            //점수 결과에 따라서 answer값을 결정한다.
            if(pobi_score > crong_score)
                answer = 1;
            else if(pobi_score < crong_score)
                answer = 2;
            else
                answer = 0;
        }

        return answer;
    }
}