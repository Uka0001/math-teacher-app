# :teacher: CLI Math Application for teachers :woman_teacher:

## :writing_hand: Summary:
CLI Math Application for teachers and students that allows
input math equations with its roots, validate, save 
or find them from database. Used strategy, dao
and command handlers patterns.

## :computer: Used technologies:
- Java17,
- Maven,
- Hibernate,
- MySQL,
- Checkstyle,
- Graalvm js script engine,
- Mockito,
- Lombok,
- Maven-jar-plugin

## :flashlight: Used patterns:
- Strategy, 
- DAO,
- 3 layered architecture

## :abacus: Functionality:
- input and save math equations to db,
- input and save math equations with its roots to db,
- input and save roots to db,
- find equation from db by root value,
- find equation from db by roots number,
- check if number is valid equation root,
- check brackets in equation,
- check syntax in equation(no math operators
one after another except of - after math operator),
- display help information with command in CLI,
- exit from running app in CLI

## :rocket: Project SetUp:
1. Clone this repo.
2. Install Java17, IntelliJ IDEA, MySQL if you don`t have some.
3. Open cloned repo in IntelliJ IDEA.
4. Init your MySQL DB from init_db.sql file in resources folder.
5. Input your login and password and other credentials in hibernate.cfg.xml
file in resources folder.
First variant to start app:
6. Start app from Main.java file in org/example/ root.
(Optional) Second variant to start app:
6. Run in your IntelliJ IDEA terminal command:
"java -jar math-teacher-app-1.0-SNAPSHOT.jar" to start your work with app.
7. Enter command "help" to see the list of commands to start your work with app.
8. When you finished your work enter "exit" command to exit from app.

## :film_projector: Video presentation of working app
You can check app functionality in my video:
https://www.loom.com/share/e44a011db6534f3988902b4d86734a07

:envelope: I would like to hear your feedback for this app, so don`t hesitate to contact me via
my contacts on the main page of my gitHub profile.

Good luck. With :hearts: love from :ukraine: Ukraine! :smiley: