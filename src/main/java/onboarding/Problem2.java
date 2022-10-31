package onboarding;

public class Problem2 {
    public static boolean checkOverlap(String str) {
        if(str.equals("")) return false;
        String s = removeOverlap(str);
        if(s.equals(str)) return false;
        else return true;
    }
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
    public static String getAnswer(String cryptogram) {
        String tmp = cryptogram;
        while (checkOverlap(tmp)) {
            tmp = removeOverlap(tmp);
        }
        return tmp;
    }
    public static String solution(String cryptogram) {
        String answer = getAnswer(cryptogram);
        return answer;
    }
}
