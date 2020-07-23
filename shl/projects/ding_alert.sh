#!/usr/bin/env bash
function send_ding() {
        body='{"msgtype": "text","text": {"content": "'$2'"},"at": {"atMobiles": ["'$3'"], "isAtAll": "false"}}'
#        echo $body
        curl -XPOST  -H "Content-type: application/json" "https://oapi.dingtalk.com/robot/send?access_token=$1" -d "$body"
}

function _main() {
    send_ding "6feb9fb764e41f3d703150e239ff8c17fb70b1830383e619f62eb9cc5c44af36"  "lec" "17150012018"
}

_main "$@"

