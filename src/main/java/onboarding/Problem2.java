package onboarding;

public class Problem2 {
    private static final String EMPTY_STRING = "";
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean isDecoding = false;

        do {
            if (answer.length() < 1) {
                break;
            }
            isDecoding = false;
            String temp = EMPTY_STRING;
            char lastChar = answer.charAt(0);
            int sameCount = 0;

            for (int i = 1; i < answer.length(); ++i) {
                char tempChar = answer.charAt(i);

                if (lastChar == tempChar) {
                    ++sameCount;
                    continue;
                }

                if (sameCount == 0) {
                    temp += lastChar;
                }

                sameCount = 0;
                lastChar = tempChar;
            }

            if (sameCount == 0) {
                temp += lastChar;
            }

            if (answer.length() != temp.length()) {
                isDecoding = true;
                answer = temp;
            }
        } while (isDecoding);

        return answer;
    }
}
