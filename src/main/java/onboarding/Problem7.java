package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

class Friend {

  String user;
  List<List<String>> friends = new ArrayList<>();
  List<String> visitors = new ArrayList<>();
  private HashMap<String, HashSet<String>> relationTable = new HashMap<>();
  private HashMap<String, Integer> scoreTable = new HashMap<>();

  Friend(String user, List<List<String>> friends, List<String> visitors) {
    ValidityCheckerProb7 vc = new ValidityCheckerProb7(user, friends, visitors);
    RelationMaker rm = new RelationMaker(friends, visitors);
    this.friends = friends;
    this.visitors = visitors;
    this.user = user;
    relationTable = rm.makeRelationTable();
    scoreTable = makeScoreTable();
  }

  private HashMap<String, Integer> makeScoreTable() {
    for (List<String> friend : friends) {
      scoreTable.put(friend.get(0), 0);
      scoreTable.put(friend.get(1), 0);
    }
    for (String visitor : visitors) {
      scoreTable.put(visitor, 0);
    }
    return scoreTable;
  }

  List<String> getAnswer() {
    ScoreCalculator sc = new ScoreCalculator(user, visitors, relationTable, scoreTable);
    if (!relationTable.containsKey(user)) {
      List<String> ExceptionCase = new ArrayList<>();
      HashMap<String, Integer> exceptionTable = new HashMap<>();
      for (String visitor : visitors) {
        if (!exceptionTable.containsKey(visitor)) {
          exceptionTable.put(visitor, 1);
        }
        if (exceptionTable.containsKey(visitor)) {
          int score = exceptionTable.get(visitor);
          exceptionTable.put(visitor, score + 1);
        }
      }
      if (exceptionTable.containsKey(user)) {
        throw new IllegalArgumentException("user is in visitor list");
      }
      List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(
          exceptionTable.entrySet());
      Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {

        public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
          int res = obj2.getValue() - obj1.getValue();
          if (res != 0) {
            return res;
          }
          return obj1.getKey().compareTo(obj2.getKey());
        }
      });

      for (int i = 0; i < list_entries.size(); i++) {
        ExceptionCase.add(list_entries.get(i).getKey());
        if (i == 4) {
          break;
        }
      }
      return (ExceptionCase);
    }
    return sc.calculateScore();
  }

}

class RelationMaker {

  private List<List<String>> friends;
  private List<String> visitors;

  RelationMaker(List<List<String>> friends, List<String> visitors) {
    this.friends = friends;
    this.visitors = visitors;
  }

  HashMap<String, HashSet<String>> makeRelationTable() {
    HashMap<String, HashSet<String>> relationTable = new HashMap<>();
    for (List<String> friend : friends) {
      if (!relationTable.containsKey(friend.get(0))) {
        HashSet<String> nameSet = new HashSet<>();
        nameSet.add(friend.get(1));
        relationTable.put(friend.get(0), nameSet);
      }
      if (!relationTable.containsKey(friend.get(1))) {
        HashSet<String> nameSet = new HashSet<>();
        nameSet.add(friend.get(0));
        relationTable.put(friend.get(1), nameSet);
      }
      relationTable.get(friend.get(0)).add(friend.get(1));
      relationTable.get(friend.get(1)).add(friend.get(0));
    }
    return relationTable;
  }
}

class ValidityCheckerProb7 {

  ValidityCheckerProb7(String user, List<List<String>> friends, List<String> visitors) {
    userValidityCheck(user);
    friendsValidityCheck(friends);
    visitorsValidityCheck(visitors);
    checkDuplicateRelations(friends);
  }

  private void checkDuplicateRelations(List<List<String>> friends) {
    HashSet<String> duplicateCheckSet = new HashSet<>();
    for (List<String> friend : friends) {
      String added1 = friend.get(0) + "/" + friend.get(1);
      String added2 = friend.get(1) + "/" + friend.get(0);
      if (duplicateCheckSet.contains(added1) == true
          || duplicateCheckSet.contains(added2) == true) {
        throw new IllegalArgumentException("Duplicate friends relation is included. ");
      }
      duplicateCheckSet.add(added1);
      duplicateCheckSet.add(added2);
    }
  }

  private void userValidityCheck(String user) {
    if (user.length() < 1 || user.length() > 30) {
      throw new IllegalArgumentException("User's length out of range");
    }
  }

  private void friendsValidityCheck(List<List<String>> friends) {
    if (friends.size() < 1 || friends.size() > 30) {
      throw new IllegalArgumentException("friends length out of range.");
    }
    for (List<String> namePair : friends) {
      if (namePair.size() != 2) {
        throw new IllegalArgumentException("friends not consist of pairs.");
      }
      if (namePair.get(0).length() < 1 || namePair.get(0).length() > 30) {
        throw new IllegalArgumentException("id length out of range.");
      }
      if (!Pattern.matches("^[a-zA-Z]*$", namePair.get(0))
          || !Pattern.matches("^[a-zA-Z]*$", namePair.get(1))) {
        throw new IllegalArgumentException("id consists of input not in English.");
      }
      if (!Pattern.matches("^[a-z]*$", namePair.get(0))
          || !Pattern.matches("^[a-z]*$", namePair.get(1))) {
        throw new IllegalArgumentException("id has uppercase.");
      }
    }
  }

  private void visitorsValidityCheck(List<String> visitors) {
    for (String visitor : visitors) {
      if (visitor.length() < 0 || visitor.length() > 10000) {
        throw new IllegalArgumentException("visitors length out of range.");
      }
    }
  }
}

class ScoreCalculator {

  String user;
  private HashMap<String, HashSet<String>> relationTable = new HashMap<>();
  private HashMap<String, Integer> scoreTable = new HashMap<>();
  List<String> visitors;

  ScoreCalculator(String user, List<String> visitors,
      HashMap<String, HashSet<String>> relationTable, HashMap<String, Integer> scoreTable) {
    this.visitors = visitors;
    this.relationTable = relationTable;
    this.scoreTable = scoreTable;
    this.user = user;
  }

  List<String> calculateScore() {
    List<String> answer = new ArrayList<>();
    for (String visitor : visitors) {
      if (scoreTable.containsKey(visitor)) {
        int score = scoreTable.get(visitor);
        score++;
        scoreTable.put(visitor, score);
      }
      if (!scoreTable.containsKey(visitor)) {
        scoreTable.put(visitor, 1);
      }
    }
    for (String iter : relationTable.get(user)) {
      HashSet<String> userFriendsFriend = new HashSet<>();
      userFriendsFriend = relationTable.get(iter);
      for (String iter2 : userFriendsFriend) {
        int score = scoreTable.get(iter2);
        scoreTable.put(iter2, score + 10);
      }
    }
    scoreTable.remove(user);
    for (String iter : relationTable.get(user)) {
      scoreTable.remove(iter);
    }
    List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(
        scoreTable.entrySet());
    Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
      public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
        int res = obj2.getValue() - obj1.getValue();
        if (res != 0) {
          return res;
        }
        return obj1.getKey().compareTo(obj2.getKey());
      }
    });
    for (int i = 0; i < list_entries.size(); i++) {
      answer.add(list_entries.get(i).getKey());
      if (i == 4) {
        break;
      }
    }
    return answer;
  }
}

public class Problem7 {

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    Friend friend = new Friend(user, friends, visitors);
    return (friend.getAnswer());
  }
}

