#!/usr/bin/env bash

#全局环境变量和局部环境变量

#全局环境变量，对shell会话和所有生成的子shell都是可见的
#查看,env/printenv
env
#定义
export a="b"
b="c"
export b

#局部环境变量，定义的进程中可见
#查看所有环境变量，包括局部，全局
set
#定义
a="b"
echo $a

#更改/删除
#父shell中的环境变量导出到子shell后，子shell无法删除或更改父shell的
unset

#默认的shell环境变量
echo "------default env----------"
echo $CDPATH
echo $HOME
echo $IFS
echo $PATH
echo $PS1