package onboarding;

class WordForPro4 {

  private static final int MINIMUM_LENGTH = 1;
  private static final int MAXIMUM_LENGTH = 1000;
  private static final int TOTAL_NUM_1 = 219;
  private static final int TOTAL_NUM_2 = 155;

  private final char[] charArr;

  public WordForPro4(String word) {
    validateWord(word);
    this.charArr = word.toCharArray();
  }

  private void validateWord(String word) {
    if (word.length() < MINIMUM_LENGTH || MAXIMUM_LENGTH < word.length()) {
      throw new IllegalArgumentException(
          "word의 길이는 " + MINIMUM_LENGTH + "이상 " + MAXIMUM_LENGTH + "이하의 정수여야 합니다.");
    }
  }

  public String convertString() {
    for (int i = 0; i < charArr.length; i++) {
      if ('a' <= charArr[i] && charArr[i] <= 'z') {
        charArr[i] = convertAlpha(TOTAL_NUM_1, charArr[i]);
      } else if ('A' <= charArr[i] && charArr[i] <= 'Z') {
        charArr[i] = convertAlpha(TOTAL_NUM_2, charArr[i]);
      }
    }
    return String.valueOf(charArr);
  }

  private char convertAlpha(int totalNum, char alpha) {
    return (char) (totalNum - (int) alpha);
  }
}

public class Problem4 {

  public static String solution(String word) {
    WordForPro4 wordClass = new WordForPro4(word);
    return wordClass.convertString();
  }
}
