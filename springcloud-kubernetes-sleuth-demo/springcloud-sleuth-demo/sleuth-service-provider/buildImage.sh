mvn clean package -Dmaven.test.skip=true
docker build -t registry.cn-shanghai.aliyuncs.com/virtuex/sleuth-service-provider:0.0.1 .
docker push registry.cn-shanghai.aliyuncs.com/virtuex/sleuth-service-provider:0.0.1