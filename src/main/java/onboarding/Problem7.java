package onboarding;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriendsList = new ArrayList<>(); //user와 친구인 아이디 저장
        for(int i=0; i<friends.size(); i++) {
            for(int j=0; j<2; j++) {
                if(friends.get(i).get(j).equals(user) == true) {
                    String userFriends = (j==0)? friends.get(i).get(1):friends.get(i).get(0);
                    userFriendsList.add(userFriends);
                }
            }
        }

        Set<String> userFriendsFriendsSet = new HashSet<String>(); //set 형식으로 user의 친구의 친구인 아이디 저장
        for(int i=0; i<friends.size(); i++) {
            for(int j=0; j<2; j++) {
                for(int k=0; k<userFriendsList.size(); k++) {
                    if(friends.get(i).get(j).equals(userFriendsList.get(k)) == true) {
                        String userFriendsFriends = (j==0)? friends.get(i).get(1):friends.get(i).get(0);
                        userFriendsFriendsSet.add(userFriendsFriends);
                    }
                }
            }
        }
        List<String> userFriendsFriendsList = new ArrayList<String>(userFriendsFriendsSet); //다시 리스트 형식으로 변환
        if(userFriendsFriendsList.indexOf(user) != -1) {
            userFriendsFriendsList.remove(user);
        }
        HashMap<String, Integer> idScore = new HashMap<String, Integer>();  // user와 친구인아이디와 친구인 아이디:점수 저장
        acquaintancescore(friends, userFriendsList, userFriendsFriendsList,idScore); //함께아는 친구 수 계산
        visitscore(user, userFriendsList, idScore, visitors);
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(idScore.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            //Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<String> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList){
            key.add(entry.getKey());
            value.add(entry.getValue());
        }
        String[][] convert = new String[key.size()][2];

        for(int i=0; i<key.size(); i++) {
            for(int j=0; j<2; j++) {
                if(j==0) {
                    convert[i][0] = key.get(i);
                } else {
                    convert[i][1] = Integer.toString(value.get(i));
                }
            }
        }
        Arrays.sort(convert, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[1].toString().contentEquals(o2[1].toString()))
                    return o1[0].toString().compareTo(o2[0].toString());
                else
                    return o1[1].toString().compareTo(o2[1].toString());
            }
        });
        List<List<String>> tmp = convertToList(convert);
        List<String> fin = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        List<String> overlapRemove = new ArrayList<>();

        for(int i=0; i<tmp.size(); i++) {
            overlapRemove.add(tmp.get(i).get(0));
        }
        for(int i=0; i<userFriendsList.size(); i++) {
            if(overlapRemove.contains(userFriendsList.get(i)) == true) {
                overlapRemove.set(overlapRemove.indexOf(userFriendsList.get(i)), " ");
            }
        }
        for(int i=0; i<overlapRemove.size(); i++) {
            if(overlapRemove.get(i) != " ") {
                fin.add(overlapRemove.get(i));
            }
        }
        if(fin.size()>5) {
            for(int i=0; i<5; i++) {
                answer.add(fin.get(i));
            }
        } else {
            answer = fin;
        }
        return answer;
    }
    public static HashMap<String, Integer> acquaintancescore(List<List<String>> friends, List<String> userFriendsList, List<String> userFriendsFriendsList, HashMap<String, Integer> idScore) {
        //함께 아는 친구 점수 계산
        // 전체 목록에서 친구를 찾고, 그 옆에 있는 아이디가 친구의 친구의 목록에 있을 경우 +10점
        for(int i=0; i<userFriendsFriendsList.size(); i++) {
            int score = 0;
            for(int j=0; j<friends.size(); j++) {
                for(int k=0; k<2; k++) {
                    if(friends.get(j).get(k).equals(userFriendsFriendsList.get(i))) {
                        if(k==0 && userFriendsList.indexOf(friends.get(j).get(1))!= -1) {
                            score += 10;
                        } else if(k==1 && userFriendsList.indexOf(friends.get(j).get(0))!= -1) {
                            score += 10;
                        }
                    }
                }
            }
            idScore.put(userFriendsFriendsList.get(i), score);
        }
        return idScore;
    }
    public static HashMap<String, Integer> visitscore(String user, List<String> userFriendsList, HashMap<String, Integer> idScore, List<String> visitors) {
        HashMap<String, Integer> visitScore = new HashMap<String, Integer>(); //방문자 점수
        for(int i=0; i<visitors.size(); i++) {
            if(visitors.get(i).equals(user) == false && userFriendsList.contains(visitors.get(i)) == false) {//user, user와 이미 친구인 사람의 점수는 계산x
                visitScore.put(visitors.get(i), Collections.frequency(visitors, visitors.get(i)));
            }
        }
        visitScore.forEach((key, value) -> idScore.merge(key, value, (v1, v2) -> v1 + v2));

        return idScore;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        int friendsRelation = sc.nextInt();

        String[][] arr = new String[friendsRelation][2];
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<friendsRelation; i++) {
            String inputValue = scanner.nextLine();
            String[] splitValue = inputValue.split(",");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = splitValue[j];
            }
        }
        List<List<String>> friends = convertToList(arr);
        List<String> visitors = new ArrayList<>();
        int visitorNumber = sc.nextInt();
        for(int i=0; i<visitorNumber; i++) {
            visitors.add(scanner.nextLine());
        }
        System.out.println(solution(user, friends, visitors));
    }
    public static List<List<String>> convertToList(String[][] arr) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                list.add(arr[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}
