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
            System.out.println((int)tmp);
            if(tmp == ' ') { // 공백
                answer += " ";
            } else if((int)tmp >= 65 && (int)tmp <= 90) { // 대문자
                idx = alphabet.indexOf(Character.toLowerCase(word.charAt(i)));
                answer += Character.toString(Character.toUpperCase(reversedAlphabet.charAt(idx)));
            } else {
                idx = alphabet.indexOf(word.charAt(i));
                answer += Character.toString(reversedAlphabet.charAt(idx));
            }
        }
        return answer;
    }
}
