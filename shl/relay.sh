#!/usr/bin/env bash
user="shaofengfeng"
if [[ $# -gt 0 ]];then
  user="$1" 
fi
ac=$(python ~/sh/google_auth.py)
pswd="shuibaMf."
~/sh/nk.ex $ac $pswd $user
