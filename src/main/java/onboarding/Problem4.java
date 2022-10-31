package onboarding;

public class Problem4 {

  public static String solution(String word) {
    String answer = "";
    answer = getAnswer(word);
    return answer;
  }

  public static String getAnswer(String word){
    char[] chars = word.toCharArray();
    for(int i = 0 ; i < chars.length; i++){
      char ch =  chars[i];
      chars[i] = convertAlpha(ch);
    }
    return new String(chars);
  }

  public static char convertAlpha(char alpha) {

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
