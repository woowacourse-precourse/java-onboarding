package onboarding;

import java.util.*;

import static onboarding.Problem6.Const.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }

    private static boolean isFormWrongSize(List<String> form){
        return form.size() != EACH_FORM_SIZE;
    }

    private static boolean isCrewWrongSize(List<List<String>> forms){
        int crewSize = forms.size();
        return (crewSize < CREW_MIN_SIZE || crewSize > CREW_MAX_SIZE);
    }

    private static boolean isWrongDomain(String domain){
        return !domain.equals(EMAIL_DOMAIN);
    }

    private static boolean isEmailWrongSize(String email){
        int length = email.length();
        return (length < EMAIL_MIN_LENGTH || length >= EMAIL_MAX_LENGTH);
    }

    private static boolean isNameWrongSize(String name){
        int length = name.length();
        return (length < NAME_MIN_LENGTH || length >= NAME_MAX_LENGTH);
    }


    static class Const{
        public static final int CREW_MIN_SIZE = 1;
        public static final int CREW_MAX_SIZE = 10000;

        public static final int EACH_FORM_SIZE = 2;

        public static final int EMAIL_INDEX = 0;
        public static final int NAME_INDEX = 1;

        public static final int EMAIL_MIN_LENGTH = 11;
        public static final int EMAIL_MAX_LENGTH = 20;
        public static final String EMAIL_DOMAIN = "email.com";

        public static final int NAME_MIN_LENGTH = 1;
        public static final int NAME_MAX_LENGTH = 20;
    }
}
