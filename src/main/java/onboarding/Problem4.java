package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0;i<word.length();i++) {
            int ch = word.charAt(i);
            if(ch>=65 && ch<=90) ch=155-ch;
            else if(ch>=97 && ch<=122) ch=219-ch;
            answer+=(char)ch;
        }
        return answer;
    }
}
