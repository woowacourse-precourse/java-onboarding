package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    static class StringIterator {
        private StringBuilder sb;
        private int i;
        private int max;
        StringIterator (String init) {
            sb = new StringBuilder(init);
            i = 1;
            max = init.length();
        }

        public String next(){
            if (hasNext()) {
                return sb.substring(i-1, i++);
            }
            return null;
        }

        public boolean hasNext() {
            return max > i;
        }
    }
    private static Map<String,Set<String>> nicknameMap = new HashMap<>();
    private static Set<String> emailSet = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void addPartOfNickToMap(String partOfNickname, String email) {
        Set<String> newEmailSet= new HashSet<>();
        newEmailSet.add(email);
        nicknameMap.put(partOfNickname, newEmailSet);
    }

    private static void addEmailSet(Set<String> newEmailSet) {
        emailSet.addAll(newEmailSet);
    }





}
