package onboarding.feature6;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateFinder {
    private Set<String> duplicateLetters = new HashSet<>();

    private int indexI;
    private int indexJ;
    private int indexM;
    private int indexN;
    private int increment = 2;

    private List<String> initialEmails;
    private List<String> initialNicknames;

    private Map<String, List<String>> result = new HashMap<>();

    public DuplicateFinder(UserInfo userInfo) {
        initialEmails = userInfo.getEmails();
        initialNicknames = userInfo.getNicknames();
    }

    public void findDuplicates() {
        for (indexI = 0; indexI < initialNicknames.size() - 1; indexI++) {
            for (indexJ = indexI + 1; indexJ < initialNicknames.size(); indexJ++) {
                System.out.println("닉네임 - " + initialNicknames.get(indexI) + " " + initialNicknames.get(indexJ) + " 비교");
                checkNicknames(initialNicknames.get(indexI), initialNicknames.get(indexJ));
            }
        }
        for (String duplicateLetter : duplicateLetters) {
            List<String> filteredEmails = new ArrayList<>();
            for (int i = 0; i < initialNicknames.size(); i++) {
                if (initialNicknames.get(i).contains(duplicateLetter)) {
                    filteredEmails.add(initialEmails.get(i));
                }
                result.put(duplicateLetter, filteredEmails);
            }
        }
        System.out.println(result);
    }

    public void checkNicknames(String currentNickname, String nextNickname) {
        for (indexM = 0; indexM < currentNickname.length() - 1; indexM++) {
            for (indexN = 0; indexN < nextNickname.length() - 1; indexN++) {
                compareLettersOfNickname(currentNickname, nextNickname);
                increment = 2;
            }
        }
    }

    public void compareLettersOfNickname(String currentNickname, String nextNickname) {
        System.out.println(currentNickname.substring(indexM, indexM + increment) + " " + nextNickname.substring(indexN, indexN + increment) + " 비교");
        if (currentNickname.substring(indexM, indexM + increment).equals(nextNickname.substring(indexN, indexN + increment))) {
            System.out.println("글자 같음: " + currentNickname.substring(indexM, indexM + increment));
            duplicateLetters.add(currentNickname.substring(indexM, indexM + increment));
            increment++;
            while (indexM + increment <= currentNickname.length() && indexN + increment <= nextNickname.length() && currentNickname.substring(indexM, indexM + increment).equals(nextNickname.substring(indexN, indexN + increment))) {
                System.out.println(currentNickname.substring(indexM, indexM + increment) + " " + nextNickname.substring(indexN, indexN + increment) + " 추가 비교");
                System.out.println("글자 같음: " + currentNickname.substring(indexM, indexM + increment));
                duplicateLetters.add(currentNickname.substring(indexM, indexM + increment));
                increment++;
            }
            System.out.println("글자 추가 시 안 같았음");
        }
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("woniees@email.com", "워니스"),
            List.of("mj@email.com", "엠제이슨"),
            List.of("nowm@email.com", "이제엠")
        );

        UserInfo userInfo = new UserInfo(forms);
        DuplicateFinder duplicateFinder = new DuplicateFinder(userInfo);
        duplicateFinder.findDuplicates();
    }
}
