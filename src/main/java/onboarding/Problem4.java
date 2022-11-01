package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] chars = word.toCharArray();
        for(int i = 0 ; i < chars.length; i++){
          char ch =  chars[i];
          chars[i] = convertAlpha(ch); // 알파벳 하나씩 변환
        }
        answer = new String(chars); // 변환된 알파벳이 들어있는 char배열을 문자열로 생성
        return answer;
    }
    
    // 알파벳 변환 함수(아스키 코드 이용)
    private static char convertAlpha(char alpha) {

        if (alpha >= 65 && alpha <= 90) {
          int offset = 25 - (alpha - 'A') * 2;
          return (char) (alpha + offset);
        }
        if (alpha >= 97 && alpha <= 122) {
          int offset = 25 - (alpha - 'a') * 2;
          return (char) (alpha + offset);
        }
        return alpha;
      }
}
