package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] letterList = new char[]{
            'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R',
            'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I',
            'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'
        };

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);

            if(c>='A' && c<='Z'){
                answer+=letterList[c-'A'];
            }
            else if (c>='a' && c<='z'){
                answer+=(char)((letterList[c-'a'])+32);
            }
            else answer+=c;
        }

        return answer;
    }
}
