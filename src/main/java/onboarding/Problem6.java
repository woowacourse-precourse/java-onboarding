package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

    public static Map<String, List<String>> map1 = new HashMap<>();                    // Map<key, value>  => (key, value)
    public static List<String> solution(List<List<String>> forms) {
        if(!Check(forms)){
            //예외처리
        }
        NameSplit(forms);
        List<String>  nameoverlapresult = NameOverlap();

        return EmailSort(nameoverlapresult);
    }

    public static List<String> NicknameList(List<List<String>> forms) {
        List<String> Nickname = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            Nickname.add(forms.get(i).get(1));

        }
        return Nickname;

    }
    public static List<String> EmailList(List<List<String>> forms) {
        List<String> email = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            email.add(forms.get(i).get(0));

        }

        return email;
    }
    public static boolean Check(List<List<String>> forms){

        if(!BigListNumber(forms)){
            return false;
        }
        if(!EmailCheck(forms)){
            return false;
        }
        if(!DomainCheck(forms)){
            return false;
        }
        if(!NameKoreanCheck(forms)){
            return false;
        }
        if(!NameLengthCheck(forms)){
            return false;
        }
        return true;
    }


    public static boolean BigListNumber(List<List<String>> member){
        if(1 <= member.size() && member.size() <= 10000){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean EmailCheck(List<List<String>> email){
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";

        for(String e : EmailList(email)){
            if(!Pattern.matches(regex, e)){
                return false;
            }
        }
        return true;
    }
    public static boolean DomainCheck(List<List<String>> email){
        String form = "@email.com";
        for(String e: EmailList(email)){
            if(form != e.substring(e.length()-10, e.length())){
                return false;
            }
        }
        return true;
    }
    public static boolean NameKoreanCheck(List<List<String>> name){
        String regex = "^[ㄱ-ㅎ가-힣]*$ ";
        for(String n : NicknameList(name)){
            if(!Pattern.matches(regex, n)){
                return false;
            }
        }
        return true;

    }
    public static boolean NameLengthCheck(List<List<String>> name) {
        for (String n : NicknameList(name)) {
            if (1 >= n.length() || n.length() >= 20) {
                return false;
            }

        }
        return true;
    }
    public static void NameSplit(List<List<String>> name){
        for(List<String>form : name){
            String username = form.get(1);
            for(int i=0; i < username.length()-1; i++){
                String splitword = username.substring(i, i+2);                     //닉네임을 2개씩 쪼개기

                List<String> list = map1.getOrDefault(splitword, new ArrayList<>()); // (쪼갠문자열들getordefault = 찾는키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본값을 반환하는 매서드
                list.add(form.get(0));
                map1.put(splitword, list);                                           // {쪼갠문자열들=[이메일], 쪼갠문자열들=[이메일,이메일]}

            }
        }

    }
    public static List<String> NameOverlap(){
        return map1.values().stream().filter(list -> list.size() >=2).flatMap(Collection::stream).collect(Collectors.toList());
    } // stream=> 데이터의 흐름 flatmap => 평면화, collection::stream => 데이터들을 컬렉션 자료구조로 만들기 , coolect는 stream의 데이터를 변형등의 처리를 하고 원하는 자료형으로 변환

    public static List<String> EmailSort(List<String> overlapemail){
        return overlapemail.stream().distinct().sorted().collect(Collectors.toList());
           // distinct => 스트림에서 중복되는 요소들을 제거하고 새로운 스트림을 반환
    }
}



