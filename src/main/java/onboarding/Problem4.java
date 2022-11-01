package onboarding;

class Encoding {
    StringBuilder result = new StringBuilder();
    public StringBuilder encodeWord(String word) throws RestrictException {
        if (word.length() < 1 || word.length() > 1000) {
            throw new RestrictException("WordLengthOutOfRange");
        }
        for (int i = 0; i < word.length(); i++) {
            if ((int)word.charAt(i) <= 90 && (int)word.charAt(i) >= 65) {
                result.append((char)(155 - (int) word.charAt(i)));
            }
            else if ((int)word.charAt(i) <= 122 && (int)word.charAt(i) >= 97) {
                result.append((char)(219 - (int) word.charAt(i)));
            } else {
                result.append(word.charAt(i));
            }
        }
        return result;
    }
}
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        try {
            Encoding encodedWord = new Encoding();
            answer = encodedWord.encodeWord(word).toString();
        } catch (RestrictException e) {
            System.out.println(e.exMsg);
            return answer;
        }
        return answer;
    }
}
