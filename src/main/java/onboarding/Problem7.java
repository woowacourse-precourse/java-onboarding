package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Person{
    private String id;
    private int score;

    public Person(String id, int score){
        this.id = id;
        this.score = score;
    }
    public String getId(){
        return this.id;
    }
    public int getScore(){
        return this.score;
    }

}
public class Problem7 {
    public static List<String> solution(String userID, ArrayList<ArrayList> friends, ArrayList<String> visitors) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> userFriends = new ArrayList<>();
        ArrayList<Person> recList = new ArrayList<>();
        boolean check = false;

        for(int i=0;i<friends.size();i++){      //user의 친구목록
            ArrayList<String> m1 = friends.get(i);
            String id1 = m1.get(0);
            String id2 = m1.get(1);

            if(id1.equals(userID)){
                userFriends.add(id2);
            }
            else if(id2.equals(userID)){
                userFriends.add(id1);
            }
        }

        for(int i=0;i<friends.size();i++){
            ArrayList<String> m1 = friends.get(i);
            String id1 = m1.get(0);
            String id2 = m1.get(1);

            if(!id1.equals(userID) && !id2.equals(userID)){

                /*for(int j=0;j<userFriends.size();j++){

                    if(id1.equals(userFriends.get(j))){
                        isAlreadyFirend = true;
                        break;
                    }
                }*/
                if(!userFriends.contains(id1)){
                    ArrayList<String> otherFriendsList = new ArrayList<>();
                    for(int j=0;j<friends.size();j++){
                        ArrayList<String> m2 = friends.get(j);
                        String t1 = m2.get(0);
                        String t2 = m2.get(1);

                        if(t1.equals(id1)){
                            otherFriendsList.add(t2);
                        }
                        else if(t2.equals(id1)){
                            otherFriendsList.add(t1);
                        }
                    }

                    int score = 0;
                    for(int j=0;j<userFriends.size();j++){
                        String userFriendName = userFriends.get(j);
                        if(otherFriendsList.contains(userFriendName)){
                            score+=10;
                        }
                        /*for(int k=0;k<otherFriendsList.size();k++){
                            String otherFriendName = otherFriendsList.get(k);
                            if(otherFriendName.equals(userFriendName)){
                                score += 10;
                                userFriends.con
                            }
                        }*/
                    }
                    for(int j=0;j<visitors.size();j++){
                        if(id1.equals(visitors.get(j)))
                            score++;
                    }
                    for(int j=0;j<recList.size();j++){
                        Person temp = recList.get(j);
                        check = false;
                        if(temp.getId().equals(id1)){
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        Person person = new Person(id1,score);
                        recList.add(person);
                    }
                }
                if(!userFriends.contains(id2)){
                    ArrayList<String> otherFriendsList = new ArrayList<>();
                    for(int j=0;j<friends.size();j++){
                        ArrayList<String> m2 = friends.get(j);
                        String t1 = m2.get(0);
                        String t2 = m2.get(1);

                        if(t1.equals(id2)){
                            otherFriendsList.add(t2);
                        }
                        else if(t2.equals(id2)){
                            otherFriendsList.add(t1);
                        }
                    }

                    int score = 0;
                    for(int j=0;j<userFriends.size();j++){
                        String userFriendName = userFriends.get(j);
                        if(otherFriendsList.contains(userFriendName)){
                            score+=10;
                        }
                        /*for(int k=0;k<otherFriendsList.size();k++){
                            String otherFriendName = otherFriendsList.get(k);
                            if(otherFriendName.equals(userFriendName)){
                                score += 10;
                                userFriends.con
                            }
                        }*/
                    }
                    for(int j=0;j<visitors.size();j++){
                        if(id2.equals(visitors.get(j)))
                            score++;
                    }
                    for(int j=0;j<recList.size();j++){
                        Person temp = recList.get(j);
                        check = false;
                        if(temp.getId().equals(id2)){
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        Person person = new Person(id2,score);
                        recList.add(person);
                    }
                }
            }
        }
        for(int i=0;i<visitors.size();i++){
            boolean bo = false;
            int score = 0;
            String visitName = visitors.get(i);
            if(userFriends.contains(visitName))
                continue;
            for(int j=0;j<recList.size();j++){
                String recName = recList.get(j).getId();
                if(recName.equals(visitName)) {
                    bo = true;
                    break;
                }
            }
            if(bo == true)
                continue;
            score = Collections.frequency(visitors,visitName);
            Person person = new Person(visitName,score);
            recList.add(person);
        }


        while(!recList.isEmpty()) {
            int max = 0;
            int idx = 0;
            for (int i = 0; i < recList.size(); i++) {
                int sc = recList.get(i).getScore();
                if (i == 0) {
                    max = sc;
                    idx = 0;
                }
                else {
                    if (max < sc){
                        max = sc;
                        idx = i;
                    }
                }
            }
            result.add(recList.get(idx).getId());
            recList.remove(idx);
        }
        return result;
    }
}
