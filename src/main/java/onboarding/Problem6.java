package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        List<String> email_nickname_list = changeToList(forms);
        List<String> nickname_list = extractNickname(forms);
        List<String> same_nickname_list = findSameNickname(nickname_list);
        List<String> email_list = findEmail(same_nickname_list, email_nickname_list);

        answer = email_list.stream().distinct()
                .sorted()
                .collect(Collectors.toList());

        return answer;
    }
    static boolean checkSame(String nickname1, String nickname2){
        for(int i=0; i<nickname1.length()-1;i++){
            if(nickname2.contains(nickname1.substring(i,i+2))){
                return true;
            }
        }
        return false;
    }

    static List<String> changeToList(List<List<String>> forms){
        List<String> email_nickname_list;

        email_nickname_list = Stream.of(forms).flatMap(List::stream)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return email_nickname_list;
    }

    static List<String> extractNickname(List<List<String>> forms){
        List<String> nickname_list;

        nickname_list = Stream.of(forms).flatMap(List::stream)
                .flatMap(List::stream)
                .filter(s->!s.contains("@"))
                .collect(Collectors.toList());
        return nickname_list;
    }

    static boolean checkID(String nickname1, List<String> nickname_list){
        int self_check = 0;  // 자기 자신을 검색했나 확인 위한 변수

        for(String nickname2:nickname_list){
            if(nickname1.equals(nickname2) && self_check==0){ // 최초 검색은 자기 자신일 수 있으므로 넘기지만, 그 이후로도 동일한 닉네임이 있는지 확인
                self_check+=1;
                continue;
            }
            if(checkSame(nickname1, nickname2)){
                return true;
            }
        }
        return false;
    }

    static List<String> findSameNickname(List<String> nickname_list){
        List<String> same_nickname_list = new ArrayList<>();

        for (String nickname:nickname_list){
            if(checkID(nickname, nickname_list)){
                same_nickname_list.add(nickname);
            }
        }
        return same_nickname_list;
    }

    static List<String> findEmail(List<String> same_nickname_list, List<String> email_nickname_list){
        List<String> email_list = new ArrayList<>();
        int temp;   // email_nickname_list 에서 닉네임이 있는 인덱스 값을 임시 저장하기 위한 변수

        for(String nickname:same_nickname_list){
            temp = email_nickname_list.indexOf(nickname);
            email_list.add(email_nickname_list.get(temp-1));    // 이메일, 닉네임 순서로 저장되있기 때문에 temp-1로 접근 가능
            email_nickname_list.remove(temp);       // 동일한 닉네임을 검색하는 경우를 위해 이미 검색한 것은 삭제
            email_nickname_list.remove(temp-1);
        }
        return email_list;
    }
}