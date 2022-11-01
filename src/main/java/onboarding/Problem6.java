package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

       for(int i=0;i<forms.size();i++){
           Email email = new Email(forms.get(i).get(0));
           if(email.isValidDomain()&& email.isValidLength()){  // 이메일 유효성 통과
               Nickname nickname = new Nickname(forms.get(i).get(1));
               if(nickname.isValidNick()){ // 닉네임 유효성 통과
                   wrongCrew crew = new wrongCrew(forms);
                   List<String> result = crew.nickDuplicate(nickname.allCaseNickEmail(forms));
                   HashSet<String> delduple = new HashSet<>(result);
                   result = new ArrayList<>(delduple);  // 중복 제거하기
                   Collections.sort(result); // 오름차순 정렬
                   return result;
               }
           }else
               return null;
       }
       return null;
    }

    private static class wrongCrew {
        List<String> result = new ArrayList<>();
        List<List<String>> oriforms;

        public wrongCrew(List<List<String>> oriforms) {
            this.oriforms = oriforms;
        }

        public List<String> nickDuplicate(List<List<String>> forms) {
            for (List<String> oriform : oriforms) {
                for (List<String> form : forms) {
                    if (!Objects.equals(form.get(0), oriform.get(0))) {
                        // 이메일 주소가 다를때만 비교 ( 같은 사람이 아닐 때)
                        if ((oriform.get(1)).contains(form.get(1))) {
                            result.add(oriform.get(0));
                        }
                    }
                }
            }
            return result;
        }
    }

    private static class Nickname {
        private final String crewNick;
        public Nickname(String nick) {
            this.crewNick = nick;
        }
        public List<List<String>> allCaseNickEmail(List<List<String>> forms) {
            List<List<String>> result_nicklist = new ArrayList<>();

            for (List<String> form : forms) {
                List<String> nicklist = allCaseNick(form.get(1)); // forms의 닉네임 각각에 대한 모든 경우의 수
                for (String nick : nicklist) {
                    List<String> sub = new ArrayList<>();
                    sub.add(form.get(0)); // forms에서 이메일 가져오기
                    sub.add(nick); // nicklist에서 닉네임 가져오기
                    result_nicklist.add(sub);
                }
            }
            return result_nicklist; // 비교하기 편하도록 이메일과 모든 경우의 수를 합친 array를 반환
        }

        public List<String> allCaseNick(String nick) { // 닉네임당 나올 수 있는 모든 경우의 수
            int length = nick.length();
            List<String> nicklist = new ArrayList<>();

            for (int step = 2; step <= length; step++) { // 춘식이 -> 춘식,식이,춘식이로 만드는 과정
                for (int index = 0; index < length; index++) {
                    if (index + step >= length) {
                        nicklist.add(nick.substring(index));
                        break;
                    } else {
                        nicklist.add(nick.substring(index, index + step));
                    }
                }
            }
            return nicklist;
        }

        public boolean isValidNick() {
            String regex_nick = ".*[가-힣].*";
            int nick_length = crewNick.length();

            if (crewNick.matches(regex_nick)) { // 닉네임에 한글만 허용
                return nick_length >= 1 && nick_length < 20; // 한글만 있을때 길이는 유효한가
            } else {
                return false;
            }

        }
    }

    private static class Email {
        private final String crewEmail;

        public Email(String email) {
            this.crewEmail = email;
        }

        public boolean isValidDomain() {
            String regex_email = ".*[a-zA-Z0-9]+@email.com"; // id는 영어와 숫자만, 도메인은 email.com만 허용
            return crewEmail.matches(regex_email);
        }

        public boolean isValidLength() { // 이메일이 유효한 길이인지 확인
            int email_length = crewEmail.length();
            return email_length >= 11 && email_length < 20;
        }
    }

}
