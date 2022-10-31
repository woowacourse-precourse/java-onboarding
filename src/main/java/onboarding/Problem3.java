package onboarding;

public class Problem3 {
    public static int checkClap(int number, int count){
        while (number > 0){
            // check whether remainder is 3 or 6 or 9 and increase sum
            if (number%10==3||number%10==6||number%10==9){
                count++;
            }
            // divide quotient by 10 > actually can make number as quotient
            number/=10;
            checkClap(number, count);
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        int count = 0;
        // divide number by 10
        for (int i=0; i<number+1; i++){
            answer+=checkClap(i, count);
        }

        return answer;
    }
}
