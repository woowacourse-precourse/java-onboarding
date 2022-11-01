package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    return StrAndLstPro4.listToString(new ConvertWordPro4(word).doConvert());
  }
}