package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.regex.Pattern;

public class Problem7 {
    public static boolean exception(String[][] newfri, String user, String[] newvisit){
        if (user.length() > 30 || Pattern.matches("^[a-z]*$", user) == false){
            return false;
        }
        for (int i = 0; i < newfri.length; i++){
            for (int j = 0; j < newfri[i].length; j++){
                if (newfri[i][j].length() > 30 || Pattern.matches("^[a-z]*$", newfri[i][j]) == false)
                    return false;
            }
        }
        for (int i = 0; i < newvisit.length; i++){
            if (newvisit[i].length() > 30 || Pattern.matches("^[a-z]*$", newvisit[i]) == false)
                return false;
        }
        return true;
    }
    public static List<String> makeresult(String[] scoreperson, String[][] newfri, String[] newvisit){
        HashMap<String, Integer> score = new HashMap<String, Integer>();
        List<String> answer = new ArrayList<String>();

        for (int i = 0; i < scoreperson.length; i++){
            score.put(scoreperson[i], 0);
        }
        for (int i = 0; i < newfri.length; i++){
            for (int j = 0; j < newfri[i].length; j++){
                for (int k = 0; k < scoreperson.length; k++){
                    if (newfri[i][j].equals(scoreperson[k]) == true)
                        score.put(scoreperson[k], score.get(scoreperson[k]) + 10);
                }
            }
        }
        for (int i = 0; i < newvisit.length; i++){
            for (int j = 0; j < scoreperson.length; j++){
                if (newvisit[i].equals(scoreperson[j]) == true)
                    score.put(scoreperson[j], score.get(scoreperson[j]) + 1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for(Map.Entry<String, Integer> entry : entryList){
            answer.add(entry.getKey());
        }
        return answer;
    }
    public static String[] makescore(String[] person, String user, String[][] newfri, String[] newvisit){
        StringBuffer anotherUser = new StringBuffer();

        for (int i = 0; i < newfri.length; i++){
            for (int j = 0; j < newfri[i].length; j++){
                for (int k = 0; k < person.length; k++){
                    if (newfri[i][j].equals(person[k]) == true){
                        if (j == 1 && newfri[i][0].equals(user) == false){
                            anotherUser.append(newfri[i][0]);
                            anotherUser.append(" ");
                        }
                        else if (j == 0 && newfri[i][1].equals(user) == false) {
                            anotherUser.append(newfri[i][1]);
                            anotherUser.append(" ");
                        }
                    }
                }
            }
        }
        int flag = 0;
        for (int i = 0; i < newvisit.length; i++){
            for (int j = 0; j < person.length; j++){
                if (newvisit[i].equals(person[j]) == true || newvisit[i].equals(user) == true){
                    flag = 1;
                }
            }
            if (flag == 0) {
                anotherUser.append(newvisit[i]);
                anotherUser.append(" ");
            }
            flag = 0;
        }
        String anoUser = anotherUser.toString();
        String[] setting = anoUser.split(" ");
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < setting.length; i++){
            set.add(setting[i]);
        }
        Iterator iter = set.iterator();
        String[] result = new String[set.size()];
        int index = 0;
        while (iter.hasNext()){
            result[index] = iter.next().toString();
            index++;
        }

        return result;
    }
    public static String[] kindfrined(String[][] newfri, String user) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < newfri.length; i++){
            for (int j = 0; j < newfri[i].length; j++){
                if (user.equals(newfri[i][j]) == true){
                    if (j == 1)
                        result.append(newfri[i][0]);
                    else
                        result.append(newfri[i][1]);
                    result.append(" ");
                }
            }
        }
        String str = result.toString();
        String[] answer = str.split(" ");
        return answer;
    }
    public static String[][] newFriends(List<List<String>> friends){
        String[][] newfriends = new String[friends.size()][2];

        for (int i = 0; i < friends.size(); i++){
            for (int j = 0; j < 2; j++){
                newfriends[i][j] = friends.get(i).get(j);
            }
        }

        return newfriends;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        String[][] newfri;
        String[] newvisit = new String[visitors.size()];
        String[] scoreperson;

        for (int i = 0; i < visitors.size(); i++){
            newvisit[i] = visitors.get(i);
        }
        newfri = newFriends(friends);
        if (exception(newfri, user, newvisit) == false)
            return null;
        String[] person = kindfrined(newfri, user);
        scoreperson = makescore(person, user, newfri, newvisit);
        answer = makeresult(scoreperson, newfri, newvisit);
        return answer;
    }
}
