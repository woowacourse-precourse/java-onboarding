package onboarding;

import java.util.*; //너무 많이 사용해서 모든 것으로 바꾸어주었다.

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
        HashMap<String, Integer> idScore = new HashMap<String, Integer>();  //  아이디:점수 저장할 hashmap 생성
        acquaintancescore(friends, userFriendsList, userFriendsFriendsList,idScore); //함께 아는 친구 점수 계산
        visitscore(user, userFriendsList, idScore, visitors); // 방문 점수 계산
        List<Map.Entry<String, Integer>> list = new LinkedList<>(idScore.entrySet()); //hashmap의 <key,value>쌍 유지하며 정렬
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            @Override //value 기준으로 내림차순, 같으면 key 기준으로 오름차순 정렬
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                } return o1.getKey().compareTo(o2.getKey());
            }
        });
        // 순서 유지를 위해 LinkedHashMap을 사용
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        } //결과 sortedMap = HashMap 형식
        List<String> key = new ArrayList<>(); // key에 해당하는 아이디만 리스트에 모으기
        for(Map.Entry<String, Integer> entry : list){
            key.add(entry.getKey());
        }
        List<String> fin = new ArrayList<>();
        for(int i=0; i<userFriendsList.size(); i++) { //user와 이미 친구인 아이디가 포함되어 있다면 공백 처리
            if(key.contains(userFriendsList.get(i)) == true) {
                key.set(key.indexOf(userFriendsList.get(i)), " ");
            }
        }
        for(int i=0; i<key.size(); i++) { //공백을 제거하여 user와 이미 친구인 아이디 제거
            if(key.get(i) != " ") {
                fin.add(key.get(i));
            }
        }
        List<String> answer = new ArrayList<>();
        if(fin.size()>5) { //5명보다 많을 경우 5명만 answer 리스트에 저장하여 출력함.
            for(int i=0; i<5; i++) {
                answer.add(fin.get(i));
            }
        } else { //5명보다 적을 경우 그대로 answer 리스트에 저장하여 출력함.
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
        HashMap<String, Integer> visitScore = new HashMap<String, Integer>(); //방문 횟수당 점수 +1
        for(int i=0; i<visitors.size(); i++) {
            if(visitors.get(i).equals(user) == false && userFriendsList.contains(visitors.get(i)) == false) {//user, user와 이미 친구인 사람의 점수는 계산x
                visitScore.put(visitors.get(i), Collections.frequency(visitors, visitors.get(i))); //방문 횟수 세어서 저장
            }
        }
        visitScore.forEach((key, value) -> idScore.merge(key, value, (v1, v2) -> v1 + v2)); //방문 횟수 점수 hashMap과 함께 아는 친구 점수 hashMap 합치기

        return idScore; //합쳐진 idScore 반환
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine(); //유저 아이디 입력
        int friendsRelation = sc.nextInt(); // 친구 관계 수 입력

        String[][] arr = new String[friendsRelation][2];
        Scanner scanner = new Scanner(System.in); //친구 관계 아이디 입력
        for (int i=0; i<friendsRelation; i++) {
            String inputValue = scanner.nextLine();
            String[] splitValue = inputValue.split(",");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = splitValue[j];
            }
        }
        List<List<String>> friends = convertToList(arr);
        List<String> visitors = new ArrayList<>();
        int visitorNumber = sc.nextInt(); //방문자 수 입력
        for(int i=0; i<visitorNumber; i++) { //방문자 아이디 입력
            visitors.add(scanner.nextLine());
        }
        System.out.println(solution(user, friends, visitors));
    }
    public static List<List<String>> convertToList(String[][] arr) { //2차원 배열 -> 2차원 리스트
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
