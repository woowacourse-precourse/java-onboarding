package onboarding.feature6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateFinder {
    private String duplicateLetters = "";
    private String currentNickname;
    private String currentEmail;
    private String nextNickname;
    private String nextEmail;
    
    private int increment = 2;
    private int indexI;
    private int indexJ;
    private int indexM;
    private int indexN;
    private int initialNicknamesSize;
    

    private List<String> initialEmails;
    private List<String> initialNicknames;
    private Set<String> filteredEmails;
    private Map<String, Set<String>> result = new HashMap<>();

    public DuplicateFinder(UserInfo userInfo) {
        initialEmails = userInfo.getEmails();
        initialNicknames = userInfo.getNicknames();
        initialNicknamesSize = initialNicknames.size();
    }

    public void findDuplicates() {
        for (indexI = 0; indexI < initialNicknamesSize - 1; indexI++) {
            currentNickname = initialNicknames.get(indexI);
            currentEmail = initialEmails.get(indexI);
            for (indexJ = indexI + 1; indexJ < initialNicknamesSize; indexJ++) {
                nextNickname = initialNicknames.get(indexJ);
                nextEmail = initialEmails.get(indexJ);
                System.out.println("닉네임 - " + currentNickname + " " + nextNickname + " 비교");
                compareLettersOfNickname(currentNickname, nextNickname);
            }
        }
        
        System.out.println(result);
    }

    public void compareLettersOfNickname(String CurrentNickname, String nextNickname) {
        for (indexM = 0; indexM < currentNickname.length() - 1; indexM++) {
            String lettersOfCurrentNickname = CurrentNickname.substring(indexM, indexM + increment);
            for (indexN = 0; indexN < nextNickname.length() - 1; indexN++) {
                String lettersOfNextNickname = nextNickname.substring(indexN, indexN + increment);
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
                    filteredEmails = new HashSet<>();
                    filteredEmails.add(currentEmail);
                    filteredEmails.add(nextEmail);
                    System.out.println(duplicateLetters + "를 새로운 key로 result에 " + currentEmail + "과 " + nextEmail +"을 등록합니다.");
                    result.put(duplicateLetters, filteredEmails);
                }
            }
        }
    }


    public static void main(String[] args) {
        List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("mj@email.com", "엠제이"),
            List.of("nowm@email.com", "이제엠")
        );

        UserInfo userInfo = new UserInfo(forms);
        DuplicateFinder duplicateFinder = new DuplicateFinder(userInfo);
        duplicateFinder.findDuplicates();
    }
}
