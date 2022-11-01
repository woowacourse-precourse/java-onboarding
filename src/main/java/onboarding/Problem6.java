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

        for (int i = 0; i < crewSize; i++) {
            String nick = crews[i].getNick();
            crewNickMap = updateMap(nick, crewNickMap);
        }
        return crewNickMap;
    }

    private static HashMap<String, Integer> updateMap(String nick, HashMap<String, Integer> crewNickMap) {

        int nickSize = crewNickMap.size();
        List<String> keys = new ArrayList<>(crewNickMap.keySet());

        for (int j = 0; j < nickSize; j++) {
            String key = keys.get(j);

            int count = (nick.contains(key)) ? crewNickMap.get(key) + 1 : crewNickMap.get(key);
            crewNickMap.replace(key, count);
        }

        return crewNickMap;
    }

    private static List<String> getEmails(User[] crews, HashMap<String, Integer> crewNickMap) {

        List<String> emails = new ArrayList<>();
        List<String> keys = new LinkedList<>(crewNickMap.keySet());

        int keySize = keys.size();

        for (int i = 0; i < keySize; i++) {
            String key = keys.get(i);
            emails = updateEmail(emails, crews, key, crewNickMap);
        }

        return emails;
    }

    private static List<String> updateEmail(List<String> emails, User[] crews, String key, HashMap<String, Integer> crewNickMap) {

        int crewSize = crews.length;

        for (int i = 0; i < crewSize; i++) {
            User crew = crews[i];

            String nick = crew.getNick();
            String email = crew.getEmail();

            boolean checkKey = nick.contains(key) && crewNickMap.get(key) > 1;
            boolean checkEmail = emails.contains(email);

            if (checkKey && !checkEmail) emails.add(email);
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
            duplicateMap = getNickKeys(nick, duplicateMap);
        }

        return duplicateMap;
    }

    private static HashMap<String, Integer> getNickKeys(String nick, HashMap<String, Integer> duplicateMap) {
        int nickLength = nick.length();

        for (int j = 0; j < nickLength - 1; j++) {
            String twoLetters = nick.substring(j, j + 2);

            if (duplicateMap.containsKey(twoLetters)) {
                continue;
            }
            duplicateMap.put(twoLetters, 0);
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
