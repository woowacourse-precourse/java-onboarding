package onboarding.feature6;

import java.util.ArrayList;
import java.util.List;

public class DuplicateFinder {
    private String duplicateLetters = "None";
    private int increasement = 2;
    private int indexI = 0;
    private int indexJ = indexI + 1;

    List<String> nicknames = new ArrayList<>();
    List<List<String>> forms;
    List<List<String>> formsFiltered = new ArrayList<>();

    public DuplicateFinder(List<List<String>> forms) {
        this.forms = forms;
        for (List<String> userInfo : forms) {
            nicknames.add(userInfo.get(1));
        }
    }

    public void checkNicknames() {
        for (indexI = 0; indexI < nicknames.size(); indexI++) {
            String currentNickname = nicknames.get(indexI);
            String nextNickname = nicknames.get(indexJ);
            String lettersOfCurrentNickname = currentNickname.substring(0, increasement);
            String lettersOfNextNickname = nextNickname.substring(0, increasement);

            isDuplicate(lettersOfCurrentNickname, lettersOfNextNickname);
            increasement = 2;
        }
        System.out.println(duplicateLetters);
    }

    public void isDuplicate (String lettersOfCurrentNickname, String lettersOfNextNickname) {
        if(lettersOfCurrentNickname.equals(lettersOfNextNickname)) {
            duplicateLetters = lettersOfCurrentNickname;
            increasement++;
            while (increasement < nicknames.get(indexI).length() && increasement < nicknames.get(indexJ).length()) {
                isDuplicate(lettersOfCurrentNickname, lettersOfNextNickname);
            }
        }
    }

    public String getLettersInWord(int index, int increasement) {
        String letters = nicknames.get(index).substring(0, increasement);
        return letters;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("mj@email.com", "엠제이"),
            List.of("nowm@email.com", "이제엠")
        );

        DuplicateFinder duplicateFinder = new DuplicateFinder(forms);
        duplicateFinder.checkNicknames();
    }
}
