package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        if(forms.size() == 1)
            return Collections.emptyList();

        Map<String, Integer> existNicknameMap = new HashMap<>();
        Set<String> emailSet = new HashSet<>();

        for(int i=0; i<forms.size(); i++)
            checkIfNicknameIsValid(i, forms, existNicknameMap, emailSet);

        return setToArrayList(emailSet);
    }

    public static void checkIfNicknameIsValid(int now, List<List<String>> forms, Map<String, Integer> existNicknameMap, Set<String> emailSet) {

        List<String> info = forms.get(now);
        String nickname = info.get(1);

        for(int j=0; j<nickname.length()-1; j++) {
            String twoWords = nickname.substring(j, j+2);
            int index = getIndexOfExistNickname(existNicknameMap, twoWords);

            if(validIndex(index))
                existNicknameMap.put(twoWords, now);

            if(!validIndex(index)) {
                emailSet.add(getEmailByIndex(forms, now));
                emailSet.add(getEmailByIndex(forms, index));
            }
        }
    }

    public static int getIndexOfExistNickname(Map<String, Integer> existNicknameMap, String twoWords) {

        if(existNicknameMap.containsKey(twoWords))
            return existNicknameMap.get(twoWords);

        return -1;
    }

    public static boolean validIndex(int index) {
        return index == -1;
    }

    public static String getEmailByIndex(List<List<String>> forms, int index) {
        return forms.get(index).get(0);
    }

    public static List<String> setToArrayList(Set<String> emailSet) {

        List<String> emailList = new ArrayList<>(emailSet);
        emailList.sort(Comparator.naturalOrder());

        return emailList;
    }
}