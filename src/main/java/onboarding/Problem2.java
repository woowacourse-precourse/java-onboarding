package onboarding;

public class Problem2 {
    private static int isDuplicate(char first, char second) {
        if (first == second)
            return 1;
        return 0;
    }

    private static boolean checkSentence(String sentence) {
        int sum = 0;
        for (int i = 0; i < sentence.length() - 1; i++) {
            sum += isDuplicate(sentence.charAt(i), sentence.charAt(i+1));
        }
        return sum <= 0;
    }

    private static String makeNonDuplicate(String sentence) {
        for (int i = 0; i < sentence.length() - 1; i++) {
            if (isDuplicate(sentence.charAt(i), sentence.charAt(i+1)) == 1)
                sentence = deleteDuplicate(sentence, i);
        }
        return sentence;
    }

    private static String deleteDuplicate(String sentence, int deleteIdx) {
        String sentenceFirst = sentence.substring(0, deleteIdx);
        String sentenceSecond = sentence.substring(deleteIdx+2);
        sentence = sentenceFirst + sentenceSecond;
        return sentence;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        while (!checkSentence(cryptogram)) {
            cryptogram = makeNonDuplicate(cryptogram);
        }
        answer = cryptogram;
        return answer;
    }
}