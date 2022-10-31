package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

  static NameSeparator separator = new NameSeparator();
  static MapFactory factory = new MapFactory();
  static Result result = new Result();

  public static List<String> solution(List<List<String>> forms) {
    List<List<String>> splitNameForms = new ArrayList<>();
    for (List<String> form : forms) {
      splitNameForms.add(separator.split(form));
    }
    Map<String, Set<Integer>> indexMap = factory.generateIndexMap(splitNameForms);
    return result.generateResult(indexMap, forms);
  }

  static class NameSeparator {

    public List<String> split(List<String> form) {
      List<String> result = new ArrayList<>();
      result.add(form.get(0));

      String nickname = form.get(1);
      for (int i = 0; i < nickname.length() - 1; i++) {
        result.add(nickname.substring(i, i + 2));
      }
      return result;
    }
  }

  static class MapFactory {

    public Map<String, Set<Integer>> generateIndexMap(
        List<List<String>> splitNameForms) {
      Map<String, Set<Integer>> result = new HashMap<>();
      for (int index = 0; index < splitNameForms.size(); index++) {
        addIndex(result, splitNameForms.get(index), index);
      }
      return result;
    }

    private void addIndex(Map<String, Set<Integer>> result, List<String> form, int index) {
      for (int i = 1; i < form.size(); i++) {
        String key = form.get(i);
        result.computeIfAbsent(key, s -> new HashSet<>()).add(index);
      }
    }

  }

  static class Result {

    public List<String> generateResult(Map<String, Set<Integer>> indexMap,
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

    private void addEmail(Set<String> result, Set<Integer> indexes,
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
