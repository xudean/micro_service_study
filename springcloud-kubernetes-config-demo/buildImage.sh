mvn clean package -Dmaven.test.skip=true
docker build -t registry.cn-shanghai.aliyuncs.com/virtuex/springcloud-kubernetes-config-demo:latest .
docker push registry.cn-shanghai.aliyuncs.com/virtuex/springcloud-kubernetes-config-demo:latest