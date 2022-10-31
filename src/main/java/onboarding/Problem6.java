package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        final DupCheckMap dupCheckMap = new DupCheckMap();

        for (List<String> f: forms) {
            Form form = new Form(f.get(0), f.get(1));

            if (form.isPass()) {
                continue;
            }

           dupCheckMap.registryForm(form);
        }

        ArrayList<String> answer = new ArrayList<>(dupCheckMap.dupEmailSet);
        answer.sort(Comparator.naturalOrder());

        return answer;
    }

    private static class DupCheckMap extends HashMap<String, String> {
        HashMap<String, String> duplicateCheckMap = new HashMap<>();
        final HashSet<String> dupEmailSet = new HashSet<>();

        public void registryForm(Form form) {
            for (String part: sliceByLength(form.getNickname(), 2)) {
                if (this.isDuplicate(part, form)) {
                    this.dupEmailSet.add(this.duplicateCheckMap.get(part));
                    this.dupEmailSet.add(form.getEmail());
                }
                duplicateCheckMap.put(part, form.getEmail());
            }
        }

        private boolean isDuplicate(String part, Form form) {
            return this.duplicateCheckMap.containsKey(part) && !this.duplicateCheckMap.get(part)
                    .equals(form.getEmail());
        }
    }

    private static class Form {
        private final String email;
        private final String nickname;

        public boolean isPass() {
            return this.nickname.length() == 1;
        }

        public Form(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }
        public String getNickname() {
            return nickname;
        }
    }

    private static List<String> sliceByLength(String str, Integer len) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= str.length() - len; i++) {
            result.add(str.substring(i, i + len));
        }

        return result;
    }
}

