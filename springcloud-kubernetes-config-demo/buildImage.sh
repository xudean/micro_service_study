mvn clean package -Dmaven.test.skip=true
docker build -t registry.cn-shanghai.aliyuncs.com/virtuex/springcloud-kubernetes-config-demo:0.0.1 .
docker push registry.cn-shanghai.aliyuncs.com/virtuex/springcloud-kubernetes-config-demo:0.0.1