#!/usr/bin/env bash
#for遍历列表,for假定空格分割
for word in Hello World
do
    echo $word
done

for word in "Hello World"
do
    echo $word
done

#按行读文件
#IFS.OLD=$IFS
#IFS=$'\n'
#for line in $(cat "$0")
#do
#  echo $line
#done
#IFS=$IFS.OLD

#按行读取文件
#file="$0"
#while read line
#do
#echo $line
#done < $file

#遍历目录
for file in ./*
do
  if [ -d "$file" ];then
    echo "$file is a directory"
  elif [ -f "$file" ];then
    echo "$file is a file"
  fi
done