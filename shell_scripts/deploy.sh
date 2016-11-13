#!/bin/bash
./stopmgc.sh
echo "Pobieram najnowsze kody ..."
cd kody
rm -rf ./*
git clone https://github.com/ecartmanPL/mgc.git
echo "Buduje ..."
cd mgc
git checkout master
mvn clean install
echo "Uruchamiam aplikacje ..."
cd $HOME/mgc
./startmgc.sh
