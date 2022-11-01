package onboarding;


import java.util.*;

// Person class
class Person{
    String name;
    boolean friendFlag=false;
    boolean userself=false;
    List<Integer> friendList=new ArrayList<>();
    int score=0;
}
public class Problem7 {

    //친구의 친구 찾아서 점수 10++
    public static int findFriends() {

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();
        List<Person> people = new ArrayList<>();    //Person 리스트
        HashMap<String, Integer> personNum = new HashMap<>();   //Person, idx mapping
        int num = 0;

        // 1. friends -> Person 객체의 친구 리스트 만들기
        for (int i = 0; i < friends.size(); i++) {
            String fd1 = friends.get(i).get(0);
            String fd2 = friends.get(i).get(1);
            // 새로운 친구일 경우 객체에 넣어서 추가
            if (!personNum.containsKey(fd1)) {

            }
            if (!personNum.containsKey(fd2)) {

            }


            // 이미 친구인 사람 체크

        }

        //2. 친구의 친구 점수 처리 findFriends()

        //3. 방문자 점수 처리
        for (int i = 0; i < visitors.size(); i++) {
            //친구 관계가 아닐 경우 people에 저장
            if (!personNum.containsKey(visitors.get(i))) {

            }

            //방문했지만 친구관계가 아닌 방문자일 경우 1++

        }

        //4. people sort - 점수 높은순, 같으면 이름 오름차순

        //5. 점수가 0이 아닌 people.name -> answer

        return answer;
    }
}
