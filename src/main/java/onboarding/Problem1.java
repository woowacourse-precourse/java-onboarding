package onboarding;

import java.util.List;

class Problem1 {
    /*
       1. 1~400 페이지 사이에 있어야 한다.
       2. pobi, crong 왼쪽은 홀수, 오른쪽은 짝수여야 한다.
       3. 두 페이지의 차이는 1이어야 한다.
       위 세 가지 경우 외에는 전부 예외사항이므로 -1 처리
    */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        try {
            Exception e = new Exception("조건에서 예외 발생");
            if(pobi.get(0)<1 || pobi.get(1)>400 || crong.get(0)<1 || crong.get(1)>400){
                throw e;
            }else if(pobi.get(0)%2==0 || crong.get(0)%2==0 || pobi.get(1)%2==1 || crong.get(1)%2==1){
                throw e;
            }else if(pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1){
                throw e;
            }else {
                int max_pobi = score(pobi);
                int max_crong = score(crong);

                if(max_pobi>max_crong){
                    answer = 1;
                } else if (max_pobi<max_crong) {
                    answer = 2;
                } else {
                    answer = 0;
                }
            }
        }catch (Exception e) {
            return -1;
        }

        return answer;
    }
    public static int score(List<Integer> pages) {
        int max_score = 0;

        for (int i = 0; i<2; i++){
            int sum = 0;
            int mul = 1;
            int num = pages.get(i);
            while (num!=0){
                sum += num%10;
                mul *= num%10;
                num /= 10;
            }

            if(sum>mul){
                if(max_score<sum) {
                    max_score = sum;
                }
            }else{
                if(max_score < mul) {
                    max_score = mul;
                }
            }
        }

        return max_score;
    }
}