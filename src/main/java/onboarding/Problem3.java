package onboarding;

public class Problem3 {
    private static boolean is369Digit(char chr) {
        return (chr == '3' || chr == '6' || chr == '9');
    }
    private static int count369(String str){
        int     i;
        int     ret = 0;
        char    chr;

        for (i = 0; i < str.length(); i++) {
            chr = str.charAt(i);
            if (is369Digit(chr))
                ret += 1;
        }
        return ret;
    }
    public static int solution(int number) {
        int answer = 0;
        int i;

        for (i = 3; i <= number; i++) {
            String str = Integer.toString(i);
            answer += count369(str);
        }
        return answer;
    }
}
