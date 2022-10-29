package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        int peopleNum = forms.size();
        Set<String> answer = new HashSet<>(Collections.emptySet());

        final Stream<String> memberStream = forms.stream().map(s -> s.get(1));
        List<String> memberList = new ArrayList<>(memberStream.collect(Collectors.toList()));
        Map<String, String> emailDict = new HashMap<>();
        for(List<String> list : forms){
            emailDict.put(list.get(1), list.get(0));
        }

        int checkCount = 0 ;
        while (!memberList.isEmpty()){
            if (checkCount==peopleNum){
                break;
            }
            String target = memberList.get(0);
            Set<String> cases = getAllCase(target);

            memberList.remove(target);
            int existCase = (int) cases.stream().filter(s->isExist(s,memberList)).count();
            if(existCase>0){
                answer.add(emailDict.get(target));
            }
            memberList.add(target);
            checkCount+=1;
        }
        return answer.stream().sorted(new EmailComparator()).collect(Collectors.toList());
    }
    private static Set<String> getAllCase(String s){
        Set<String> cases = new HashSet<>(Collections.emptySet());
        int len = s.length();
        for (int i = 0 ; i < len-1 ; i++){
            for (int j = 2 ; i+j <= len ; j++ ){
                cases.add(s.substring(i,i+j));
            }
        }
        return cases ;
    }
    private static boolean isExist(String s, List<String> nameList){
        for (String name : nameList){
            if(name.contains(s)){
                return true;
            }
        }
        return false;
    }
    private static class EmailComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
}
