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

<br>

--- 

# 기능 구현 목록

## 친구 관계 그래프 만들기
- 친구 관계 그래프 `friendsMap` 를 만든다.
  - HashMap<String, ArrayList> 으로 선언하며, key(String)은 이름, value(ArrayList)는 직접적인 친구 관계를 맺는 친구 이름 리스트이다.
  - 그래프 초기화하기 : `friends` 리스트의 각 원소에 대해 다음의 과정을 반복한다.
    - 원소 리스트의 첫번째 요소, 두번째 요소를 각각 key-value 쌍으로 묶어 `friendsMap`에 추가한다.
      - key가 존재하는 경우, 해당 key의 value인 ArrayList에 값을 추가한다.
      - key가 존재하지 않는 경우, 새로운 key-value 쌍을 `friendsMap`에 추가한다.

### 예시

- `friendsMap = {’mrko’ : [’donut’, ‘Shakevan’], ‘donut’ : [’mrko’, ‘andole’, ‘Jun’], ... }`

<br>


### ****추천 친구 점수 맵 만들기****

- 각 친구에 대한 추천 점수를 담는 `UserScore` 클래스를 만든다.
    - 클래스 변수로는 name(이름)과 score(추천점수)를 포함한다.
    - `addScore()` 메서드를 통해, 방문자 또는 친구의 친구인 경우 추천 점수를 더하도록 한다.
- 친구 점수 목록 `scoreMap` 을 만든다. (user에게 추천할 친구 UserScore 목록)
    - UserScore 객체들을 담는 ArrayList<UserScore> 로 선언한다.
- `scoreMap` 에 아래의 추천 규칙에 따라 추천 점수를 추가한다.
    1. 친구의 친구인 경우 친구 점수 맵에서 해당 친구의  점수에 10점을 추가한다.
        - `friendsMap` 에서 `scoreMap` 리스트를 돌며 다음의 과정을 반복한다.
            - 친구의 친구 목록을 가져와 각 친구에 대해 다음의 과정을 반복한다.
            - `scoreMap` 에 해당 친구 이름에 해당하는 UserScore 인스턴스가 리스트에 존재하는 경우, `addScore(10)`  메서드 호출을 이용해 score 값에 10을 더한다.
            - 해당 인스턴스가 존재하지 않는 경우, 새로운 UserScore 객체를 생성(`new UserScore(name, 10)`  )하여 `scoreMap` 에 추가한다.
    2. 방문자인 경우 친구 점수 맵에서 해당 친구의 점수에 1점을 추가한다.
        - `visitors` 리스트의 요소를 돌며, 다음의 과정을 반복한다.
            - `scoreMap` 리스트에 해당 방문자 친구 이름을 갖는 인스턴스가 존재하는 경우, `addScore(1)` 메서드 호출을 통해 score 값에 1을 더한다.
            - 해당 인스턴스가 존재하지 않는 경우, 새로운 UserScore 객체를 생성(`new UserScore(name, 1)` ) 하여  `scoreMap` 에 추가한다.

### 예시

- `scoreMap ->  UserScore('donut', 10), UserScore('shakesevan, 10) ...`

<br>


## 정렬
- `scoreMap` 의 각 인스턴스를 score(점수)를 비교하여 내림차순 정렬한다.
  - socre 값이 동일한 경우에는 name(이름)을 비교하여 오름차순 정렬한다.

## 친구, 자기 자신을 목록에서 제외하기
- `friendsMap` 에서 user에 해당하는 친구 목록을 가져온다.
- `scoreMap` 리스트의 각 인스턴스를 돌며 다음의 과정을 반복한다.
    - `friendsName`에서 인스턴스의 name을 포함하지 않으며, user이름을 포함하지 않는 인스턴스라면 해당 인스턴스의 `name` 변수를 answer에 추가한다.
    
## 최대 5명 반환
- 최종 추천 친구 목록에, 정렬된 점수 맵에서 점수가 가장 높은 최대 5명을 넣는다.
  - 점수 맵의 목록이 5개 이하인 경우, 그대로 해당 목록을 답안으로 모두 반환한다.
  - 5개를 초과하는 경우, 5명으로 잘라 반환