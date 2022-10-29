package onboarding;

public class Problem2 {
    public static String removeOverlap(String str) {
        char[] chars = str.toCharArray();
        char prev = chars[0];

        for (int i = 1; i < chars.length; i++)
        {
           if(prev == chars [i]){
               chars[i-1] = ' ';
               chars[i] = ' ';
           }
           prev = chars[i];
        }
        String ans = String.valueOf(chars);
        ans = ans.replaceAll(" ", "");
        return ans;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
