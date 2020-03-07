#!/usr/bin/env bash
indices=("tmk_leads" "tmk_leads_tmk_lesson" "tmk_batch" "tmk_leads_tmk")
last=`expr ${#indices[@]} - 1`
for docIndex in $(seq 0 $last)
do
 echo ${indices[$docIndex]}
done
