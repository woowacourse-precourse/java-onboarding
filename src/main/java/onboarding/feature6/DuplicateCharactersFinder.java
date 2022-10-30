package onboarding.feature6;

import java.util.*;

public class DuplicateCharactersFinder {
    private String duplicateLetters = "";
    private String currentNickname;
    private String currentEmail;
    private String nextNickname;
    private String nextEmail;
    
    private int increment = 2;
    private int initialNicknamesSize;

    private List<String> initialEmails;
    private List<String> initialNicknames;
    private Map<String, Set<String>> result = new HashMap<>();

    public DuplicateCharactersFinder(UserInfo userInfo) {
        initialEmails = userInfo.getEmails();
        initialNicknames = userInfo.getNicknames();
        initialNicknamesSize = initialNicknames.size();
    }

    public List<String> getFilteredEmails (Map<String, Set<String>> result) {
        List<String> setToList = new ArrayList<>(result.get(duplicateLetters));
        List<String> idsSorted = new ArrayList<>();
        List<String> emailsSorted = new ArrayList<>();

        for (String email : setToList) {
            idsSorted.add(email.split("@")[0]);
        }
        Collections.sort(idsSorted);
        for (String id : idsSorted) {
            for (String email : setToList) {
                if (id.equals(email.split("@")[0])) {
                    int index = setToList.indexOf(email);
                    emailsSorted.add(setToList.get(index));
                }
            }
        }
        return emailsSorted;
    }

    /*
    * The method below🔻 could return more than two pairs of key and value
    * if given nicknames share several cases of adjacent duplicate letters.
    */
    public Map<String, Set<String>> getDuplicateLetters() {
        for (int i = 0; i < initialNicknamesSize - 1; i++) {
            currentNickname = initialNicknames.get(i);
            currentEmail = initialEmails.get(i);
            for (int j = i + 1; j < initialNicknamesSize; j++) {
                nextNickname = initialNicknames.get(j);
                nextEmail = initialEmails.get(j);
                System.out.println("닉네임 - " + currentNickname + " " + nextNickname + " 비교");
                compareNicknames(currentNickname, nextNickname);
            }
        }

        /*
         * Because the given test case has only one case of adjacent duplicate letters ('제이'),
         * it returns only one pair of key and value.
         * {제이=[jason@email.com, jm@email.com, mj@email.com]}
         */
        return result;
    }

    public void compareNicknames(String CurrentNickname, String nextNickname) {
        for (int m = 0; m < currentNickname.length() - 1; m++) {
            String lettersOfCurrentNickname = CurrentNickname.substring(m, m + increment);
            for (int n = 0; n < nextNickname.length() - 1; n++) {
                String lettersOfNextNickname = nextNickname.substring(n, n + increment);
                System.out.println("글자: " + lettersOfCurrentNickname + " " + lettersOfNextNickname + " 비교");
                if (lettersOfCurrentNickname.equals(lettersOfNextNickname)) {
                    System.out.println("글자 같음: " + lettersOfCurrentNickname);
                    duplicateLetters = lettersOfCurrentNickname;
                    if (result.containsKey(duplicateLetters)) {
                        System.out.println(duplicateLetters + " key는 이미 result에 존재하기 때문에 " + currentEmail + "과 " + nextEmail +"을 추가만 합니다.");
                        Set<String> existingFilteredEmails = result.get(duplicateLetters);
                        existingFilteredEmails.add(currentEmail);
                        existingFilteredEmails.add(nextEmail);
                        result.replace(duplicateLetters, existingFilteredEmails);
                        continue;
                    }
                    Set<String> filteredEmails = new HashSet<>();
                    filteredEmails.add(currentEmail);
                    filteredEmails.add(nextEmail);
                    System.out.println(duplicateLetters + "를 새로운 key로 result에 " + currentEmail + "과 " + nextEmail +"을 등록합니다.");
                    result.put(duplicateLetters, filteredEmails);
                }
            }
        }
    }
}
