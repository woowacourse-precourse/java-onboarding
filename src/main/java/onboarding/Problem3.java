package onboarding;


public class Problem3 {
    public static boolean clap(int n, int digit){
        String s = Integer.toString(n);
        if(Character.getNumericValue(s.charAt(digit)) == 3
                || Character.getNumericValue(s.charAt(digit)) == 6
                || Character.getNumericValue(s.charAt(digit)) == 9)
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
