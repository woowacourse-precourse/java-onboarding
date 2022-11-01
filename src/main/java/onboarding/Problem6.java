package onboarding;

import java.util.*;

public class Problem6 {
    private static final int FORM_EMAIL = 0;
    private static final int FORM_NICKNAME = 1;
    private static final int MIN_CREW = 1;
    private static final int MAX_CREW = 10000;
    private static final String DOMAIN = "email.com";
    private static final int MIN_EMAIL = 11;
    private static final int MAX_EMAIL = 19;
    private static final int MIN_NICKNAME = 1;
    private static final int MAX_NICKNAME = 19;

    private static final String NAME = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.";

    private static List<String> answer = new ArrayList<>();
    private static List<Set<String>> partitionsList = new ArrayList<>();
    private static Map<String, Integer> nicknameAndCount = new HashMap<>();

    public static void setEmailsFromPartitionsOfNickname(List<List<String>> forms) {
        for (int i = 0; i < partitionsList.size(); i++) {

            Set<String> parts = partitionsList.get(i);
            for (String part : parts) {
                if (nicknameAndCount.get(part) > 1) {
                    answer.add(forms.get(i).get(FORM_EMAIL));
                }
            }
        }
        Collections.sort(answer);
    }
    public static void setupData(List<List<String>> forms) {
        for (List<String> form : forms) {
            Set<String> partsOfNickname = getPartitionsOfNickname(form.get(FORM_NICKNAME));
            partitionsList.add(partsOfNickname);
            for (String part : partsOfNickname) {
                nicknameAndCount.put(part, nicknameAndCount.getOrDefault(part, 0) + 1);
            }
        }

    }
    public static Set<String> getPartitionsOfNickname(String nickname) {
        Set<String> partitions = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            partitions.add(nickname.substring(i, i + 2));
        }

        return partitions;
    }





}
