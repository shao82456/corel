target_host="192.168.32.110"
arg1_len=0

_help() {
    echo "Usage:"
    echo "relay"
    echo "relay xx.xx"
    echo "relay xx.xx.xx.xx"
}

if [[ $# -ge 1 ]];then
    arg1_len=$(echo $1|awk -F"." '{print NF}')
    if [[ $arg1_len == 4 ]];then
        target_host=$1
    elif [[ $arg1_len == 2 ]];then
        target_host="192.168.$1"
    else
        _help
        exit 1
    fi
fi
ssh homework@$target_host
