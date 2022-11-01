package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz"; // alphabet
        StringBuffer sb = new StringBuffer(alphabet);
        String reversedAlphabet = sb.reverse().toString(); // 역순 alphabet

        String answer = "";
        int idx = -1;
        for(int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            if((int)tmp >= 65 && (int)tmp <= 90) { // 대문자
                idx = alphabet.indexOf(Character.toLowerCase(word.charAt(i)));
                answer += Character.toString(Character.toUpperCase(reversedAlphabet.charAt(idx)));
            } else if((int)tmp >= 97 && (int)tmp <= 122) { // 소문자
                idx = alphabet.indexOf(word.charAt(i));
                answer += Character.toString(reversedAlphabet.charAt(idx));
            } else { // 나머지 문자
                answer += Character.toString(tmp);
            }
        }
        return answer;
    }
}
