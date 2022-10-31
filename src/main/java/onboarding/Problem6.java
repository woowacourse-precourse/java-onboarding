package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> strmap = new HashMap<>();
        HashMap<Character, List<Pair>> nickmap= new HashMap<>();
        List<String> answer = new ArrayList<>();
        for (List<String> person : forms) {
            String email  = person.get(0);
            String nickname = person.get(1);
            strmap.put(nickname,email);
            for (int i = 0; i < nickname.length()-1; i++) {
                List<Pair> newlist = addmapList(nickmap.get(nickname.charAt(i)),nickname.charAt(i+1));
                nickmap.put(nickname.charAt(i),newlist);
            }

        }

        for (List<String> person : forms){
            String email  = person.get(0);
            String nickname = person.get(1);
            for (int i = 0; i < nickname.length()-1; i++) {
                if(findCount(nickmap.get(nickname.charAt(i)),nickname.charAt(i+1))>1){
                    answer.add(email);
                    break;
                }
            }
        }

        answer = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);
        for (String email : answer) {
            System.out.println(email);
        }
        return answer;
    }
    public static List<Pair> addmapList(List<Pair> list, char cr){

        int flag=0;
        if(list!=null){
            for(int i=0; i<list.size(); i++){
                Pair pair = list.get(i);
                if(pair.value==cr){
                    pair.addCount();
                    list.set(i,pair);
                    flag =1;
                }
            }
            if(flag ==0){
                list.add(new Pair(cr));
            }
        }else {
            list = new ArrayList<>();
            list.add(new Pair(cr));
        }

        return list;
    }

    public static int findCount(List<Pair> list, char cr){
        for (Pair pair : list) {
            if(pair.value == cr){
                return pair.count;
            }
        }

        return 0;
    }
}

class Pair{
    char value;
    int count;

    public Pair(char value){
        this.value = value;
        this.count = 1;
    }
    public void addCount(){
        this.count++;
    }
}
