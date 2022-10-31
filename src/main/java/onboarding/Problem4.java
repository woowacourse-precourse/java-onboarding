package onboarding;

public class Problem4 {
    public static String solution(String word) {
        validate(word);
        String answer = "";
        answer = sayFrog(word.toCharArray());
        return answer;
    }

    private static String sayFrog(char[] charsInWord) {
        char[] result = new char[charsInWord.length];
        int idx = 0;
        for (char each : charsInWord) {
            if (Character.isLowerCase(each)) {
                result[idx] = ((char) (97+122 - (int) each));
            } else if (Character.isUpperCase(each)) {
                result[idx] = ((char) (155 - (int) each));
            } else {
                result[idx] = (each);
            }
            idx += 1;
        }
        return new String(result);
    }

    private static void validate(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            System.out.println("입력값의 길이가 잘못되었습니다");
        }
    }
}
