#!/usr/bin/env bash
#寻找可执行的文件
IFS.OLD=$IFS
IFS=:
for folder in $PATH
do
  echo "$folder:"
  for file in $folder/*
  do
    if [ -x $file ];then
      echo "    $file"
    fi
  done
done
IFS=$IFS.OLD