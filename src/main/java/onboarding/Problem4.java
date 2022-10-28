package onboarding;


public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        char[] words = word.toCharArray();
        for(int i=0 ; i < words.length ; i++){
            if( (byte) words[i] == 32){  //공백 유지
                continue;
            } else if( (byte) words[i] > 90 ){  //대문자
                System.out.println((byte)words[i]);
                words[i] = (char)(219 - (byte) words[i]);
                System.out.println(words[i]);
            } else {  //소문자
                words[i] = (char)(155 - (byte) words[i]);
            }
        }

        answer = String.valueOf(words);

        return answer;
    }
}
