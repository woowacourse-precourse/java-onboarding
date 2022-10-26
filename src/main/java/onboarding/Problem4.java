package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] word_pre = word.toCharArray();
        char[] word_post = new char[word_pre.length];

        /**
         *  ASCII Table
         *  A = 65
         *  Z = 90
         *  a = 97
         *  z = 122
         *  아스키 코드를 활용하여 문자변환
         */
        for(int i=0; i<word_pre.length; i++){
            if((word_pre[i] >= 'A') && (word_pre[i] <= 'Z'))
                word_post[i] = (char) (155 - word_pre[i]);
            else if((word_pre[i] >= 'a') && (word_pre[i] <= 'z'))
                word_post[i] = (char) (219 - word_pre[i]);
            else
                word_post[i] = word_pre[i];
        }

        answer = new String(word_post);

        return answer;
    }
}
