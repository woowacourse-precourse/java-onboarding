package onboarding;

public class Problem3 {
    static String numCheck(int number) {
        String exception="";
        if(number < 1 || number > 1000) {
            exception = "범위 오류";
        }
        return exception;
    }

    static int counter(int number) {
        int count = 0;
        for(int i=1; i<=number; i++) {
            String str = String.valueOf(i);
            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                if(c=='3' || c=='6' || c=='9') count++;
            }
        }
        return count;
    }

    public static int solution(int number) {
        numCheck(number);
        return counter(number);
    }
}