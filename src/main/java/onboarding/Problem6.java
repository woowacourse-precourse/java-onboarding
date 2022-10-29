package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


class validateInformation{
    public static boolean isOverlappedName(List<String> dividedName, List<String> crew){
        String crewName=crew.get(1);
        for(int i=0;i<dividedName.size();i++){
            if(crewName.contains(dividedName.get(i))){return true;}
        }
        return false;
    }
    public static boolean isValidEmail(List<String> crew){
        String crewEmail = crew.get(0);
        String domain = crewEmail.split("@")[1];
        if((crewEmail.length()<1)&&(crewEmail.length()>=20)){return false;}
        if(domain!="email.com"){return false;}
        return true;
    }
    public static boolean isValidNickName(List<String> crew){
        String crewNickName = crew.get(1);
        if((crewNickName.length()<1)&&(crewNickName.length()>=20)){return false;}
        if(!crewNickName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")){return false;}
        return true;
    }
}
class handleList{
    public static List<String> removeSamethings(List<String> list){
        List<String> newlList = list.stream()
                .distinct()
                .collect(Collectors.toList());
        return newlList;
    }
    public static List<String> sortList(List<String> list){
        Collections.sort(list);
        return list;
    }
}
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
