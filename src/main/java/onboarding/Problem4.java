package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ConvertWordPro4 {

  public static final int MIN_WORD_LENGTH = 1;
  public static final int MAX_WORD_LENGTH = 1000;

  private final String word;

  public ConvertWordPro4(String word) {
    validateWord(word);
    this.word = word;
  }

  public void validateWord(String word) {
    if (word.length() < MIN_WORD_LENGTH || word.length() > MAX_WORD_LENGTH) {
      throw new IllegalArgumentException(
          "Please enter a word between " + MIN_WORD_LENGTH
              + " and " + MAX_WORD_LENGTH + " in length."
      );
    }
  }

  public static char foldAlpha(Character c) {
    int move = 0;
    if (c == ' ') {
      move = ' ';
    } else if (c >= 'A' && c <= 'Z') {
      move = 'M' + 'N' - c;
    } else if (c >= 'a' && c <= 'z') {
      move = 'm' + 'n' - c;
    }
    return (char) move;
  }

  public List<Character> doConvert() {
    return StrAndLstPro4.stringToList(this.word).stream()
        .map(ConvertWordPro4::foldAlpha)
        .collect(Collectors.toList());
  }
}

class StrAndLstPro4 {

  public static List<Character> stringToList(String string) {
    List<Character> list = new ArrayList<>();
    for (int i = 0; i < string.length(); i++) {
      list.add(string.charAt(i));
    }
    return list;
  }

  public static String listToString(List<Character> list) {
    StringBuilder build = new StringBuilder();
    for (Character character : list) {
      build.append(character);
    }
    return (build.toString());
  }
}

public class Problem4 {

  public static String solution(String word) {
    ConvertWordPro4 answer = new ConvertWordPro4(word);
    return StrAndLstPro4.listToString(answer.doConvert());
  }
}