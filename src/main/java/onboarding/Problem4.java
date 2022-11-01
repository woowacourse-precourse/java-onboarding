package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0; i<word.length(); i++) {
            char currentCh = word.charAt(i);
            char convertedCh = getConvertedLetter(currentCh);
            answer += convertedCh;
        }

        return answer;
    }

    public static char getConvertedLetter(char ch) {
        if (Character.isUpperCase(ch)) {
            int distanceFromBegin = ch - 'A';
            return (char)((int)'Z' - distanceFromBegin);
        } else if (Character.isLowerCase(ch)) {
            int distanceFromBegin = ch - 'a';
            return (char)((int)'z' - distanceFromBegin);
        }
        return ch;
    }
}

/*
<<요구사항>>
1. 대소문자가 뒤섞인 문자열이 들어온다
2. 알파벳 외의 문자는 변환하지 않고, 알파벳은 표를 따라 뒤집는다.
3. 바뀐 문자열을 리턴한다
 */

/*
<<기능 목록>>
- [V] 문자열의 각 문자를 순회한다
- [V] 알파벳이면 소문자인지 대문자인지 판별한다
- [V] 알파벳을 변환한다
- [V] 알파벳이 아니면 변환하지 않는다
- [V] 변환한 알파벳을 answer에 더한다
 */