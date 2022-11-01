package onboarding;

import java.util.*;

class Form {

    private final String email;
    private final String nickName;
    private Set<String> wordBag;

    public Form(String email, String nickName) {
        this.email = email;
        this.nickName = nickName;
    }

    public String getEmail() {
        return this.email;
    }

    public void makeWordBagFromNickName(int wordLength) {
        wordBag = new HashSet<>();
        int nickNameLength = nickName.length();
        nickNameLength = nickNameLength - wordLength + 1;
        for (int i = 0; i < nickNameLength; i++) {
            wordBag.add(nickName.substring(i, i + wordLength));
        }
    }

    public void setDuplicatedWord(Map<String, Integer> duplicatedCountPerWord) {
        if (wordBag == null || duplicatedCountPerWord == null) {
            return;
        }
        Integer duplicatedCount;
        for (String partialWord : wordBag) {
            if (!duplicatedCountPerWord.containsKey(partialWord)) {
                duplicatedCountPerWord.put(partialWord, 0);
            }
            duplicatedCount = duplicatedCountPerWord.get(partialWord);
            duplicatedCountPerWord.put(partialWord, duplicatedCount + 1);
        }
    }

    public boolean doesHaveDuplicatedWord(Map<String, Integer> duplicatedCountPerWord) {
        if (wordBag == null || duplicatedCountPerWord == null) {
            return false;
        }
        for (String partialWord : wordBag) {
            if (duplicatedCountPerWord.get(partialWord) > 1) {
                return true;
            }
        }
        return false;
    }
}

public class Problem6 {

    private static final int WORD_LENGTH = 2;

    public static List<String> solution(List<List<String>> forms) {
        List<Form> crews = getCrewList(forms);

        Map<String, Integer> duplicatedCountPerWord = getDuplicatedCountPerWord(crews);

        Set<String> emailsOfCrewWhoHasDuplicatedNickName = getEmailsOfCrewWhoHasDuplicatedNickName(
            crews, duplicatedCountPerWord);

        return getSortedEmails(emailsOfCrewWhoHasDuplicatedNickName);
    }

    private static List<Form> getCrewList(List<List<String>> forms) {
        String email, nickName;
        Form newbie;
        List<Form> crews = new LinkedList<>();
        for (List<String> form : forms) {
            email = form.get(0);
            nickName = form.get(1);
            newbie = new Form(email, nickName);
            newbie.makeWordBagFromNickName(WORD_LENGTH);
            crews.add(newbie);
        }
        return crews;
    }

    private static Map<String, Integer> getDuplicatedCountPerWord(List<Form> crews) {
        Map<String, Integer> duplicatedCountPerWord = new HashMap<>();
        for (Form crew : crews) {
            crew.setDuplicatedWord(duplicatedCountPerWord);
        }
        return duplicatedCountPerWord;
    }

    private static Set<String> getEmailsOfCrewWhoHasDuplicatedNickName(List<Form> crews,
        Map<String, Integer> duplicatedCountPerWord) {
        Set<String> emailsOfCrewWhoHasDuplicatedNickName = new HashSet<>();
        for (Form crew : crews) {
            if (crew.doesHaveDuplicatedWord(duplicatedCountPerWord)) {
                emailsOfCrewWhoHasDuplicatedNickName.add(crew.getEmail());
            }
        }
        return emailsOfCrewWhoHasDuplicatedNickName;
    }

    private static List<String> getSortedEmails(Set<String> emailsOfCrewWhoHasDuplicatedNickName) {
        List<String> emails = new LinkedList<>(emailsOfCrewWhoHasDuplicatedNickName);
        Collections.sort(emails);
        return emails;
    }
}
