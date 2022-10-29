package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder result = new StringBuilder(word);
        String answer = "";

        for (int i = 0; i < result.length(); i++) {
            int left = result.charAt(i);
            if (left>=65&&left<=90)
                answer+= (char)(65+90-left);
            else if (left>=97&&left<=122)
                answer+= (char)(97+122-left);
            else
                answer+=result.charAt(i);
        }
        return answer;
    }
}
