package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i =1; i<number+1; i++){ // 10000은 셀 필요가 없음

            if( i/1000==3||i/1000==6||i/1000==9 ){
                answer ++;
            }

            if(i%1000/100==3||i%1000/100==6||i%1000/100==9){
                answer ++;
            }

            if(i%100/10==3||i%100/10==6||i%100/10==9){
                answer ++;
            }
            if(i%10==3||i%10==6||i%10==9){
                answer ++;
            }
        }

        return answer;
    }

}
