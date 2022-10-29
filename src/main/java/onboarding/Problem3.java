package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if(!isIncludeNum(number)) return -1; //입력 숫자는 1이상 10000이하여야한다.
        int ans=0;
        for (int num = 0; num <= number; num++) {
            ans += countClap(num);
        }
        return ans;
    }

    private static int countClap(int num) {
        String numToString = String.valueOf(num);
        int count=0;

        for (int i = 0; i < numToString.length(); i++) {
            char eachDigit = numToString.charAt(i);

            if(eachDigit=='3'||eachDigit=='6'||eachDigit=='9')
                count++;
        }
        return count;
    }

    private static boolean isIncludeNum(int num) {
        if(num>=1&&num<=10000) return true;
        else return false;
    }
}
