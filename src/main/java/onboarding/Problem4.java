package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sbWord = new StringBuilder(word);

        for (int k=0;word.length()>k;k++){
            char wordChar = sbWord.charAt(k);

            if (65<=(int)wordChar && (int)wordChar<=90){
                sbWord.setCharAt(k,(char)(155-(int)wordChar));
            }

            if (97<=(int)wordChar && (int)wordChar<=122){
                sbWord.setCharAt(k,(char)(219-(int)wordChar));
            }
        }

        String answer = String.valueOf(sbWord);
// 아스키 코드로 변환한 wordChar값을 소문자,대문자 각 최대+최소값을 더한값에서 빼주어 역순으로 구성한뒤 다시 String값으로 변환해줌
        return answer;
    }
}
