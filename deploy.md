- (1) 启动脚本 start.sh
- nohup java -jar eladmin-system-2.6.jar --spring.profiles.active=prod > nohup.out 2>&1 &
- (2) 停止脚本 stop.sh
  - PID=$(ps -ef | grep eladmin-system-2.6.jar | grep -v grep | awk '{ print $2 }')
  - if [ -z "$PID" ]
  - then
  - echo Application is already stopped
  - else
  - echo kill -9 $PID
  - kill -9 $PID
  - fi

    
- 注意：
    - chmod +x start.sh 将文件修改为可执行文件
    - sh start.sh 执行