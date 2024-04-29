#!/bin/bash
while true; do
    numastat >> numastat_log.txt
    sleep 60  # Collect data every minute
done
