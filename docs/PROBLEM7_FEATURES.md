## 🚀 기능 요구 사항
* [ ] 사용자(Member)
  * instance variables
    * 사용자 아이디(String) : userId
    * 친구관계 정보(Set<Member>) : friends
    * 사용자 타임 라인 방문한 사용자 기록(Map) : visitors
    * 친구 추천 점수(int) : friendProposalScore
  * instance method
    * 친구 추가
    * 사용자 타임 라인 방문
    * 점수 추가


* [ ] Top 5 친구 추천 목록 조회
  * [ ] 추천 점수 0점인 경우 제외
  * [ ] 추천 점수가 같은 경우는 이름순으로 정렬
