package onboarding;

import java.util.*;
public class Problem7 {
    public static Map<String,List<String>> Information = new HashMap<String,List<String>>();
    public static Map<String,Integer> Recommand = new HashMap<String,Integer>();
    public static List<String> everyone;
    public static List<String> userInfo;
    public static List<Map.Entry<String,Integer>> Result;
    public static void initInformation(List<List<String>> friends){
        int frs=friends.size();
        String person0,person1;

        for(int i=0; i<frs; i++){
            person0 =friends.get(i).get(0);
            person1 =friends.get(i).get(1);
            if(!Information.containsKey(person0)){
                Information.put(person0,new ArrayList<String>());
                Information.get(person0).add(person1);
            }
            else{
                Information.get(person0).add(person1);
            }
            if(!Information.containsKey(person1)){
                Information.put(person1,new ArrayList<String>());
                Information.get(person1).add(person0);
            }
            else{
                Information.get(person1).add(person0);
            }
        }
        return;
    }
    public static void initEverone(){
        everyone = new ArrayList<String>(Information.keySet());
    }
    public static void initUserInfo(String user){
        userInfo =Information.get(user);
    }
    public static void findbyFriend(String user){
        int everyoneSize=everyone.size();
        for(int i=0; i<everyoneSize; i++){
            String person =everyone.get(i);

            if(person.equals(user)) continue;

            if(!userInfo.contains(person)){
                List<String> personInfo = Information.get(person);
                int personSize= personInfo.size();
                int count=0;
                for(int j=0; j<personSize;j++){
                    if(userInfo.contains(personInfo.get(j)))count++;
                }
                if(count>0){
                    Recommand.put(person,count*10);
                }
            }
        }
        return;
    }
    public static void findbyVisitor(List<String> visitors){
        int visitorSize=visitors.size();
        for(int i=0; i<visitorSize; i++){
            String person=visitors.get(i);
            if(!userInfo.contains(person)){
                if(Recommand.containsKey(person)){
                    Recommand.replace(person,Recommand.get(person)+1);
                }
                else{
                    Recommand.put(person,1);
                }
            }
        }
    }
    public static void initResult(){
        Result = new LinkedList<>(Recommand.entrySet());
        Result.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue()==o2.getValue()){
                    return o1.getKey().compareTo(o2.getKey());
                }
                else return o2.getValue()-o1.getValue();
            }
        });
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        initInformation(friends);
        initEverone();
        initUserInfo(user);
        findbyFriend(user);
        findbyVisitor(visitors);
        initResult();

        int rsize=Result.size();
        if(rsize >5) rsize=5;
        for(int i=0; i<rsize; i++){
            answer.add(Result.get(i).getKey());
        }
        return answer;
    }
}
