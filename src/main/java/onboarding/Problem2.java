package onboarding;

public class Problem2 {
    static String answer;

    public static String solution(String cryptogram) {
        answer = cryptogram;
        deleteDuplicate(answer);
        return answer;
    }

    /*
        duplicateWord가 비어있는 문자열("")이라면
        연속적인 알파벳이 없다.
         */
    public static void deleteDuplicate(String input) {
        String duplicateWord = findDuplicate(input);
        if (!duplicateWord.equals("")) {
            answer = answer.replaceAll(duplicateWord, "");
            deleteDuplicate(answer);
        }
    }
}
