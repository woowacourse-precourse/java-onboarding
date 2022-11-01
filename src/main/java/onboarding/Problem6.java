package onboarding;

import java.util.*;
import java.util.stream.Collectors;

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
        HashMap<String, ArrayList<String>> twoLetter = new HashMap<>();
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

        duplicateEmail = (getDuplicateFromHash(twoLetter));

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

    public static ArrayList<String> getDuplicateFromHash(HashMap<String, ArrayList<String>> twoLetter) {
        ArrayList<String> sameValueEmail = new ArrayList<>();
        HashSet<String> duplicateSet;

        for (Map.Entry<String, ArrayList<String>> entry: twoLetter.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();

            sameValueEmail.addAll(getSameValue(twoLetter, key, value));

        }

        duplicateSet = new HashSet<>(sameValueEmail);
        sameValueEmail = new ArrayList<>(duplicateSet);
        Collections.sort(sameValueEmail);

        return sameValueEmail;
    }

    public static ArrayList<String> getSameValue(HashMap<String, ArrayList<String>> twoLetter, String key,
                                                 ArrayList<String> value) {

        ArrayList<String> sameValueList = new ArrayList<>();
        int indexOfFirstValue;
        int indexOfSecondValue;


        for (Map.Entry<String, ArrayList<String>> entry2: twoLetter.entrySet()) {
            String compareKey = entry2.getKey();
            ArrayList<String> compareValue = entry2.getValue();

            if (key.equals(compareKey)) {
                continue;
            }

            for (indexOfFirstValue = 0; indexOfFirstValue < value.size(); indexOfFirstValue++) {
                 for (indexOfSecondValue =0; indexOfSecondValue < compareValue.size(); indexOfSecondValue++) {

                     if(value.get(indexOfFirstValue).equals(compareValue.get(indexOfSecondValue))) {
                         sameValueList.add(compareKey);
                     }
                 }
            }
        }

        return sameValueList;
    }
}
