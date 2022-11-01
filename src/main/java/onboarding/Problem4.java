package onboarding;

public class Problem4 {
    public static String changeAlphabet(String word) {
        char[] word_arr = word.toCharArray();
        String res = "";
        for(int i=0;i<word_arr.length;i++) {
            if ((int) ('A') <= (int) word_arr[i] && (int) ('Z') >= (int) word_arr[i]) {
                Character w = (char) ((int) ('A') + (int) ('Z') - (int) word_arr[i]);
                res += w.toString();
            } else if ((int) ('a') <= (int) word_arr[i] && (int) ('z') >= (int) word_arr[i]) {
                Character w = (char) ((int) ('a') + (int) ('z') - (int) word_arr[i]);
                res += w.toString();
            } else {
                res += word_arr[i];
            }
        }
        return res;
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
