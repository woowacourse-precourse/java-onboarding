package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int prev = cryptogram.length() + 1, next = cryptogram.length();
        String pattern = "aa|bb|cc|dd|ee|ff|gg|hh|ii|jj|kk|ll|mm|nn|oo|pp|qq|rr|ss|tt|uu|vv|ww|xx|yy|zz";
        String tmp = cryptogram;
        while(next > 0 && prev > next) {
            tmp = tmp.replaceAll(pattern, "");
            prev = next;
            next = tmp.length();
        }
        return tmp;
    }
}
