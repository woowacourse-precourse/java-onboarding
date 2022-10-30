package onboarding;

import java.util.*;

public class Problem6 {

    static final int EMAIL = 0;    //리스트 내의 이메일이 위치하는 인덱스
    static final int NAME = 1;     //리스트 내의 닉네임이 위치하는 인덱스
    /*
     * Map<연속적인 문자열, 그 문자열을 가지는 유저 이메일>
     * Key 가 존재하고, 현재 조회중인 유저 이메일과 Value 에 위치한 이메일이 다른 경우 중복으로 간주
     */
    static Map<String, String> map = new HashMap<>();
    static String userEmail;
    static String userName;
    static List<String> userNames;
    static User user;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for(List<String> form : forms){
            userEmail = form.get(EMAIL);
            userName = form.get(NAME);

            // 이메일 도메인이 유효한 지 검사
            if(!emailCheck(userEmail) || !nameCheck(userName)){
                continue;
            }

            user = new User(userName);
            user.makeStringSeq();    // 해당 유저의 닉네임으로 만들 수 있는 연속된 문자열 생성

            userNames = user.getNames();
            for(String subStringOfName : userNames){

                if(map.containsKey(subStringOfName)){
                    String email = map.get(subStringOfName);

                    if(!userEmail.equals(email)){    // 키값을 등록한 유저의 이메일과 다른 경우
                        if(!answer.contains(email)){    // 결과값에 중복되지 않도록 검사하여, 중복이 없다면 추가
                            answer.add(email);
                        }
                        answer.add(userEmail);
                    }

                }else{
                    map.put(subStringOfName, userEmail);
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    // 이메일 관련 제한사항 체크
    public static boolean emailCheck(String email){
        int emailLen = email.length();
        if(10 < emailLen && emailLen <20) {
            String domain = email.split("@")[1];
            if (domain.equals("email.com")) {
                return true;
            }
        }
        return false;
    }

    // 닉네임 관련 제한사항 체크
    public static boolean nameCheck(String name){
        int nameLen = name.length();
        if(0 < nameLen && nameLen < 20){
            return true;
        }
        return false;
    }

    static class User{
        private String name;
        private List<String> names = new ArrayList<>();

        public User(String name){
            this.name = name;

        }
        /*
         * 해당 유저의 닉네임으로 만들 수 있는 연속된 문자열 생성
         * 연속적인 두 글자 이상의 문자들을 모두 찾아내어 names 리스트에 모두 저장한다.
         */
        public void makeStringSeq(){
            for(int range = 2; range <= this.name.length(); range++) {
                for (int i = 0; i <= (this.name.length() - range); i++) {
                    this.names.add(name.substring(i, i + range));
                }
            }
        }

        public List<String> getNames() {
            return names;
        }
    }
}
