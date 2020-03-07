#!/usr/bin/env bash
function set_default_lib(){
	local p=$(basename $1)

	if [ $(echo $1 | grep -E "conf/online/$p$" | wc -l) -ne 0 ];then
		echo "../../lib"
	elif [ $(echo $1 | grep -E "conf/$p$" | wc -l) -ne 0 ];then
		echo "../lib"
	else
		echo "lib"
	fi
}

echo $(set_default_lib $1)
