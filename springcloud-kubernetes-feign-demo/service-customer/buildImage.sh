mvn clean package -Dmaven.test.skip=true
docker build -t registry.cn-shanghai.aliyuncs.com/virtuex/service-customer:latest .
docker push registry.cn-shanghai.aliyuncs.com/virtuex/service-customer:latest