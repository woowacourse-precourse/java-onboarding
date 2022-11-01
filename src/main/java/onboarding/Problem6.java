package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<User> users = new ArrayList<>();

        for (List<String> form : forms) {
            User tmp = new User();
            for(int i = 0; i < form.size(); i++) {
                if (i == 0) {
                    tmp.setEmail(form.get(i));
                } else {
                    tmp.setUsername(form.get(i));
                }
            }
            users.add(tmp);
        }

        int r = 2;
        Combination comb = new Combination(users.size(), r);
        comb.combination(users, 0, 0, 0);
        ArrayList<ArrayList<User>> result = comb.getResult();

        for (ArrayList<User> userArrayList : result) {
            User user1 = userArrayList.get(0);
            User user2 = userArrayList.get(1);

            String s1 = user1.getUsername();
            String s2 = user2.getUsername();

            if (user1.getCanuse() || user2.getCanuse()) {
                boolean similarity = similarity(s1, s2);
                if (similarity) {
                    user1.setCanuse(false);
                    user2.setCanuse(false);
                }
            }
        }

        for (User user : users) {
            if (!user.getCanuse()) {
                answer.add(user.getEmail());
            }
        }

        //list 정렬
        answer = answer.stream().sorted().collect(Collectors.toList());
        //List를 Set으로 변경
        Set<String> set = new HashSet<String>(answer);
        //Set을 List로 변경
        List<String> newList = new ArrayList<String>(set);

        return newList;
    }

    static class User {
        private String username;
        private String email;
        private boolean canuse;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean getCanuse() {
            return canuse;
        }

        public void setCanuse(boolean canuse) {
            this.canuse = canuse;
        }

        public User() {
            this.canuse = true;
        }

        public User(String username, String email) {
            this.username = username;
            this.email = email;
            this.canuse = true;
        }
    }

    static class Combination {
        private int n;
        private int r;
        private int [] now;
        private ArrayList<ArrayList<User>> result; //모든 조합

        public ArrayList<ArrayList<User>> getResult() {
            return result;
        }

        public Combination(int n, int r) {
            this.n = n;
            this.r = r;
            this.now = new int[r];
            this.result = new ArrayList<ArrayList<User>>();
        }

        public void combination(List<User> arr, int depth, int index, int target) {
            if (depth == r) {
                ArrayList<User> temp = new ArrayList<>();
                for (int i = 0; i < now.length; i++) {
                    temp.add(arr.get(now[i]));
                }
                result.add(temp);
                return;
            }
            if (target == n) return;
            now[index] = target;
            combination(arr, depth + 1, index + 1, target + 1);
            combination(arr, depth, index, target + 1);
        }
    }

    static boolean similarity(String s1, String s2) {
        String longer = s1;
        String shorter = s2;

        if (s1.length() < s2.length()) {
            longer = s2;
            shorter =s1;
        }

        for (int i = 0; i < s1.length() - 1; i++) {
            for (int j = 0; j < s2.length() - 1; j++) {
                if (s1.charAt(i) == s2.charAt(j) && s1.charAt(i + 1) == s2.charAt(j + 1)) {
                    return true;
                }
            }
        }

        return false;

//        int longerLength = longer.length();
//        if (longerLength == 0) return 1.0;

//        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
    }

    static int editDistance(String s1, String s2) {
        //s1, s2 한글 데이터
        int[] costs = new int[s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            int lastValue = i;
            for(int j = 0; j < s2.length(); j++) {
                if (i == 0) {
                    costs[j] = j;
                } else {
                    if (j > 0) {
                        int newValue = costs[j - 1];

                        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                            newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                        }

                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }

            if (i > 0) costs[s2.length()] = lastValue;
        }

        return costs[s2.length()];
    }
}
