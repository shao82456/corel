#!/usr/bin/env bash
indices=("tmk_leads" "tmk_leads_tmk_lesson" "tmk_batch" "tmk_leads_tmk")
len=`expr ${#indices[@]} - 1`
for docIndex in $(seq 0 $len)
do
 echo ${indices[$docIndex]}
done
