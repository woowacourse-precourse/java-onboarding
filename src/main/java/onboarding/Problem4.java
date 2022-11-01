package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] reverseWord = new char[word.length()];

        for (int i = 0; i < word.length(); ++i) {
            // alphabet: i번째 문자
            char alphabet = word.charAt(i);
            // dist: 'A' 또는 'a'로부터 alphabet까지의 거리
            int dist;

            if (alphabet >= 'A' && alphabet <= 'Z') {
                dist = alphabet - 'A';
                reverseWord[i] = (char) ('Z' - dist);
            } else if (alphabet >= 'a' && alphabet <= 'z') {
                dist = alphabet - 'a';
                reverseWord[i] = (char) ('z' - dist);
            } else {
                reverseWord[i] = alphabet;
            }
        }

        String answer = new String(reverseWord);
        return answer;
    }
}
