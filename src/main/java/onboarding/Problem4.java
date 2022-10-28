package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        StringBuilder stringBuilder = new StringBuilder();
        int temp;
        for (int i = 0; i < word.length(); i++) {
            temp = word.charAt(i);

            if ((65 <= temp) && (temp <= 90)) {
                // 대문자인 경우
                stringBuilder.append((char) changeUpperCase(temp));
            } else if ((97 <= temp) && (temp <= 122)) {
                // 소문자인 경우
                stringBuilder.append((char) changeLowerCase(temp));
            } else {
                // 외의 문자인 경우
                stringBuilder.append((char) temp);
            }
        }

        answer = stringBuilder.toString();

        return answer;
    }

    static int changeUpperCase(int temp) {
        return 155 - temp;
    }

    static int changeLowerCase(int temp) {
        return 219 - temp;
    }
}
