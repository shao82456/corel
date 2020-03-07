#!/usr/bin/expect 

set auth_code [lindex $argv 0]
set password [lindex $argv 1]
set user [lindex $argv 2]
set timeout 30
spawn ssh $user@relay.zuoyebang.cc
expect {
    "*(yes/no)" {send "yes\n";exp_continue}
    "Verification code:" {send "$auth_code\n";exp_continue}
    "*assword:" {send "$password\n";}
}
interact 
