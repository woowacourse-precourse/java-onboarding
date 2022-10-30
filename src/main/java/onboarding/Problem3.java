package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(number==10000)
            number=9999;
        answer = calculateClap(number);
        return answer;
    }
    public static int calculateClap(int number){
        int sum = 0;
        int tmp1,tmp10,tmp100,tmp1000;
        // 1의자리
        tmp1 = number%10;
        sum+= 3*(number/10)+tmp1/3;
        // 10의자리
        if(number>=10){
            tmp10 = number%100/10;
            sum+= 3*(number/100)*10;
            if(tmp10%3==0){
                sum+=(tmp10/3-1)*10 + number%10+1;
            }
            else{
                sum+=(tmp10/3)*10;
            }
        }
        // 100의자리
        if(number>=100) {
            tmp100 = number % 1000 / 100;
            sum += 3 * (number / 1000) * 100;
            if (tmp100 % 3==0) {
                sum += (tmp100 / 3 - 1) * 100 + number % 100 + 1;
            } else {
                sum += (tmp100 / 3) * 100;
            }
        }
        // 1000의자리
        if(number>=1000){
            tmp1000 = number/1000;
            if(tmp1000%3==0){
                sum+=(tmp1000/3-1)*1000 + number%1000 + 1;
            }
            else{
                sum+=(tmp1000/3)*1000;
            }
        }
        return sum;
    }
}
