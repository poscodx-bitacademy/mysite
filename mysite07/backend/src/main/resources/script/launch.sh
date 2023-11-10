#! /bin/bash

APPLICATION_NAME=mysite07
SCRIPT_DIR=$(cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd)
PID=$(ps -ef | grep java | grep $APPLICATION_NAME.jar | awk '{print $2}')

if  [ ! -z "$PID" ] 
then
	echo "stopping [$APPLICATION_NAME]"
	kill -9 $PID
	sleep 10
fi

echo "starting [$APPLICATION_NAME]"
cd $SCRIPT_DIR
nohup java -Dspring.profiles.active=production -jar $SCRIPT_DIR/$APPLICATION_NAME.jar >> $SCRIPT_DIR/launch.log &