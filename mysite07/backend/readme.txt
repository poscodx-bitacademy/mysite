mysite07: backend

1.  테스트(개발모드)

    eclipse ctrl+f11 (스프링부트 애플리케이션 실행)



2.  빌드

    1)  working directory

        mysite

    2)  빌드 명령

        # mvn -f mysite07/backend exec:exec clean package

    3)  빌드 테스트

        # java -Dspring.profiles.active=production -jar mysite07/backend/target/mysite07.jar



3.  배포

    1)  ssh 연결(ssh key 인증)

        - key 생성하기

            # ssh-keygen -t rsa -b 2048 -m PEM -C "kickscar@gmail.com"

        - key 생성 확인

            private key(개인키): ~/.ssh/id_rsa
            public key(공개키) : ~/.ssh/id_rsa.pub

        - 공개키 서버 설치

            # mv ~/.ssh/id_rsa.pub ~/.ssh/authorized_keys

        - private key 보관

            id_rsa 파일의 내용을 mykey.pem 파일로 로컬에 잘 보관할 것

        - 접속 테스트

            # ssh -i mykey.pem root@192.168.0.172

    2)  접속 환경 설정

        - ~/.ssh/environment 생성

        - 내용 예시

          =======

          PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/local/poscodx2023/java/bin:/usr/local/poscodx2023/git/bin:/usr/local/poscodx2023/maven/bin:/usr/local/poscodx2023/mariadb/bin:/root/bin

          =======

        - PATH 환경 변수 설정, 특히 java 실행 패쓰 신경 쓸 것
        
        - /etc/ssh/sshd_config 의
          PermitUserEnvironment yes
          
        - sshd 재실행 
          # systemctl restart sshd   

    3)  Publish Over SSH 플러그인(Jenkins) 설정

        - Publish Over SSH 플러그인 설치
        - Dashboard > Jenkins 관리 > System

            배포/실행 서버(SSH Server) 등록: springboot-publish-server

        - 빌드/배포 프로젝트에 빌드후 조치(post-build action)의 send build artifacts over ssh 설정

            1.  mysite07.jar: transfer

            2.  launch.sh: transfer + execution

