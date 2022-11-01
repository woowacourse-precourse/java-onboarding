package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>(Collections.emptyList());
        HashMap<String, List<Integer>> chunk_dict = new HashMap<>();

        putChunkDict(chunk_dict, forms);

        List<String> keys = new ArrayList<>(chunk_dict.keySet());

        addEmailToAnswer(keys, chunk_dict, answer, forms);

        Set<String> emailSet = new HashSet<>(answer);
        answer = new ArrayList<>(emailSet);
        Collections.sort(answer);
        return answer;
    }
    public static void putChunkDict(HashMap<String, List<Integer>> chunk_dict, List<List<String>> forms) {
        for (int ind = 0; ind < forms.size(); ind++) {
            String nickname = forms.get(ind).get(1);
            for (int chunkIndex = 0; chunkIndex < nickname.length()-1; chunkIndex++) {
                String chunk = nickname.substring(chunkIndex, chunkIndex + 2);
                if (chunk_dict.containsKey(chunk)) {
                    chunk_dict.get(chunk).add(ind);
                } else {
                    chunk_dict.put(chunk, new ArrayList<>(Arrays.asList(ind)));
                }
            }
        }
    }

    public static void addEmailToAnswer(List<String> keys, HashMap<String, List<Integer>> chunk_dict, List<String> answer, List<List<String>> forms) {
        for (String key : keys) {
            if (chunk_dict.get(key).size() > 1) {
                for (int index : chunk_dict.get(key)) {
                    answer.add(forms.get(index).get(0));
                }
            }
        }
    }
}
