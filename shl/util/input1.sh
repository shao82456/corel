#!/usr/bin/env bash
# $* 将所有参数存为一个单词，$@ 保存为多个独立的单词

#处理选项
while [ -n "$1" ]
do
  case "$1" in
  -a) echo "Found the -a option" ;;
  -b) echo "Found the -b option" ;;
  -c) echo "Found the -c option" ;;
  *) echo "$1 is not an option" ;;
  esac
  shift
done