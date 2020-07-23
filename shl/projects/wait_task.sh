#!/usr/bin/env bash

base_dir=$(cd $(dirname $0);pwd)
source ./log.sh

function clear_flag() {
  c=$(ls -a|grep -e "\.._FLAG" |wc -l|sed -e "s/[[:space:]]*//g")
  if [[ "x$c" != "x0" ]];then
    ls -a|grep -e "\.._FLAG" |xargs rm
  fi
}

function check_submit() {
  suffix="$1"
  if [[ -f ".S_FLAG_$suffix" ]];then
    echo "0"
  elif [[ -f ".F_FLAG_$suffix" ]];then
    echo "1"
  else
    echo "2"
  fi
}

function on_start() {
    info "task begin"
}
function on_success(){
    info "task succeed"
}

function on_failed() {
    reason="${1:-noreason}"
    err "task failed , $reason"
}

function limited_waiting() {
    cmd="$1"
    limit_secs="$2"
    flag_file_suffix="$3"
    #start
    on_start
    clear_flag
    bash block_task.sh "$cmd" "$flag_file_suffix" > "/dev/null" 2 >&1 &

    #waiting
    total=0
    while [[ "x$(check_submit "$flag_file_suffix")" == "x2" && $total -le limit_secs ]]
    do
        sleep 1
        total=`expr $total + 1`
        debug "waiting"
    done

    debug "total=$total"
    if [[ $total -gt $limit_secs ]];then
        on_failed "waiting too long"
    elif [[ "x$(check_submit "$flag_file_suffix")" == "x0" ]];then
        on_success
    elif [[ "x$(check_submit "$flag_file_suffix")" == "x1" ]];then
        on_failed "task failed"
    else
        on_failed
    fi
}

function print_usage() {
    echo "limited waiting task execution"
    echo 'cmd=$1,limit_secs=$2,flag_file_suffix=$3'
}

function main(){
    if [[ "$#" -lt 3 ]];then
        print_usage
        exit 0
    fi
    limited_waiting "$@"
}

main "$@"