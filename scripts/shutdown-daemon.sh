#!/bin/bash

kill $(ps aux | grep 'DaemonMain' | awk '{print $2}')