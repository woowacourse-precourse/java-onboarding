package onboarding;

public class Problem4 {

  public static String solution(String word) {
    return convertWord(word);
  }

  static String convertWord(String word) {
    String result = "";
    for (int i = 0; i < word.length(); i++) {
      result += convertChar(word.charAt(i));
    }
    return result;
  }

  static char convertChar(char letter) {
    if(letter>=65&&letter<=90) return (char) (90 - (letter - 65));
    else if(letter>=97&&letter<=122) return (char) (122 - (letter - 97));
    else return letter;
  }
}
