package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int checkNum;

        for(int num = 1; num <= number; num++) {
            checkNum = num;
            int length = (checkNum+"").length();
            while(length != 0) {
                int expo = (int)Math.pow(10, length-1);
                if(checkNum / expo == 3 || checkNum / expo == 6 || checkNum / expo == 9) answer++;
                checkNum = checkNum % expo;
                length--;
            }
        }
        return answer;
    }
}