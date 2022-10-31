package onboarding;

public class Problem4 {
    public static String solution(String word) {
        ////////////아스키코드 A=65~Z=90, a=97~z=122///////////////

        StringBuilder sbWord = new StringBuilder(word);
        for (int k=0;word.length()>k;k++){

//특정 위치 문자열을 대체하기 위해 StringBuilder를 사용

            char wordChar = sbWord.charAt(k);
            if (65<= (int)wordChar && (int)wordChar <=90){
                sbWord.setCharAt(k,(char)(155- (int)wordChar));
                System.out.println(sbWord);
            }
            if (97<= (int)wordChar && (int)wordChar <=122){
                sbWord.setCharAt(k,(char)(219- (int)wordChar));
                System.out.println(sbWord);
            }
        }
        System.out.println(sbWord);
        String answer = String.valueOf(sbWord);
// 아스키 코드로 변환한 wordChar값을 소문자,대문자 각 최대+최소값을 더한값에서 빼주어 역순으로 구성한뒤 다시 String값으로 변환해줌
        return answer;
    }
}
