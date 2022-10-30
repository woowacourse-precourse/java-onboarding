package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++) {
            if(!Character.isAlphabetic(word.charAt(i))) {
                answer += word.charAt(i);
                continue;
            }
            char curWord = getReverseOrderString(word.charAt(i));
            answer += convertUpperAndLowerCase(word.charAt(i), curWord);
        }
        return answer;
    }

    private static char convertUpperAndLowerCase(char originalWord, char curWord) {
        return Character.isUpperCase(originalWord) ? Character.toUpperCase(curWord) : Character.toLowerCase(curWord);
    }

    // 알파벳 반대 순서로 변환하는 메서드
    private static char getReverseOrderString(char curCharacter) {
        return (char) ('Z' - (Character.toUpperCase(curCharacter) % 'A'));
    }
}
