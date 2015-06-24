#!/bin/sh

setupGrails() {
   # Adds latest version of grails to the path assuming bits have been downloaded to:
   #    ~/apps/grails/grails-X.Y.Z
   grailsHome=~/apps/grails/$(ls ~/apps/grails | grep grails | tail -1)
   PATH=$PATH:$grailsHome/bin
   which grails
   }

# Setup
echo "\nGrails Plugin Experiment"
cd $(dirname $0)
which grails || setupGrails
echo
grails --version

# Plugin
cd security
echo "\nBuilding plugin..."
grails install
echo
pluginDefinition=~/.m2/repository/org/centerkey/security/security/maven-metadata-local.xml
ls $pluginDefinition
cat $pluginDefinition

# Test app
cd ../bookstore
echo "\nRunning test app..."
grails clean
grails run-app
