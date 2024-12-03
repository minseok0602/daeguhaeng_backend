# 대구 관광지 추천 및 계획 작성 웹서비스 "대구행" 백엔드 서버
---
관광지 추천 AI 플랫폼

주의: 이 프로젝트는 프론트엔드, 백엔드, AI가 각각 분리된 구조로 개발되었습니다.
데이터셋은 직접 크롤링하여 전처리 및 데이터 분석 과정을 거쳐 사용되었습니다.

프론트엔드 : https://github.com/jaaesung/DaeguHang/tree/yoonagi1210

AI : https://github.com/Jkwange/daeguhaeng_recommend_AI

### 프로젝트 개요

대구행의 서버는 서비스에 등록된 사용자 정보와 관광지 추천 AI API를 바탕으로 계획, 일정을 생성하여 DB에 저장, 관리하는 역할을 합니다.

### 시작하기(Getting Started)

프로그램 실행 전 아래 프로그램을 설치해주세요.

- JDK 17 (https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)



### 실행 방법

1. 해당 Repository의 URL을 복사한다.

2. git bash를 열어 해당 Repositor를 clone한다.

`git clone https://github.com/brothergiven/daeguhaeng_backend`

3. 해당 디렉토리에 접속하여 `chmod 755 ./gradlew` 명령어를 입력하여 gradlew를 실행시키기 위한 권한을 변경한다.

4. 권한 변경이 완료되면 `./gradlew build` 명령어를 입력하여 프로젝트를 빌드한다.

5. `./gradlew bootRun` 명령어를 입력하여 프로젝트를 실행한다.

6. 프로젝트가 성공적으로 실행되었는지 확인한다.
