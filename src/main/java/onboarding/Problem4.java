package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] wordArr = word.toCharArray();

        for(int i=0; i<wordArr.length; i++){
            if( 65 <= wordArr[i] && wordArr[i] <=90 ){
                wordArr[i] = (char)(155 - wordArr[i]);
            }

            if(97 <= wordArr[i] && wordArr[i] <=122){
                wordArr[i] = (char)(219 - wordArr[i]);
            }
        }
        answer = new String(wordArr);
        return answer;
    }

}
