package onboarding;

public class Problem4 {
    public static char convertFrogDictionary(char word) {
        int lower_ascii_number = 122;
        int upper_ascii_number = 90;
        for (int i = 0; i <= 25; i++) {
            if ((i + 65) == (int) word)
                return (char) upper_ascii_number;
            upper_ascii_number--;
        }
        for (int i = 0; i <= 25; i++) {
            if ((i + 97) == (int) word)
                return (char) lower_ascii_number;
            lower_ascii_number--;
        }
        return word;
    }
public static void catchException(String word){
        assert (word.length()>=1);
        assert (word.length()<=1000);
}
    public static String solution(String word) {
        catchException(word);
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer += String.valueOf(convertFrogDictionary(word.charAt(i)));
        }
        return answer;
    }
}
