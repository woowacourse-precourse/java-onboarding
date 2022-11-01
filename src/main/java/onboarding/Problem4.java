package onboarding;

public class Problem4 {

  public static String solution(String word) {
    String reversedWord = "";
    for (int i = 0; i < word.length(); i++) {
      char singleWord = reverse(word.charAt(i));
      reversedWord += singleWord;
    }
    return reversedWord;
  }

  private static char reverse(char singleWord) {
    if ((65 <= singleWord) && (singleWord <= 90)) {
      return (char) (singleWord + 25 - 2 * (singleWord - 65));
    } else if ((97 <= singleWord) && (singleWord <= 122)) {
      return (char) (singleWord + 25 - 2 * (singleWord - 97));
    }
    return singleWord;
  }
}
