package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    
    private static char convertToFrogDictionary(char word) {
        if (65 <= (byte)word && (byte)word <= 90) {
            return (char)(155 - (byte)word);
        } else if (97 <= (byte) word && (byte) word <= 122) {
            return (char) (219 - (byte)word);
        }

        return word;
    }
}
