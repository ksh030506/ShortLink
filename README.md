# ab180 recruit project
다음을 목적으로 생성되었습니다.

아래를 포함합니다.

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