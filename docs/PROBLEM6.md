# 🚀 기능 구현 목록
## Class
### CompareName
#### Methods
1. 생성자 (In : List<List<String>>)
nameList를 받아서 두 글자 단위로 잘라 splittedNames에 저장.
2. CheckException (In : List<List<String>> / Out : Exception)
주어진 제한 사항에 맞춰 예외 처리하는 메소드
3. findDuplicated (In : None / Out : List<String>)
   (Set) setCompare에 splittedName을 입력해가며 동일값이 2개 이상 들어가는 경우에는 (Set) setDuplicated에 추가한다. setDuplicated를 List<String> 타입으로 변경한 후 반환.
4. findCrews (In : List<List<String>>, List<String> / Out : List<Stirng>)
닉네임이 두글자 이상 연속으로 중복된 크루원들의 이메일을 (List<String>) answer에 저장하고 사전순으로 정렬한 후 반환.