package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    /*
    - result 는 이메일 주소로 order asc & "중복 제거"
    - 이메일 값은 @email.com 제외 최소1자 ~ 최대9자
     */
    public static List<String> solution(List<List<String>> forms) {
        int peopleNum = forms.size();
        final Stream<String> memberStream = forms.stream().map(s -> s.get(1));
        final List<String> memberList = new ArrayList<>(memberStream.collect(Collectors.toList()));
        Map<String, String> emailDict = new HashMap<>();
        for(List<String> list : forms){
            emailDict.put(list.get(1), list.get(0));
        }
        Set<String> answer = new HashSet<>(Collections.emptySet());
        int cnt = 0 ;
        while (!memberList.isEmpty()){
            if (cnt==peopleNum){
                break;
            }
            String target = memberList.get(0);
            memberList.remove(target);
            Set<String> cases = getAllCase(target);
            int existCase = (int) cases.stream().filter(s->isExist(s,memberList)).count();
            if(existCase>0){
                answer.add(emailDict.get(target));
            }
            memberList.add(target);
            cnt+=1;
        }
        return answer.stream().sorted(new EmailComparator()).collect(Collectors.toList());
    }
    protected static Set<String> getAllCase(String s){
        Set<String> cases = new HashSet<>(Collections.emptySet());
        int len = s.length();
        for (int i = 0 ; i < len-1 ; i++){
            for (int j = 2 ; i+j <= len ; j++ ){
                cases.add(s.substring(i,i+j));
            }
        }
        return cases ;
    }
    protected static Boolean isExist(String s, List<String> nameList){
        boolean flag = false;
        for (String name : nameList){
            if(name.contains(s)){
                flag = true;
                break;
            }
        }
        return flag;
    }
    protected static class EmailComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
}
