package onboarding;

import java.util.List;

/*
    1 ~ 400 페이지의 책
    왼쪽은 홀수 , 오른쪽은 짝수 페이지
    왼쪽합 ,곱 / 오른쪽 합, 곱 중 큰수를 점수로 함
    비교하여 포비가 이기면1
            크롱이 이기면2
            무승부 이면 0
            예외사항은 -1
    ** 예외처리
    1. 배열의 크기가 2를 벗어날 경우
    2. 페이지 넘버는 null일 수 없음
    3. 페이지 수는 연속적 ex) 3,4 (O) / 103,105 (X)
    4. 시작 면이나 마자믹 면이 나오도록 책을 펼치지 않는다 ex) 1 과 400 이 나오면 안됨
    5. 왼쪽에 짝수 또는 오른쪽에 홀수가 나오는 경우
*/

class Problem1 {
    static boolean Check_Error(List<Integer> list){
        if(list.size() >2) {
            return false;
        }if(list.get(0) == null || list.get(1) == null) {
            return false;
        }if(list.get(1) - list.get(0) != 1 ){
            return false;
        }if(list.get(0) <= 1 || list.get(1) >= 400){
            return false;
        }if(list.get(0) % 2 == 0 || list.get(1) % 2 == 1 ){
            return false;
        }
        return true;
    }

    static int Return_Sum(int num){
        int num_sum = 0;
        while(num >0){
            num_sum += (num%10);
            num = num/10;
        }
        return num_sum;
    }

    static int Return_Mul(int num){
        int num_mul = 1;
        while(num > 0){
            num_mul *= (num%10);
            num = num/10;
        }
        return num_mul;
    }

    static int Cal_Score(List<Integer> list){
        int left_sum = Return_Sum(list.get(0));
        int left_mul = Return_Mul(list.get(0));
        int left_score = Integer.max(left_sum,left_mul);

        int right_sum = Return_Sum(list.get(1));
        int right_mul = Return_Mul(list.get(1));
        int right_score = Integer.max(right_sum,right_mul);

        int score = Integer.max(left_score,right_score);
        return score;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 예외처리 -1 반환
        if ( !Check_Error(pobi) || !Check_Error((crong))){
            return -1;
        }
        int pobi_score = Cal_Score(pobi);
        int crong_score = Cal_Score(crong);

        if(pobi_score == crong_score){
            answer = 0;
        } else if (pobi_score > crong_score) {
            answer = 1;
        } else if (pobi_score < crong_score) {
            answer = 2;
        }
        return answer;
    }
}