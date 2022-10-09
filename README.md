# Computer-database-gatling-project
Test the performance of the [computers database page](https://computer-database.gatling.io/computers)
## Scenarios performed with the following test
- Test loading the homepage get: /computers
- Test getting the add new computer's page get: /computers/new
- Test adding new computers post: /computers
- Test filtering the added computer get: /computers?f=machineType

## Gatling script definition includes the following information 
- Protocol setup
- Scenario definition
- Load simulation design
- Access the [script here](https://github.com/lindamukami/computer-database-gatling-project/blob/main/src/test/scala/com/gatling/tests/ComputerDatabase.scala)

- Test Report can be [found here] (https://github.com/lindamukami/computer-database-gatling-project/blob/main/target/gatling/computerdatabase-20221009094709346/index.html)
