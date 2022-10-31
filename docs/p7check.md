## 문제7번 기능구현사항 정리

핵심 구현 idea : Map<String,ArrayList<String>> 형태의 자료구조를 사용해서 이름, 친구목록을 생성해준다.

user의 친구목록을 순회하면서 친구가 겹치는 인원점수체크, 방문한 인원점수 체크

static하게 관리되는 hashmap 리스트를 통해서 이름, 점수관리 점수순으로 정렬후 점수가 같다면 이름순으로 재정렬 한후 상위 5개를 출력

필수 구현 기능 목록 : friendmake , plusfriend, plusvisit

### 구현 메소드 명세

friendmake : 본인이름, 친구리스트 형식으로 hashmap생성

plusfriend : user의 친구목록을 순회하면서 각 인원의 친구목록에 indexof하면서 포함되어있다면 점수를 +10해준다

plusvisit : visit리스트 안에 포함된 인원점수를 + 해준다

minusUserFriend : score Map에서 현재 user와 친구되어있는 사용자 제외

sortBy : key값으로 score Map을 정렬해서 Value가 같을시 이름순으로 나올수있게 함 이후 value값으로 정렬 

fillMap : entryList형태를 Map으로 변환시킨다

entryReturn : Map형태를 entryList형태로 변환시킨다



