package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        //65~90, 32:공백
        //97~122

        char[] babyfrogB = {'Z','Y', 'X' ,'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N',
                'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
        char[] babyfrogS = {'z','y', 'x' ,'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n',
                'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

        for (int i =0; i<word.length(); i++) {
            if(word.charAt(i)==' ') answer += ' ';
            else if ('A'<=word.charAt(i) && word.charAt(i)<='Z') answer += babyfrogB[(int)word.charAt(i)-65];
            else answer += babyfrogS[(int)word.charAt(i)-97];
        }


        return answer;
    }

}
