## 🚀 기능 요구 사항
* [x] Crew: 이메일과 닉네임을 가지는 도메인 단위이다. -> 클래스로 분리
* [x] 같은 글자가 연속적으로 포함 될 경우 해당 닉네임 사용을 제한하려 한다.
  * key: 닉네임의 subString
  * value: crew email
* O(n): List<List<String>> forms -> Crew 도메인으로 
* O(n * 닉네임 길이(1 <= 닉네임 길이 <= 20)) -> CrewMap 구성
* 따라서 O(n)
