## Description
- 이미지 서버입니다.
- EKS(쿠버네티스) sns cluster 내부에 존재합니다.
<br>

## 역할 ✏️
- 이미지를 업로드, 조회할 수 있습니다.
- 이미지 업로드 시 id(string) 값을 반환하고, 해당 id 로 이미지를 조회 가능합니다.
- 리사이징을 통해 썸네일 이미지를 별도로 저장합니다.
<br>

## 테스트 ✅

* 이미지 저장 API
> POST /api/images/upload
> MultiPart 파일을 보냅니다.
> 
![스크린샷 2024-05-22 오전 2 01 51](https://github.com/sns-service/image-server/assets/56336436/bb611a36-5636-4df5-aef2-edd8d82b0b79)

<br>

## 결과 확인 
* 원본 이미지

> GET {{ URL }}/api/images/view/{imageId}

* 썸네일 이미지

* 원본 이미지?thumbnail=true
![스크린샷 2024-05-22 오전 2 06 15](https://github.com/sns-service/image-server/assets/56336436/07676b8a-7b98-48e8-b7e1-56e5f5c448df)
