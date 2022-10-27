package onboarding;

public class Problem3 {

    public static int getCount(int val){
        int count = 0;
        while(val > 0){
            int temp = val % 10;
            if( (temp == 3) || (temp == 6) || (temp == 9)) count+=1;
            val /= 10;
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
