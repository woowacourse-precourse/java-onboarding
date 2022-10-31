package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=0; i<number+1; i++){
            // i 가 1의 자리 숫자
            if(i < 10) {
                if (i == 3) {
                    answer += 1;
                } else if (i == 6) {
                    answer += 1;
                } else if (i == 9) {
                    answer += 1;
                }
                // i 가 10의 자리 숫자 일때
            }else if(i > 9 && i < 100){
                // 1의 자리 숫자 3, 6, 9
                if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9){
                    answer += 1;
                }
                // 10의 자리 숫자 3, 6, 9
                if(i / 10 == 3 || i / 10 == 6 || i / 10 == 9){
                    answer += 1;
                }
                // i 가 100의 자리 숫자 일때
            }else if(i > 99 && i < 1000){
                // 1의 자리 숫자 3, 6, 9
                if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9){
                    answer += 1;
                }
                // 10의 자리 숫자 3, 6, 9
                if(i / 10 % 10 == 3 || i / 10 % 10 == 6 || i / 10 % 10 == 9){
                    answer += 1;
                }
                // 100의 자리 숫자 3, 6, 9
                if(i / 10 / 10 == 3 || i / 10 / 10 == 6 || i / 10 / 10 == 9){
                    answer += 1;
                }
                // i 가 1000의 자리 숫자 일때
            }else if(i > 999 && i < 10000){
                // 1의 자리 숫자 3, 6, 9
                if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9){
                    answer += 1;
                }
                // 10의 자리 숫자 3, 6, 9
                if(i / 10 % 10 == 3 || i / 10 % 10 == 6 || i / 10 % 10 == 9){
                    answer += 1;
                }
                // 100의 자리 숫자 3, 6, 9
                if(i / 10 / 10 % 10 == 3 || i / 10 / 10 % 10 == 6 || i / 10 / 10 % 10 == 9){
                    answer += 1;
                }
                // 1000의 자리 숫자 3, 6, 9
                if(i / 10 / 10 / 10 == 3 || i / 10 / 10 / 10 == 6 || i / 10 / 10 / 10 == 9){
                    answer += 1;
                }
            }else{

            }
        }
        return answer;
    }
}
