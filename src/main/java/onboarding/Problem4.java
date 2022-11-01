package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        answer = reverse(word);
        
        return answer;
    }

    private static String reverse(String word) {
        StringBuilder sb = new StringBuilder();

        for (int w=0; w<word.length(); w++) {
            char nowChar = word.charAt(w);

            if (nowChar>='A' && nowChar<='Z')
                sb.append((char)((char)155 - nowChar));
            else if (nowChar>='a' && nowChar<='z')
                sb.append((char)((char)219 - nowChar));
            else
                sb.append(nowChar);
        }

        return sb.toString();
    }
}
