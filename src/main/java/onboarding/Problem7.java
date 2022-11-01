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
    public static int findFriends(int cnt, int perNum, List<Person> people) {
        if (cnt == 2) return 0;
        List<Integer> list = people.get(perNum).friendList;
        for (int i = 0; i < list.size(); i++) {
            if (cnt == 1 && people.get(list.get(i)).friendFlag == false && people.get(list.get(i)).userself == false)
                people.get(list.get(i)).score += 10;
            findFriends(cnt + 1, list.get(i), people);
        }
        return 0;
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
                personNum.put(fd1, num);
                Person per = new Person();
                per.name = fd1;
                if (fd1.equals(user)) per.userself = true;
                people.add(per);
                num++;
            }
            if (!personNum.containsKey(fd2)) {
                personNum.put(fd2, num);
                Person per = new Person();
                per.name = fd2;
                if (fd2.equals(user)) per.userself = true;
                people.add(per);
                num++;
            }
            int num1 = personNum.get(fd1);
            int num2 = personNum.get(fd2);
            people.get(num1).friendList.add(num2);
            people.get(num2).friendList.add(num1);

            // 이미 친구인 사람 체크
            if (fd1.equals(user)) people.get(num2).friendFlag = true;
            if (fd2.equals(user)) people.get(num1).friendFlag = true;
        }

        //2. 친구의 친구 점수 처리 findFriends()
        findFriends(0, personNum.get(user), people);

        //3. 방문자 점수 처리
        for (int i = 0; i < visitors.size(); i++) {
            //친구 관계가 아닐 경우 people에 저장
            if (!personNum.containsKey(visitors.get(i))) {
                personNum.put(visitors.get(i), num);
                Person per = new Person();
                per.name = visitors.get(i);
                people.add(per);
                num++;
            }

            //방문했지만 친구관계가 아닌 방문자일 경우 1++
            int perNum = personNum.get(visitors.get(i));
            if (people.get(perNum).friendFlag == false) people.get(perNum).score += 1;
        }

        //4. people sort - 점수 높은순, 같으면 이름 오름차순
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.score == o2.score) return o1.name.compareTo(o2.name);
                else return Integer.compare(o2.score, o1.score);
            }
        });

        //5. 점수가 0이 아닌 people.name -> answer
        for (int i = 0; i < 5; i++) {
            if (people.get(i).score == 0) break;
            answer.add(people.get(i).name);
        }
        return answer;
    }
}
