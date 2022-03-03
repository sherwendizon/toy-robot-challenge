# Toy Robot Coding Challenge

The application is a simulation of a toy robot moving on a square table top, of dimensions 5 units x 5 units. There are no
other obstructions on the table surface. The robot is free to roam around the surface of the table, but must be prevented
from falling to destruction. Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.

## Game Commands

```bash
[1] PLACE X,Y,NORTH | SOUTH | EAST | WEST (i.e PLACE 0,1,NORTH)
[2] MOVE
[3] LEFT
[4] RIGHT
[5] REPORT
[6] CMD
[7] EXIT
Note: Commands are CASE sensitive.
```

## Sample Usage
```bash
PLACE 0,0,NORTH
Command executed SUCCESSFULLY!
MOVE
Command executed SUCCESSFULLY!
REPORT
0,1,NORTH
```

## How to RUN the App

This is a Maven based Java application.

```bash
1. Clone this project.
2. Compile using maven compile command: mvn compile.
3. Run by invoking mvn exec:java command.
```