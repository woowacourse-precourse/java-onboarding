package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        List<String> warningEmail = new ArrayList<>();

        for(int i = 0;i < forms.size();i++) {

            List<String> mySubStr = cutCase(forms.get(i).get(1));
            List<List<String>> otherPeople = notMe(forms,forms.get(i));

            for(List<String> person : otherPeople) {

                for (String piece : mySubStr) {

                    if (person.get(1).contains(piece)) {

                        warningEmail.add(person.get(0));
                        break;
                    }
                }
            }
        }

        warningEmail = tidyList(warningEmail);

        return warningEmail;
    }

    public static List<List<String>> notMe(List<List<String>> forms, List<String> me) {

        List<List<String>> withoutMe = new ArrayList<>(forms);
        withoutMe.remove(me);

        return withoutMe;
    }

    public static List<String> cutCase (String nickname) {

        List<String> namePiece = new ArrayList<>();

        for(int i = 0;i < nickname.length() - 1;i++) {

            namePiece.add(nickname.substring(i, i + 2));
        }

        return namePiece;
    }

    public static List<String> tidyList (List<String> warningEmail) {

        Set<String> deleteSame = new TreeSet<>(warningEmail);

        return new ArrayList<>(deleteSame);
    }

}
