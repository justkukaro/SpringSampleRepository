#!/usr/bin/env bash

os_name=`uname`
is_md5sum=`which md5sum | wc -c`
war='DummyGen-1.0-SNAPSHOT.war'
hash_txt='hash.txt'

function mvn_install(){
    md5sum ./DummyGen/target/${war} >> hash.txt
    cd DummyGen && mvn install
    cd ..
}

if [[ ${is_md5sum} -gt 0 ]];then
    echo 'already installed md5sum'
else
    echo 'install md5sum'
    if [[ ${os_name} == *"Darwin"* ]];then
        brew install md5sha1sum
    fi
fi

mvn_install

if [[ -f ${hash_txt} ]];then
    echo 'hash file exist'
    prev=`md5sum ./DummyGen/target/${war}`
    pres=`cat hash.txt`
    if [[ ${prev}==${pres} ]];then
        echo 'hash file not changed'
    else
        echo 'hash file changed'
    fi
else
    echo 'hash file not exist'
fi

#run myubuntu instance
cp ./DummyGen/target/${war} ./myubuntu/
docker build -t myubuntu ./myubuntu/
docker-compose -f ./myubuntu/docker-compose.yml up -d
rm ./myubuntu/${war}
