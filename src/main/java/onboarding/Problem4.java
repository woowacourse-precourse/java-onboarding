package onboarding;

public class Problem4 {
    public static String solution(String word) { // 사전 반전순으로 일치하도록
        char[] wordChar = word.toCharArray();
        StringBuilder result = new StringBuilder(); // String 조작을 위해서
        int ascii = 0, abs, reverse = 0;

        for (int i = 0; i < word.length(); i++)
        {
            if (Character.isUpperCase(wordChar[i]) || Character.isLowerCase(wordChar[i])) // 알파벳일 경우만
            {
                if (Character.isUpperCase(wordChar[i])) // 대문자일 경우, ascii 'A'의 코드번호
                    ascii = 65;
                else if (Character.isLowerCase(wordChar[i])) // 소문자일 경우, ascii 'a'의 코드번호
                    ascii = 97;
            }
        }
    }
}
