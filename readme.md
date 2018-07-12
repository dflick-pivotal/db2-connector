# db2-connector

# Quickstart
1. Clone the repo
2. cd into the repo
3. execute: mvn package
4. target your cf instance
5. execute: cf push
6. execute: cf create-service-broker db2-broker user password <uri to service broker app>
   example: cf create-service-broker db2-broker pivotal pivotal http://db2-broker.local.pcfdev.io
7. execute: cf enable-service-access db-broker (You could add which plan should be available for which org)
   example: cf enable-service-access db2-connector
8. execute: cf marketplace
```
service         plans                                description
db2-connector   location-x, location-y, location-z   Provides db connection strings 
```
9. execute: cf create-service db2-connector location-z mydb
10. push the app of your choice and bind the service
    example: cf push app
11. execute: cf bind-service app mydb
11. execute: cf env app 
```
System-Provided:
{
 "VCAP_SERVICES": {
  "db2-connector": [
   {
    "credentials": {
     "jdbcUrl": "jdbc:db2://db2inst1:db2inst1-pwd@dbserver.location_z.com:50000/mydb:currentSchema=bitmarck;user=db2inst1;password=db2inst1-pwd;"
    },
    "label": "db2-connector",
    "name": "mydb",
    "plan": "location-z",
    "provider": null,
    "syslog_drain_url": null,
    "tags": [
     "db2",
     "uri"
    ],
    "volume_mounts": []
   }
  ]
 }
}
```

# Remove things
1. cf us app mydb
2. cf ds mydb -f
3. cf disable-service-access db2-connector
4. cf delete-service-broker db2-broker -f