#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy linkSaver
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/linkSaver.war
