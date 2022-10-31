package onboarding;


public class Problem3 {
    public static boolean clap(int n, int digit){
        String s = Integer.toString(n);
        char tmp = s.charAt(digit);
        if(tmp == '3' || tmp ==  '6' || tmp == '9')
            return true;
        else return false;
    }
    public static int clapSum(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            String s = Integer.toString(i);
            for (int j = 0; j < s.length(); j++) {
                if (clap(i, j))
                    count++;
            }
        }
        return count;
    }
    public static int solution(int number) {
        int answer = clapSum(number);
        return answer;
    }
}
