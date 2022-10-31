package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> two_letters_map = new HashMap<>();
        TreeSet<String> duplicated_set = new TreeSet<>();

        for(List<String> user: forms) {
            HashSet<String> temp_two_letters_set = new HashSet<>();
            String nickname = user.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                temp_two_letters_set.add(nickname.substring(i, i+2));
            }
            for(String two_letters: temp_two_letters_set) {
                if (two_letters_map.containsKey(two_letters)) {
                    duplicated_set.add(user.get(0));
                    duplicated_set.add(two_letters_map.get(two_letters));
                } else {
                    two_letters_map.put(two_letters, user.get(0));
                }
            }
        }
        return new ArrayList<>(duplicated_set);
    }
}
