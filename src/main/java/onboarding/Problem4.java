package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuffer sb = new StringBuffer();

        // 문자열을 char 배열로 나눈다.
        char[] arr = word.toCharArray();
        // 배열을 반복한다.
        for(char c : arr){

        // 소문자 대문자를 구문한다. a-z A-Z
            if('a'<=c&&c<='z'){
                int t = 'a'-c;
                sb.append(String.valueOf((char)('z'+t)));
            }else if('A'<=c&&c<='Z'){
                int t = 'A'-c;
                sb.append(String.valueOf((char)('Z'+t)));
            }else{//32 공백일 경우.
                sb.append(" ");
            }
        }
        // 문자를 반전한다. 역으로된 z-a Z-A 에서 탐색.

        return sb.toString();
    }
}
