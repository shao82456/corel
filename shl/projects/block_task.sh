#!/usr/bin/env bash
. ./log.sh
function mark_result() {
    local exit_code="$1"
    local suffix="$2"
    if [[ $exit_code == "0" ]];then
      echo "success" >".S_FLAG_$suffix"
    else
      echo "fail" >".F_FLAG_$suffix"
    fi
}

function main(){
        cmd="$1"
        suffix="$2"
        eval "$cmd" > "task.log" 2>&1
        code=$?
        debug "exit_code=$code"
        mark_result $code $suffix
}

main "$@"