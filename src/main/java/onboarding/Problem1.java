package onboarding;

import java.util.List;

class Problem1 {
    public static int hundred(int x) {
        return x/100;
    }
    public static int ten(int x) {
        return x/100%10;
    }
    public static int one(int x) {
        return x%10;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외사항인지 아닌지 판단
        //예외사항인 경우
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            answer = -1;
        }
        //예외사항이 아닌 경우
        else {
            int pobi_left_max = 0; //pobi의 왼쪽 max
            int pobi_right_max = 0; //pobi의 오른쪽 max
            if (pobi.get(0)/100 == 0) { //두 자리수일때
                pobi_left_max = Math.max(pobi.get(0)%100/10 + pobi.get(0)%10, (pobi.get(0)%100/10) * (pobi.get(0)%10));
            }
            else {
                pobi_left_max = Math.max(pobi.get(0)/100 + pobi.get(0)%100/10 + pobi.get(0)%10, (pobi.get(0)/100) * (pobi.get(0)%100/10) * (pobi.get(0)%10));
            }

            if (pobi.get(1)/100 == 0) {
                pobi_right_max = Math.max(pobi.get(1)%100/10 + pobi.get(1)%10, (pobi.get(1)%100/10) * (pobi.get(1)%10));
            }
            else {
                pobi_right_max = Math.max(pobi.get(1)/100 + pobi.get(1)%100/10 + pobi.get(1)%10, (pobi.get(1)/100) * (pobi.get(1)%100/10) * (pobi.get(1)%10));
            }

            int pobi_final_max = Math.max(pobi_left_max, pobi_right_max); //pobi의 최종 값


            int crong_left_max = 0; //crong의 왼쪽 max구하기
            if (crong.get(0)/100 == 0) {
                crong_left_max = Math.max(crong.get(0)%100/10 + crong.get(0)%10, (crong.get(0)%100/10) * (crong.get(0)%10));
            }
            else {
                crong_left_max = Math.max(crong.get(0)/100 + crong.get(0)%100/10 + crong.get(0)%10, (crong.get(0)/100) * (crong.get(0)%100/10) * (crong.get(0)%10));
            }

            int crong_right_max = 0; //pobi의 오른쪽 max구하기
            if (crong.get(1)/100 == 0) {
                crong_right_max = Math.max(crong.get(1)%100/10 + crong.get(1)%10, (crong.get(1)%100/10) * (crong.get(1)%10));
            }
            else {
                crong_right_max = Math.max(crong.get(1)/100 + crong.get(1)%100/10 + crong.get(1)%10, (crong.get(1)/100) * (crong.get(1)%100/10) * (crong.get(1)%10));
            }

            int crong_final_max = Math.max(crong_left_max, crong_right_max); //crong의 최종 값


            //pobi와 crong 최종 값 비교
            if (pobi_final_max > crong_final_max) {
                answer = 1;
            }
            if (crong_final_max > pobi_final_max) {
                answer = 2;
            }
            if (pobi_final_max == crong_final_max) {
                answer = 0;
            }
        }


        return answer;
    }
}