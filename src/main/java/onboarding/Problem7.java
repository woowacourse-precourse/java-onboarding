package onboarding;

import java.util.*;


public class Problem7 {

//    @Nested
//    public class Exception {
//        public boolean validator(List < List < String >> friends, List < String > visitors){
//            return (true);
//        }
//
//    }

  public static void find_friend(Map<String, Set<String>> relation, List<List<String>> friends) {
    for (List<String> pair : friends) {
      if (!relation.containsKey(pair.get(0))) {
        Set<String> my_friends = new HashSet<>();
        relation.put(pair.get(0), my_friends);
      }
      relation.get(pair.get(0)).add(pair.get(1));
    }
    for (List<String> pair : friends) {
      if (!relation.containsKey(pair.get(1))) {
        Set<String> my_friends = new HashSet<>();
        relation.put(pair.get(1), my_friends);
      }
      relation.get(pair.get(1)).add(pair.get(0));
    }
  }

  public static void find_visitor(Map<String, Set<String>> relation, List<String> visitors) {
    for (String name : visitors) {
      if (!relation.containsKey(name)) {
        relation.put(name, null);
      }
    }
  }

  public static Map<String, Integer> score_add_ten(String user, Map<String, Set<String>> relation) {
    Map<String, Integer> scoreList = new HashMap<>();
    for (String mutual : relation.get(user)) {
      for (String unknown : relation.get(mutual)) {
        if (!unknown.equals(user)) {
          if (!scoreList.containsKey(unknown)) {
            scoreList.put(unknown, 0);
          }
          int score = scoreList.get(unknown);
          score += 10;
          scoreList.put(unknown, score);
        }
      }
    }
    return scoreList;
  }

  public static void score_add_one(List<String> visitors, Map<String, Integer> scoreList) {
    for (String visit : visitors) {
      if (!scoreList.containsKey(visit)) {
        scoreList.put(visit, 0);
      }
      int score = scoreList.get(visit);
      score++;
      scoreList.put(visit, score);
    }
  }

  public static void removeMutual(String user, Map<String, Set<String>> relation,
      Map<String, Integer> scoreList) {
    for (String name : relation.get(user)) {
      scoreList.remove(name);
    }
  }

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    Map<String, Set<String>> relation = new HashMap<>();
    Map<String, Integer> scoreList;
//        try {
//            throw
//        }
//        catch {
//        }
    find_friend(relation, friends);
    find_visitor(relation, visitors);
    scoreList = score_add_ten(user, relation);
    score_add_one(visitors, scoreList);
    removeMutual(user, relation, scoreList);

    List<String> answer = new ArrayList<>(scoreList.keySet());
    answer.sort(((o1, o2) -> scoreList.get(o2).compareTo(scoreList.get(o1))));
    //5명만 남기는 거 하기
    return answer;
  }

  public static void main(String[] args) {
    String user = "mrko";
    List<List<String>> friends = List.of(
        List.of("donut", "andole"),
        List.of("donut", "jun"),
        List.of("donut", "mrko"),
        List.of("shakevan", "andole"),
        List.of("shakevan", "jun"),
        List.of("shakevan", "mrko")
    );
    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
    System.out.println(solution(user, friends, visitors));
  }
}
