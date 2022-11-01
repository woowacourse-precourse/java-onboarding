## 🚀 기능 요구 사항

레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다. 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구
추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.

- 사용자와 함께 아는 친구의 수 = 10점
- 사용자의 타임 라인에 방문한 횟수 = 1점

사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은
순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라. 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

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

### 기능목록

> **<클래스1><br>
추천후보들의 이름과 점수를 갖는 Candidate객체를 정의한다.**<br>
*class Candidate* <br>

> **<클래스2><br>
점수에 따라 내림차순으로 정렬한 후, 동점이라면 이름순으로 정렬한다.**<br>
*class CandidatesComparator implements Comparator<Candidate>* <br>

> **<기능 1><br>
user의 친구들을 찾는다.**<br>
*private static List<String> getUserFriends(String user, List<List<String>> friends)* <br>
> - 기능 1-1<br>
    relation에 user의 친구가 있는지 확인하고 친구의 index를 반환한다.<br>
    *private static int getFriendIndex(String user, List<String> relation)*

> **<기능 2><br>
친구의 친구를 찾아서 리스트를 만들고 점수를 부여한다. 단, 이미 친구인 사람은 제외한다.**<br>
*private static List<Candidate> getCandidatesForRecommend(String user,
List<List<String>> friends, List<String> userFriends)*
> - 기능 2-1<br>
    친구관계가 아니거나, user본인이거나, 이미 친구관계인 경우 추가를 하지 않는다.<br>
    *private static boolean isSkip(String user, int friendIndex, List<String> relation,
    List<String> userFriends)*
> > - **기능 2-1-1. 친구관계가 아닌 경우를 판단**<br>
      *private static boolean isNoExistInRelation(int friendIndex)*<br>
> > - **기능 2-1-2. user본인인 경우를 판단**<br>
      *private static boolean isSameAsUser(String user, int friendIndex, List<String> relation)*<br>
> > - **기능 2-1-3. 이미 user와 친구관계인 경우를 판단**
      *private static boolean isExistInUserFriends(int friendIndex, List<String> relation,
      List<String> userFriends)*
> - 기능 2-2<br>
    친구의 친구에게 점수 10점을 부여하고 candidates 목록에 저장한다.<br>
    *private static void getPointsByFriend(int friendIndex, List<Candidate> candidates,
    List<String> relation)*


> **<기능 3><br>
방문자에게 점수 1점을 부여한다.**<br>
*private static void getVisitorPoints(List<Candidate> candidatesForRecommend,
List<String> visitors, List<String> userFriends)*
> - 기능 3-1<br>
    후보목록에서 후보자의 인덱스를 찾는다. 목록에 없는 경우 -1을 반환.<br>
    *private static int getNameIndex(String candidateName, List<Candidate> candidates)*
> - 기능 3-2<br>
    user의 친구목록에 존재하는 이름인지 확인한다.<br>
    *private static boolean isAlreadyFriend(int nameIndex, String visitor,
    List<String> userFriends)*

> **<기능 4><br>
추천목록을 점수순으로 정렬하고 동점일 경우 이름순으로 정렬한다.**<br>
*private static List<String> sortByAscendingOrder(List<Candidate> candidates)*
