package onboarding;

import java.util.*;

import static org.mockito.AdditionalAnswers.answer;

public class Problem7 {

    static class NameScoreComparator implements Comparator<NameScore> {
        @Override
        public int compare(NameScore o1, NameScore o2) {
            if (o1.score == o2.score) {
                return o1.name.compareTo(o2.name);
            }
            else {
                if (o1.score < o2.score) {
                    return 1;
                }
                else if (o1.score > o2.score) {
                    return -1;
                }
                return 0;
            }
        }

    }
    static class NameScore {
        String name;
        int score;

        public NameScore(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, HashSet<String>> connections = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> scores = new HashMap<String, Integer>();

        registerFriends(friends, connections, visitors, scores);
        calculateScore(user, connections, visitors, scores);
        getScoreList(scores, answer);

        // connections.forEach((f, fs) -> {
        //     System.out.println("key : " + f + ", " + "fs : " + fs);
        // });
        String[] str = new String[5];
        List<String> answer5 = new ArrayList<>();
        if(answer.size()>5){

            for (int i = 0; i< 5; i++){
                str[i] = answer.get(i);
                answer5.add(str[i]);
            }
            return answer5;
        }
        return answer;
    }

    private static void getScoreList(HashMap<String, Integer> scores, List<String> answer) {
        ArrayList<NameScore> ns = new ArrayList<>();
        scores.forEach((k, v )-> {
            // System.out.println("key : " + k + ", " + "score : " + v);
            if (v != 0) {
                ns.add(new NameScore(k, v));
            }
        });
        ns.sort(new NameScoreComparator());
        ns.forEach(v -> {
            answer.add(v.name);
            System.out.println(v.name + " , " + v.score);
        });
    }

    private static void calculateScore(String user, HashMap<String, HashSet<String>> connections, List<String> visitors, HashMap<String, Integer> scores) {
        connections.forEach((f, fs) -> {
            if (!f.equals(user) && !connections.get(user).contains(f)) {
                connections.get(f).forEach((e) -> {
                    if (connections.get(user).contains(e)) {
                        int curScore = scores.get(f);
                        scores.put(f, curScore + 10);
                    }
                });
            }
        });

        visitors.forEach(v -> {
            if (!v.equals(user) && !connections.get(user).contains(v)) {
                int curScore = scores.get(v);
                scores.put(v, curScore + 1);
            }
        });
    }

    private static void registerFriends(List<List<String>> friends, HashMap<String, HashSet<String>> connections,
                                        List<String> visitors, HashMap<String, Integer> scores) {
        for (List<String> s : friends) {
            String first = s.get(0);
            String second = s.get(1);
            scores.put(first, 0);
            scores.put(second, 0);


            if (connections.containsKey(first)) {
                HashSet<String> tmp = connections.get(first);
                tmp.add(second);
                connections.put(first, tmp);
            }
            else {
                HashSet<String> tmp = new HashSet<>();
                tmp.add(second);
                connections.put(first, tmp);
            }

            if (connections.containsKey(second)) {
                HashSet<String> tmp = connections.get(second);
                tmp.add(first);
                connections.put(second, tmp);
            }
            else {
                HashSet<String> tmp = new HashSet<>();
                tmp.add(first);
                connections.put(second, tmp);
            }
        }

        for (String v : visitors) {
            scores.put(v, 0);
        }
    }
}