package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        User[] crew = inItUsers(forms);
        HashMap<String, Integer> crewNickMap = getCandidateNicks(crew);
        answer = checkUsers(crew, crewNickMap);
        Collections.sort(answer);

        return answer;
    }

    private static HashMap<String, Integer> getDuplicateNicks(User[] crews, HashMap<String, Integer> crewNickMap) {

        int crewSize = crews.length;
        int nickSize = crewNickMap.size();
        List<String> keys = new ArrayList<>(crewNickMap.keySet());

        for (int i = 0; i < crewSize; i++) {
            String nick = crews[i].getNick();

            for (int j = 0; j < nickSize; j++) {
                String key = keys.get(j);
                if (nick.contains(key)) {
                    int count = crewNickMap.get(key) + 1;
                    crewNickMap.replace(key, count);
                }
            }
        }
        return crewNickMap;
    }

    private static List<String> getEmails(User[] crews, HashMap<String, Integer> crewNickMap) {

        int crewSize = crews.length;
        List<String> emails = new ArrayList<>();
        List<String> keys = new LinkedList<>(crewNickMap.keySet());

        int keySize = keys.size();

        for (int i = 0; i < keySize; i++) {
            String key = keys.get(i);

            for (int j = 0; j < crewSize; j++) {
                String nick = crews[j].getNick();

                if (nick.contains(key) && crewNickMap.get(key) > 1) {
                    String email = crews[j].getEmail();

                    if (emails.contains(email)) continue;

                    emails.add(email);
                }
            }
        }

        return emails;
    }

    private static List<String> checkUsers(User[] crews, HashMap<String, Integer> crewNickMap) {

        List<String> checkedEmails;

        crewNickMap = getDuplicateNicks(crews, crewNickMap);

        checkedEmails = getEmails(crews, crewNickMap);

        return checkedEmails;
    }

    private static HashMap<String, Integer> getCandidateNicks(User[] crews) {

        int size = crews.length;
        HashMap<String, Integer> duplicateMap = new HashMap<>();

        for (int i = 0; i < size; i++) {

            String nick = crews[i].getNick();
            int nickLength = nick.length();

            for (int j = 0; j < nickLength - 1; j++) {
                String twoLetters = nick.substring(j, j + 2);

                if (duplicateMap.containsKey(twoLetters)) {
                    continue;
                }
                duplicateMap.put(twoLetters, 0);
            }
        }

        return duplicateMap;
    }

    private static User[] inItUsers(List<List<String>> forms) {

        int size = forms.size();
        int emailIndex = 0;
        int nickIndex = 1;

        User[] crew = new User[size];
        for (int i = 0; i < size; i++) {
            List<String> user = forms.get(i);

            String email = user.get(emailIndex);
            String nick = user.get(nickIndex);

            crew[i] = new User(email, nick);
        }

        return crew;
    }

    private static class User {
        String email;
        String nick;

        private User(String email, String nick) {
            this.email = email;
            this.nick = nick;
        }

        private String getEmail() {
            return email;
        }

        private String getNick() {
            return nick;
        }
    }

}
