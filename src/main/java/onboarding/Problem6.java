package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        final DuplicateChecker checker = new DuplicateChecker();

        for (List<String> f: forms) {
            Form form = new Form(f.get(0), f.get(1));

            if (!form.validation()) {
                continue;
            }

            checker.registryForm(form);
        }

        ArrayList<String> emailList = checker.getEmailList();
        emailList.sort(Comparator.naturalOrder());

        return emailList;
    }

    private static class DuplicateChecker {
        private final HashMap<String, String> duplicateCheckMap = new HashMap<>();
        private final HashSet<String> dupEmailSet = new HashSet<>();

        public ArrayList<String> getEmailList() {
             return new ArrayList<>(this.dupEmailSet);
        }

        public void registryForm(Form form) {
            for (String part: sliceByLength(form.getNickname(), 2)) {
                this.checkDupPart(part, form);
            }
        }

        private void checkDupPart(String part, Form form) {
            if (this.isDuplicate(part, form)) {
                this.dupEmailSet.add(this.duplicateCheckMap.get(part));
                this.dupEmailSet.add(form.getEmail());
            }
            duplicateCheckMap.put(part, form.getEmail());
        }

        private boolean isDuplicate(String part, Form form) {
            return this.duplicateCheckMap.containsKey(part) && !this.duplicateCheckMap.get(part)
                    .equals(form.getEmail());
        }
    }

    private static class Form {
        private final String email;
        private final String nickname;

        public boolean validation() {
            return this.validationLength();
        }

        private boolean validationLength() {
            return this.nickname.length() > 1;
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

