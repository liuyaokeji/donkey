//git凭证ID
def git_auth = "mySsh"
//git的url地址
def git_url = "https://gitee.com/liuyaokeji/donkey.git"
//镜像的版本号
def tag = "${tag}"
//Harbor的url地址
def harbor_url = "registry-vpc.cn-beijing.aliyuncs.com"
//镜像库项目名称
def harbor_project = "hongliangyao"
//Harbor的登录凭证ID
def harbor_auth = "47d8992a-a3ee-4887-a534-c35d6e760096"
node {
    // 从gitlab拉取代码
   stage('拉取代码') {
      checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
   }
   stage('编译构建') {
      sh 'mvn clean package -Dmaven.test.skip=true'
   }
   stage('构建镜像') {
       //定义镜像名称
       def imageName = "${project_name}:${tag}"

       sh "docker build -f donkey_web/Dockerfile -t  ${imageName} donkey_web/"
       //对镜像打上标签
       sh "docker tag ${imageName} ${harbor_url}/${harbor_project}/${imageName}"

       //把镜像推送到Harbor
       withCredentials([usernamePassword(credentialsId: "${harbor_auth}", passwordVariable: 'password', usernameVariable: 'username')]) {

           //登录到Harbor
           sh "docker login -u ${username} -p ${password} ${harbor_url}"

           //镜像上传
           sh "docker push ${harbor_url}/${harbor_project}/${imageName}"

           sh "echo 镜像上传成功"
       }

       //部署应用
        sshPublisher(publishers: [sshPublisherDesc(configName: 'lzy', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: "/yhl/CICD/deploy.sh > /yhl/CICD/shell.log 2>&1 $harbor_url $harbor_project $project_name $tag $port", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
   }
}

