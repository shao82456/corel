#!/usr/bin/env bash
#读取用户输入
read -p "Please enter your age: " age
days=$[ $age * 365]
echo "That makes you over $days days old!"

if read -t 5 -p "Please enter your name: " name
then
  echo "Hello $name, welcome to my script"
else
  echo
  echo "Sorry, too slow! "
fi

#read -s 读取密码

#read 按行读取文件
count=1
cat test | while read line
do
  echo "Line $count: $line"
  count=$[ $count + 1]
done
echo "Finished processing the file"