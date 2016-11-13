#!/bin/bash
echo "Zamykam aplikacje mgc ..."
kill $(ps aux | grep '[m]gc-0.0.1-SNAPSHOT.jar' | awk '{print $2}')
