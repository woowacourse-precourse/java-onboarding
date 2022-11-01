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
                abs = Math.abs(ascii - wordChar[i]); // 아스키 코드값과 현재 알파벳 사이의 차이를 구한 후 소문자 / 대문자를 끝까지 밀고 절대값을 빼주는 방식
                reverse = (ascii + 25) - abs;
                result.append((char) reverse);
            }
            else
                result.append(wordChar[i]); // 알파벳이 아닐 경우, 그대로
        }
        return result.toString();
    }
}
