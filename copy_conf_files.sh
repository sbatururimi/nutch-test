#!/bin/bash

for file in ./conf/*; do
        if [ -d "$file" ]; then
                cp -R "$file" ./nutch/
        else
                cp -R "$file" ./nutch/conf
        fi
done