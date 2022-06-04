# K8s Practice
다음을 목적으로 생성되었습니다.
- K8s를 연습하고 DevOps 파이프라인을 연습하기 위해 생성되었습니다.

아래를 포함합니다.
- Create Short Link
- View Link Info
- Redirect Short Link -> Original Link

DB 설정 (파일)
```
docker run --rm --name local-ab180-recruit -d \
-v ${PWD}/schema:/docker-entrypoint-initdb.d \
-p 5422:5432 \
-e POSTGRES_PASSWORD='1234' \
-e POSTGRES_USER="admin" \
-e POSTGRES_DB="ab180-recruit"  \
postgres
```

DB 설정 (자동)
```
docker run --rm --name local-ab180-recruit -d \
-p 5422:5432 \
-e POSTGRES_PASSWORD='1234' \
-e POSTGRES_USER="admin" \
-e POSTGRES_DB="ab180-recruit"  \
postgres
```

루시드 차트 URL : https://lucid.app/lucidchart/8794c134-65cf-43c1-ad3b-bd5ca53e2ef2/edit?invitationId=inv_6309e4d8-4018-40ad-a805-84b5ea7d8971

swagger-ui : http://localhost:8082/swagger-ui.html