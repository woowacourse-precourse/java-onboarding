package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class Problem6 {

    static final int LIST_START_RANGE = 1;
    static final int LIST_END_RANGE = 10_000;

    public static List<String> solution(List<List<String>> forms) {

        return makeEmailList(makeFragmentOwners(makeFragmentOwnerMap(forms))).result();
    }


    private static boolean isEmptyList(List<?> list) {
        return list == null;
    }

    private static boolean isValidLength(String str, int start, int end) {
        return start <= str.length() && str.length() <= end;
    }

    private static boolean isValidLength(List<?> list, int start, int end) {
        return start <= list.size() && list.size() <= end;
    }

    public static Email makeEmail(String email) {
        return new Email(email);
    }

    public static Nickname makeNickname(String nickname) {
        return new Nickname(nickname);
    }

    public static NicknameFragment makeNicknameFragment(String nicknameFragment) {
        return new NicknameFragment(nicknameFragment);
    }

    public static FragmentOwnerMap makeFragmentOwnerMap(List<List<String>> forms) {
        return new FragmentOwnerMap(forms);
    }

    public static FragmentOwners makeFragmentOwners(FragmentOwnerMap fragmentOwnerMap) {
        return new FragmentOwners(fragmentOwnerMap);
    }

    public static EmailList makeEmailList(FragmentOwners fragmentOwners) {
        return new EmailList(fragmentOwners);
    }


    static class EmailList {

        private FragmentOwners fragmentOwners;

        public EmailList(FragmentOwners fragmentOwners) {
            this.fragmentOwners = fragmentOwners;
        }

        private static void sortEmailList(List<Email> emailList) {
            Collections.sort(emailList);
        }

        public List<String> result() {
            List<Email> emailList = fragmentOwners.duplicateNameOwners();
            sortEmailList(emailList);
            return deduplicate(emailList);
        }

        private List<String> deduplicate(List<Email> emailList) {

            List<String> deduplicatedEmailList = new ArrayList<>();
            for (int i = 0; i < emailList.size(); i++) {
                deduplicateInEmail(emailList, deduplicatedEmailList, i);
            }
            return deduplicatedEmailList;
        }

        private void deduplicateInEmail(List<Email> emailList, List<String> deduplicatedEmailList, int idx) {

            if (isDuplicatedEmail(emailList, idx)) {
                return;
            }

            deduplicatedEmailList.add(emailList.get(idx).getValue());
        }

        private boolean isDuplicatedEmail(List<Email> answer, int idx) {
            return idx != 0 && answer.get(idx).equals(answer.get(idx - 1));
        }
    }

    static class FragmentOwners {

        private FragmentOwnerMap fragmentOwnerMap;

        public FragmentOwners(FragmentOwnerMap fragmentOwnerMap) {
            this.fragmentOwnerMap = fragmentOwnerMap;
        }

        public List<Email> duplicateNameOwners() {
            return fillDuplicateNameOwners(fragmentOwnerMap);
        }


        private List<Email> fillDuplicateNameOwners(FragmentOwnerMap fragmentOwnerMap) {
            List<Email> ret = new ArrayList<>();
            for (List<Email> owners : fragmentOwnerMap.getMap().values()) {
                addDuplicateNameOwners(ret, owners);
            }
            return ret;
        }

        private void addDuplicateNameOwners(List<Email> ret, List<Email> owners) {
            if (!isDuplicateNameFor(owners)) {
                return;
            }
            ret.addAll(owners);
        }

        private boolean isDuplicateNameFor(List<Email> owners) {
            return owners.size() != 1;
        }
    }

    static class FragmentOwnerMap {

        private List<List<String>> value = null;

        public FragmentOwnerMap(List<List<String>> forms) {
            this.value = forms;
        }

        private static Map<String, List<Email>> fillNameFragmentOwners(List<List<String>> forms) {
            if (!isValidLength(forms, LIST_START_RANGE, LIST_END_RANGE)) {
                throw new InputMismatchException("리스트의 범위가 올바르지 않습니다.");
            }

            Map<String, List<Email>> nameFragmentOwners = new HashMap<>();

            for (List<String> form : forms) {
                Email email = makeEmail(form.get(0));
                Nickname nickname = makeNickname(form.get(1));

                addFragmentsOwner(nameFragmentOwners, email, nickname);
            }
            return nameFragmentOwners;
        }

        private static void addFragmentsOwner(Map<String, List<Email>> nameFragmentsOwners, Email email,
                Nickname nickname) {

            for (NicknameFragment nicknameFragment : nickname.fragments()) {
                addFragmentOwner(nicknameFragment, email, nameFragmentsOwners);
            }
        }

        private static void addFragmentOwner(NicknameFragment nicknameFragment, Email email,
                Map<String, List<Email>> nameFragmentsOwners) {
            if (isEmptyList(nameFragmentsOwners.get(nicknameFragment.getValue()))) {
                nameFragmentsOwners.put(nicknameFragment.getValue(), new ArrayList<>());
            }

            nameFragmentsOwners.get(nicknameFragment.getValue()).add(email);
        }

        public Map<String, List<Email>> getMap() {
            return fillNameFragmentOwners(value);
        }

    }

    static class Email implements Comparable<Email> {

        final int EMAIL_START_RANGE = 11;
        final int EMAIL_END_RANGE = 20;
        final String EMAIL_SUFFIX = "@email.com";

        private String value;

        public Email(String email) {
            if (!isValidEmail(email)) {
                throw new InputMismatchException("유효하지 않은 이메일 형식입니다.");
            }

            this.value = email;
        }


        public String getValue() {
            return value;
        }

        private boolean isValidEmail(String email) {
            if (!isValidLength(email, EMAIL_START_RANGE, EMAIL_END_RANGE - 1)) {
                return false;
            }

            return isEmailSuffixValid(email.substring(email.length() - EMAIL_SUFFIX.length()));
        }

        private boolean isEmailSuffixValid(String email) {
            return email.equals(EMAIL_SUFFIX);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Email email = (Email) o;
            return getValue().equals(email.getValue());
        }

        @Override
        public int compareTo(Email o) {
            return getValue().compareTo(o.getValue());
        }
    }

    static class Nickname {

        final int NICKNAME_START_RANGE = 1;
        final int NICKNAME_END_RANGE = 20;

        private String value;

        public Nickname(String nickname) {
            if (!isValidNickname(nickname)) {
                throw new InputMismatchException("유효하지 않은 닉네임 형식입니다.");
            }

            this.value = nickname;
        }

        public Nickname() {
        }

        private boolean isValidNickname(String nickname) {
            if (!isValidLength(nickname, NICKNAME_START_RANGE, NICKNAME_END_RANGE - 1)) {
                return false;
            }
            return isHangul(nickname);
        }

        protected boolean isHangul(String nickname) {
            return nickname.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*");
        }

        public List<NicknameFragment> fragments() {
            List<NicknameFragment> nicknameFragments = new ArrayList<>();

            for (int i = 0; i + NicknameFragment.VALUE_LENGTH - 1 < value.length(); ++i) {
                nicknameFragments.add(createNameFragment(value, i));
            }

            return nicknameFragments;
        }


        private NicknameFragment createNameFragment(String nickname, int startIdx) {
            return makeNicknameFragment(
                    nickname.substring(startIdx, startIdx + NicknameFragment.VALUE_LENGTH));
        }
    }


    static class NicknameFragment extends Nickname {

        static final int VALUE_LENGTH = 2;
        private String value;

        NicknameFragment(String nicknameFragment) {
            if (!isValidNicknameFragment(nicknameFragment)) {
                throw new InputMismatchException("유효하지 않은 닉네임 조각 형식입니다.");
            }

            this.value = nicknameFragment;
        }

        public String getValue() {
            return value;
        }

        private boolean isValidNicknameFragment(String nicknameFragment) {
            if (!isValidLength(nicknameFragment, NICKNAME_START_RANGE, VALUE_LENGTH)) {
                return false;
            }
            return isHangul(nicknameFragment);
        }

    }

}
