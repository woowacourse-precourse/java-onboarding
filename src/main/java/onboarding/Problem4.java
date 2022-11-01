package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] chr = word.toCharArray();

        //대소문자 변환
        for(int i=0; i<chr.length; i++){
            if((chr[i]>=65) & (chr[i]<=90)){
                int sum = chr[i]+25;
                if(sum>=90) chr[i] = (char) (90-(sum-90));
                else chr[i] = (char) (sum+25);
            } else if ((chr[i]>=97) & (chr[i]<=122)) {
                int sum = chr[i]+25;
                if(sum>=122) chr[i] = (char) (122-(sum-122));
                else chr[i] = (char) (sum+25);
            }
        }

        answer = String.valueOf(chr);
        return answer;
    }
}
