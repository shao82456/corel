#!/usr/bin/env bash

#处理选项参数
while [ -n "$1" ]
do
  case "$1" in
  -a) echo "Found the -a option"
      a="$2"
      shift;;
  -b) echo "Found the -b option" ;;
  -c) echo "Found the -c option"
      c="$2"
      shift;;
  *) echo "$1 is not an option" ;;
  esac
  shift
done

if [ -n "$a" ];then
  echo "arg a is:$a"
fi

if [ -n "$c" ];then
  echo "arg c is:$c"
fi