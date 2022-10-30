# 1주차_Problem7

## 🚀 기능 요구 사항

레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다. 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.

- 사용자와 함께 아는 친구의 수 = 10점
- 사용자의 타임 라인에 방문한 횟수 = 1점

사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라. 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

### 제한사항

- user는 길이가 1 이상 30 이하인 문자열이다.
- friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
- friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
    - A와 B는 친구라는 의미이다.
    - 아이디는 길이가 1 이상 30 이하인 문자열이다.
- visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
- 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
- 동일한 친구 관계가 중복해서 주어지지 않는다.
- 추천할 친구가 없는 경우는 주어지지 않는다.

### 실행 결과 예시

| user | friends | visitors | result |
| --- | --- | --- | --- |
| "mrko" | [ ["donut", "andole"], ["donut", "jun"], ["donut", "mrko"], ["shakevan", "andole"], ["shakevan", "jun"], ["shakevan", "mrko"] ] | ["bedi", "bedi", "donut", "bedi", "shakevan"] | ["andole", "jun", "bedi"] |

친구 관계를 구현하기 위해서 그래프 자료구조를 사용해야겠다고 생각했다. 그래프 내에서 사용될 정점을 구현한 Vertex클래스를 private static inner 클래스로 만들었다.

그래프에서만 사용할 것이며 외부에서 직접 접근하기 못하게 하기위해 private로 만들었고 바깥에서 참조하지 않기 때문에 static으로 만들어 메모리 사용을 최적화 했다.

정점은 한명의 사용자 정보를 포함하며 정점이 생성될 때 마다 index가 1씩 증가하며 할당한다.

```java
private static class Vertex implements Comparable<Vertex>
{
    private static final int InitScoreValue = 0;
    private static int nextUserIndex = 0;
    private String name;
    private Integer index;
    private int score;

    public Vertex(String name)
    {
        this.name = name;
        this.index = nextUserIndex++;
        score = InitScoreValue;
    }

    @Override
    public int compareTo(Vertex o) {

        if(score != o.score)
        {
            return o.score - score;
        }

        return name.compareTo(o.name);
    }

    @Override
    public String toString()
    {
        return "name: " + name +", score: " + score + ", index: " + index;
    }
}
```

사용자 이름을 정점으로 매핑하여 보관하는 HahsMap과 사용자가 쓰고있는 인덱스 번호로 매핑하는 HashMap을 만들었다. 

enrollUserAndReturnVertex()는 이름을 전달받아서 새로운 정점을 만드는 함수이다. 만약 기존에 존재한다면 조회하여 정점을 반환하고 그렇지 않으면 새로 생성해서 반환한다.

```java
public class Graph
{
    Map<String,Vertex> userNameToVertex = new HashMap<>();
    Map<Integer,Vertex> indexToVertex = new HashMap<>();
    Set<Integer>[] friendGraph;

    public Graph(int size)
    {
        friendGraph = new TreeSet[size];
        for(int i = 0 ; i < friendGraph.length;i++)
        {
            friendGraph[i] = new TreeSet<Integer>();
        }
    }

    public Vertex enrollUserAndReturnVertex(String userName)
    {
        Vertex vertex;
        if(userNameToVertex.containsKey(userName))
        {
            vertex = userNameToVertex.get(userName);
        }
        else
        {
            vertex = new Vertex(userName);
            userNameToVertex.put(userName,vertex);
            indexToVertex.put(vertex.index,vertex);
        }

        return vertex;
    }

    public void connect(String userName,String friendName)
    {
        Vertex userVertex = enrollUserAndReturnVertex(userName);
        Vertex friendVertex = enrollUserAndReturnVertex(friendName);
        friendGraph[userVertex.index].add(friendVertex.index);
        friendGraph[friendVertex.index].add(userVertex.index);
    }

}
```

updateScore함수를 이용하여 기준이 되는 회원의 이름과 방문자들을 전달 받아서 score를 갱신한다. 

updateScoreWithVisitors는 방문자를 기준으로 업데이트하고 updateScoreWithFriend는 사용자와 친구 관계인 경우를 기준으로 score를 갱신한다.

```java
public void updateScore(String userName,List<String> visitors)
{
    updateScoreWithVisitors(visitors);
    updateScoreWithFriend(userName);
}

private void updateScoreWithVisitors(List<String> visitors)
{
    for(int i = 0 ; i < visitors.size();i++)
    {
        Vertex visitorVertex = enrollUserAndReturnVertex(visitors.get(i));
        visitorVertex.score += Problem7.VISITOR_SCORE;
    }
}

private void updateScoreWithFriend(String userName)
{
    Vertex userVertex = enrollUserAndReturnVertex(userName);

    for(int i = 0 ; i < Vertex.nextUserIndex;i++)
    {
        Vertex vertex = indexToVertex.get(i);
        if(!isFriend(vertex,userVertex) && !isEqual(vertex ,userVertex))
        {
            calculateScore(vertex,userVertex);
        }
    }
}

private void calculateScore(Vertex vertex,Vertex userVertex)
{
    Set<Integer> userFriends = friendGraph[userVertex.index];
    for (Integer userFriendIndex: userFriends)
    {
        Vertex userFriendVertex = indexToVertex.get(userFriendIndex);
        if(isFriend(userFriendVertex,vertex))
        {
            vertex.score+=Problem7.FRIEND_SCORE;
        }
    }
}
```

친구 관계를 기준으로 점수를 산정할때 자신과 이미 친구이거나 혹은 자기 자신이 될때를 구분하기 위해서 다음과 같이 메소드를 만들었다.

```java
private boolean isEqual(Vertex userVertex,Vertex anotherUserVertex)
{
    return userVertex.index == anotherUserVertex.index;
}

private boolean isFriend(Vertex userVertex,Vertex anotherUserVertex)
{
    return friendGraph[userVertex.index].contains(anotherUserVertex.index);
}
```

정점들은 순회하면서 user와 이미 친구인 경우를 제외한 모든 정점을 우선순위 큐에 저장하였고 조건에 맞는 결과를 반환하기 위해서 getResult함수를 만들었다.

```java
private PriorityQueue<Vertex> getRecommendFriend(String userName)
{
    Vertex userVertex = enrollUserAndReturnVertex(userName);

    PriorityQueue<Vertex> recommendFriendStorage = new PriorityQueue<>();
    for(int i = 0 ; i < Vertex.nextUserIndex;i++)
    {
        Vertex vertex = indexToVertex.get(i);
        if(!isFriend(vertex,userVertex))
        {
            recommendFriendStorage.add(vertex);
        }
    }

    return recommendFriendStorage;
}

public List<String> getResult(String userName)
{
    PriorityQueue<Vertex> recommendFriendStorage = getRecommendFriend(userName);

    List<String> result = new LinkedList<>();
    int i = 0;
    while(!recommendFriendStorage.isEmpty() && i < Problem7.MAX_RETURN_SIZE)
    {
        Vertex vertex =recommendFriendStorage.remove();
        if(vertex.score != Problem7.EXCEPTION_SCORE)
        {
            result.add(vertex.name);
            i++;
        }
    }

    return result;
}
```