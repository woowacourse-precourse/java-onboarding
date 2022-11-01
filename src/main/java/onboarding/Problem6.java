package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    static Map<String, String> map;
    static Set<String> overLapNickNameEmail;

    // 이메일 중 email.com이 아닌것을 찾는 함수
    public static boolean checkEmail(String email){
        String[] emailArr = email.split("@");
        if(!emailArr[1].equals("email.com")) return false;
        return true;
    }

    // 유저의 이메일의 도메인이 유효하지 않거나 닉네임이 1자라 중복이 발생할 수 없는 경우 체크
    public static boolean exceptionCheck(List<String> user){
        if(user.get(1).length() == 1 || !checkEmail(user.get(0))){
            return true;
        }
        return false;
    }

    // 같은 글자가 연속적으로 중복된 닉네임을 찾는 함수
    public static void findOverLapNickName(List<String> user){
        String name = user.get(1);

        for(String user1 : map.keySet()){
            for(int i=0; i<name.length()-1; i++){
                if(user1.contains(name.substring(i,i+2))){
                    setOverLapEmail(user.get(0),map.get(user1));
                    return;
                }
            }
        }
    }

    // 중복된 닉네임을 가진 유저의 이메일을 목록을 중복이메일 리스트에 저장하는 함수
    public static void setOverLapEmail(String userEmail1, String userEmail2){
        overLapNickNameEmail.add(userEmail1);
        overLapNickNameEmail.add(userEmail2);
    }

    // email에 해당하는 부분의 문자열을 오름차순으로 정렬하는 함수
    public static List<String> sorting(Set<String> emailList){
        return emailList.stream().sorted().collect(Collectors.toList());
    }

    //위의 과정을 거쳐 최종 중복 이메일 리스트를 리턴하는 함수
    public static List<String> solution(List<List<String>> forms) {
        map = new HashMap<>();
        overLapNickNameEmail = new HashSet<>();

        for(List<String> user : forms){
            if(exceptionCheck(user)) continue;
            findOverLapNickName(user);
            map.put(user.get(1), user.get(0));
        }

        List<String> result = sorting(overLapNickNameEmail);
        return result;
    }
}
