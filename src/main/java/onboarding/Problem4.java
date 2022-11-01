package onboarding;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        int t=0;
        for(char c : word.toCharArray()){
            if('a'<=c&& c<='z'){
                t = 25-(c-'a');
                c  = (char) (t+'a');
            }else if('A'<=c&& c<='Z'){
                t = 25-(c-'A');
                c = (char) (t+'A');
            }
            //그 외 문자들 변환X
            sb.append(c);
        }
        String answer = sb.toString();
        return answer;
    }
}
