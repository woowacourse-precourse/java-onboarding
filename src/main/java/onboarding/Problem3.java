package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if(number < 10){ // 한자리인 경우
            answer += number / 3;
        }
        else if(number < 100){ // 두자리인 경우

            answer += (number/10) * 3 + (number%10)/3; //일의자리

            if((number/10)%3 == 0){ // 십의 자리가 3 6 9 인 경우
                answer += ((number/10)/3 - 1) * 10 + (number % 10 +1); // 십의자리
            }
            else{
                answer += ((number/10)/3)*10;
            }
        }
        else if(number >= 100){
            answer += (number/10) * 3 + (number%10)/3; //일의자리

            if((number/10)%3 == 0){
                answer += ((number/100)*3) *10 + (number % 10 +1);

            }
            else{
                answer += ((number/100)*3)*10;
            }

            if((number/100)%3 == 0){
                answer += ((number/100)/3 - 1) * 100 + (number % 100 + 1);
            }
            else{
                answer += ((number/100)/3)*100;
            }

        }
        return answer;
    }
}
