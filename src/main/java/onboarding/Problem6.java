package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    List<List<String>> parsingForms = new ArrayList<>();
    for (List<String> form : forms) {
      parsingForms.add(Converter.convert(form));
    }
    Map<String, Set<Integer>> indexMap = Factory.generateDuplicationIndexMap(parsingForms);
    return Result.generateResult(indexMap, forms);
  }

  static class Converter {

    public static List<String> convert(List<String> form) {
      List<String> result = new ArrayList<>();
      result.add(form.get(0));

      String nickname = form.get(1);
      for (int i = 0; i < nickname.length() - 1; i++) {
        result.add(nickname.substring(i, i + 2));
      }
      return result;
    }
  }

  static class Factory {

    public static Map<String, Set<Integer>> generateDuplicationIndexMap(
        List<List<String>> parsingForms) {
      Map<String, Set<Integer>> result = new HashMap<>();
      for (int index = 0; index < parsingForms.size(); index++) {
        addIndex(result, parsingForms.get(index), index);
      }
      return result;
    }

    private static void addIndex(Map<String, Set<Integer>> result, List<String> form, int index) {
      for (int i = 1; i < form.size(); i++) {
        String key = form.get(i);
        Set<Integer> indexes = result.getOrDefault(key, new HashSet<>());
        indexes.add(index);
        result.put(key, indexes);
      }
    }

  }

  static class Result {

    public static List<String> generateResult(Map<String, Set<Integer>> indexMap,
        List<List<String>> forms) {
      Set<String> resultSet = new HashSet<>();
      for (String key : indexMap.keySet()) {
        Set<Integer> indexes = indexMap.get(key);
        addEmail(resultSet, indexes, forms);
      }
      List<String> result = new ArrayList<>(resultSet);
      Collections.sort(result);
      return result;
    }

    private static void addEmail(Set<String> result, Set<Integer> indexes,
        List<List<String>> forms) {
      if (indexes.size() <= 1) {
        return;
      }
      for (Integer index : indexes) {
        result.add(forms.get(index).get(0));
      }
    }
  }
}
