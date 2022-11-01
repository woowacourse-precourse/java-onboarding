package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int maxCapital = (int) "A".charAt(0) + (int) "Z".charAt(0);
        int maxLow = (int) "a".charAt(0) + (int) "z".charAt(0);

        String answer = "";
        for (String s : word.split("")) {
            int ascii = (int) s.charAt(0);
            if (isCapital(ascii) == "C") {
                int new_ascii = maxCapital - ascii;
                answer += (char) new_ascii;
            } else if (isCapital(ascii) == "L") {
                int new_ascii = maxLow - ascii;
                answer += (char) new_ascii;
            } else {
                answer += s;
            }
        }


        return answer;
    }

    private static String isCapital(int ascii) {
        if (ascii >= 65 && ascii <= 90) {
            return "C";
        }
        if (ascii >= 97 && ascii <= 122) {
            return "L";
        }
        return "N";
    }
}