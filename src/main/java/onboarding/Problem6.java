package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();

        if (throwCrewNumberException(forms)) {
            return answer;
        }

        answer = findDuplicateName(forms);

        return answer;
    }

    public static boolean throwCrewNumberException(List<List<String>> forms) {
        return (forms.isEmpty() || forms.size() > 10_000);
    }

    public static boolean throwEmailLengthException(List<String> forms) {
        return (forms.get(0).length() < 11 || forms.get(0).length() > 20);

    }

    public static boolean throwEmailTypeException(List<String> forms) {
        int index = forms.get(0).indexOf("@");

        return (forms.get(0).substring(index).equals("@email.com"));
    }

    public static boolean throwNameNotKoreanException(List<String> forms) {
        return (!forms.get(1).matches("^[ㄱ-ㅎ가-힣]*$"));
    }

    public static boolean throwNameLengthException(List<String> forms) {
        return (forms.get(1).length() < 1 || forms.get(1).length() >= 20);
    }

    public static ArrayList<String> findDuplicateName(List<List<String>> forms) {
        ArrayList<String> duplicateEmail = new ArrayList<>();
        HashMap<String, List<String>> twoLetter = new HashMap<>();
        boolean exception = false;

        for (List<String> formsList: forms) {
            exception = throwEmailLengthException(formsList);
            exception = throwEmailTypeException(formsList);
            exception = throwNameNotKoreanException(formsList);
            exception = throwNameLengthException(formsList);

            if (exception) {
                return duplicateEmail;
            }

            twoLetter.putAll(getTwoLetterEach(formsList));
            
        }

        return duplicateEmail;
    }

    public static HashMap<String, ArrayList<String>> getTwoLetterEach(List<String> forms) {
        HashMap<String, ArrayList<String>> Letter = new HashMap<>();
        ArrayList<String> addArray = new ArrayList<>();
        int index;

        if (forms.get(1).length() == 1) {
            addArray.add(forms.get(1));
            Letter.put(forms.get(0), addArray);
            return Letter;
        }

        for (index = 0; index < forms.get(1).length() - 1; index++) {
            addArray.add(forms.get(1).substring(index, index + 2));
        }

        Letter.put(forms.get(0), addArray);

        return Letter;
    }
}
