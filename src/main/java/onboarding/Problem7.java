package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        List<Person> personList = new ArrayList<>();
        int[][] friendsTable;
        List<String> names = new ArrayList<String>();
        List<Integer> scores = new ArrayList<Integer>(0);
        // 초기화
        int friendsTableSize = 0;

        personList.add(new Person(user));
        names.add(user);
        friendsTableSize++;

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String name = friends.get(i).get(j);
                // 처음 등장하는 이름이면 추가함
                if(!isExist(name, personList)){
                    personList.add(new Person(name));
                    names.add(name);
                    friendsTableSize++;
                }
            }
        }
        friendsTable = new int[friendsTableSize][friendsTableSize];

        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            if(!isExist(name, personList)){
                personList.add(new Person(name));
                names.add(name);
            }
        }
        for(int i = 0; i< names.size(); i++) {
            scores.add(0);
        }


        // 인접 행렬
        for (int i = 0; i < friends.size(); i++) {

            // friendsTable에서 친구 관계인거 1 표시
            // 이름이 같은 person의 인덱스로 접근
            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);
            friendsTable[names.indexOf(name1)][names.indexOf(name2)] = 1;
            friendsTable[names.indexOf(name2)][names.indexOf(name1)] = 1;

        }

        System.out.println("friendsTable");

        List<Integer> userFriends = new ArrayList<>();
        for (int i = 0; i < friendsTable.length; i++){
            if (friendsTable[0][i] == 1) {
                userFriends.add(i);
            }
        }

        // 친구 관계 점수 계산
        for (int i = 0; i < userFriends.size(); i++) {
            int userFriendIndex = userFriends.get(i);
            // user는 제외하므로 1부터 시작
            for (int j = 1; j < friendsTable.length; j++) {
                if (friendsTable[userFriendIndex][j] == 1) {
                    scores.set(j, scores.get(j) + 10);
                }
            }
        }


        // visitors 점수 계산
        for (int i=0; i < visitors.size(); i++) {
            int index = names.indexOf(visitors.get(i));
            scores.set(index, scores.get(index) + 1);
        }

        // 점수 출력
        for (int i = 0; i < names.size(); i++)
            System.out.print(names.get(i) + " ");
        System.out.println("");

        for (int i = 0; i < scores.size(); i++)
            System.out.print(scores.get(i) + " ");


        // 내림차순
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            map.put(names.get(i), scores.get(i));
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        // 정답
        for(Map.Entry<String, Integer> entry : entryList){
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
            if(entry.getValue() > 1) {
                answer.add(entry.getKey());
            }
        }

        return answer;
    }



    static boolean isExist(String name, List<Person> personList) {
        for (Person p: personList) {
            if(p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    public static class Person {
        private String name;
        private int score;

        public Person(String name) {
            this.name = name;
            score = 0;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }

}
