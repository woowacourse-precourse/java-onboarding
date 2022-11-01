package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    static final int MIN_EMAIL_LENGTH = 11;
    static final int MAX_EMAIL_LENGTH = 20;
    static final int MIN_NAME_LENGTH = 1;
    static final int MAX_NAME_LENGTH = 20;
    static final int EMAIL_INDEX = 0;    //리스트 내의 이메일이 위치하는 인덱스
    static final int NAME_INDEX = 1;     //리스트 내의 닉네임이 위치하는 인덱스


    /*
     * Map<연속적인 문자열, 그 문자열을 가지는 유저 이메일>
     * Key 가 존재하고, 현재 조회중인 유저 이메일과 Value 에 위치한 이메일이 다른 경우 중복으로 간주
     */
    static Map<String, String> map = new HashMap<>();

    static String userEmail;
    static String userName;
    static NameSequence userNames;
    static User user;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for(List<String> form : forms){
            userEmail = form.get(EMAIL_INDEX);
            userName = form.get(NAME_INDEX);

            user = new User(userEmail, userName);

            userNames = user.getNameSequence();

            for(String nameSeq : userNames.getNameSeqList()){

                if(map.containsKey(nameSeq)){
                    String email = map.get(nameSeq);

                    // 키값을 등록한 유저의 이메일과 다른 경우 현재 유저의 이메일이 중복되는지 여부
                    if(!userEmail.equals(email)){
                        if(!answer.contains(email)){    // 결과값에 중복되지 않도록 검사한다.
                            answer.add(email);
                        }
                        answer.add(userEmail);
                    }
                    // 중복이라면 같은 유저의 이름이다. (예 : 제이제이 )

                }else{
                    map.put(nameSeq, userEmail);
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    static class User{

        private final NameSequence nameSequence;

        public User(String email, String name){
            validateEmailLength(email);
            validateEmailDomain(email);

            validateNameKorean(name);
            validateNameLength(name);

            this.nameSequence = new NameSequence(name);
        }

        public static void validateNameLength(String name){
            int nameLen = name.length();
            if(MIN_NAME_LENGTH > nameLen || nameLen >= MAX_NAME_LENGTH){
                throw new IllegalArgumentException("닉네임의 전체 길이는 "+ MIN_NAME_LENGTH + "자 이상, " +
                        MAX_NAME_LENGTH + "자 미만이어야 합니다.");
            }
        }

        public static void validateNameKorean(String name){
            if(!Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name)){
                throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
            }
        }

        public static void validateEmailLength(String email){
            int emailLen = email.length();
            if(MIN_EMAIL_LENGTH > emailLen || emailLen >= MAX_EMAIL_LENGTH) {
                throw new IllegalArgumentException("이메일 길이는 11자 이상 20자 미만이어야 합니다.");
            }
        }

        public static void validateEmailDomain(String email){
            String domain = email.split("@")[1];
            if (!domain.equals("email.com")) {
                throw new IllegalArgumentException("이메일은 email.com 도메인으로만 제한됩니다.");
            }
        }

        public NameSequence getNameSequence() {
            return nameSequence;
        }
    }

    // 일급 컬렉션을 작성
    static class NameSequence{
        private final static int MIN_SEQUENCE_LENGTH = 2;

        private final List<String> nameSeqList;

        public NameSequence(String name){
            nameSeqList = createNameSequence(name);
        }

        /*
         * 해당 유저의 닉네임으로 만들 수 있는 연속된 문자열 생성
         * 연속적인 두 글자 이상의 문자들을 모두 찾아내어 names 리스트에 모두 저장한다.
         */
        public List<String> createNameSequence(String name){
            List<String> nameSequence = new ArrayList<>();

            for(int range = MIN_SEQUENCE_LENGTH; range <= name.length(); range++) {
                for (int i = 0; i <= (name.length() - range); i++) {
                    nameSequence.add(name.substring(i, i + range));
                }
            }

            return nameSequence;
        }

        public List<String> getNameSeqList() {
            return nameSeqList;
        }
    }
}
