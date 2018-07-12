mvn package
cf push
cf create-service-broker db2-broker pivotal pivotal http://db2-broker.local.pcfdev.io
cf enable-service-access db2-connector
cf cs db2-connector location-z mydb
cf push app
cf bs app mydb

cf us app mydb
cf ds mydb -f
cf disable-service-access db2-connector
cf delete-service-broker db2-broker -f