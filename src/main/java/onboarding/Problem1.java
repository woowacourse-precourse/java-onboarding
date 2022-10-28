package onboarding;

import java.util.List;

/*
 * 각 숫자마다 답변 class에 따로 저장해놓고 그걸로 출력하기
 * else 최대한 줄여보는 쪽으로 생각해보기
 * 예외 생각하기 쪽수 < 0 || 쪽수 > 400 추가
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pobi.get(0) % 2 == 0 && crong.get(0) % 2 == 0){
            return answer = -1;
        }
        if(pobi.get(1) - pobi.get(0) != 1 & crong.get(1) - pobi.get(0) != 1){
            return answer = -1;
        }
        int pobi_cal = Math.max(SumOrMul(pobi.get(0)), SumOrMul(pobi.get(1)));
        int crong_cal = Math.max(SumOrMul(crong.get(0)), SumOrMul(crong.get(1)));

        if (pobi_cal > crong_cal){
            answer = 1;
        }else if (pobi_cal < crong_cal){
            answer = 2;
        }else{
            answer = 0;
        }

        return answer;
    }

    /*
    계산 해주는 함수
     */
    static int SumOrMul(int n){
        int cal = 0; //계산 결과
        int sum = 0;
        int mul = 1;
        while(n != 0){
            sum += n % 10;
            mul  *= n % 10;
            n /= 10;
        }
        System.out.print(sum);
        System.out.print(mul);
        cal = Math.max(sum, mul);
        return cal;
    }
}