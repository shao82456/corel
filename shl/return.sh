#!/usr/bin/env bash

function demoFun1(){
    return 0
}

function demoFun2(){
    return 12
}

if demoFun1;then
    echo true
else
    echo false
fi

demoFun2
if [[ $? == 12 ]];then
    echo "a"
else
    echo "ab"
fi