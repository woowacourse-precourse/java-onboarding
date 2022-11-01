package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Problem4 {

  public static String solution(String word) {
    return StrAndLstPro4.listToString(new ConvertWordPro4(word).doConvert());
  }
}