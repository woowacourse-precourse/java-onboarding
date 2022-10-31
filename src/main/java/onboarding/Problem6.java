package onboarding;

import java.util.*;

public class Problem6 {
    private static final Problem6 problem = new Problem6();

    public static List<String> solution(List<List<String>> forms) {
        Set<String> pool = new HashSet<>();
        Set<String> duplicated = new HashSet<>();
        Set<String> answer_set = new HashSet<>();

        for(List<String> crew : forms) {
            problem.candidating(pool, duplicated, crew.get(1));
        }

        for(List<String> crew : forms) {
            if(problem.isDuplicated(duplicated, crew.get(1))) {
                answer_set.add(crew.get(0));
            }
        }

        List<String> answer = new ArrayList<>(answer_set);
        answer.sort(String.CASE_INSENSITIVE_ORDER);

        return answer;
    }

    private void candidating(Set<String> pool, Set<String> duplicated, String name) {
        for(int i = 0; i < name.length() - 1; i++) {
            String candidate = getDuo(name, i);
            if(pool.contains(candidate)) {
                duplicated.add(candidate);
            }
            else{
                pool.add(candidate);
            }
        }
    }

    private String getDuo(String name, int at) {
        StringBuilder sb = new StringBuilder();
        sb.append(name.charAt(at));
        sb.append(name.charAt(at + 1));
        return sb.toString();
    }

    private boolean isDuplicated(Set<String> duplicated, String name) {
        for(int i = 0; i < name.length() - 1; i++) {
            String candidate = getDuo(name, i);
            if(duplicated.contains(candidate)) {
                return true;
            }
        }
        return false;
    }
}
