package onboarding;

public class Problem3 {
    public static int solution(int number) {
       int ans=0;
       return ans=0;
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
}
