# SENG3110 Software Testing
## Lab 4 
### Unit Testing the Java Coffee Maker Application

Please read the entire README before proceeding!!!

### Objectives

- Write a Test Plan for the Coffee Maker Application 
- Write JUnit Tests for the Coffee Maker Application

For each of the above objectives you will be playing a different role on the development team.

### Write a Test Plan

*You are the Quality Assurance (QA) Engineer for the Coffee Maker Project*

Create a Test Plan for the Coffee Maker program.  Use the included Template to create your Test Plan.

Make sure your Test Plan has written test cases that cover all of the functionality indicated in the Requirements document (and the class and sequence diagrams)

The requirements document, a class diagram, and sequence diagram are provided in this repo.

### Working with the Sample Code

*You are the Lead Developer for the Coffee Maker Project.*

The code is complete and functional.  Two versions of the code are provided.  One that has bugs (buggycode directory).  One that has been fixed (bugfixedcode directory). 

There are six (6) bugs.  Not all classes have bugs.

Pick a location on your computer and clone the repository:

``` git clone https://github.com/axbjos/seng3110coffeemaker.git ```

Review the code and directory structure before proceeding.  Don't just blindly follow instructions.

After cloning the code do the following to run the code:

Navigate to the "buggycode" directory and do the following:

```
javac Main.java
java Main
```

Interact with the program and become familiar with its operation.

*Repeat the above for the bug fixed code, by navigating to that directory and doing the same commands.*

See if you can spot a bug before proceeding.  There is an obvious bug with the operation of the main menu (in the Main.java class) that you should be able to spot right away.

**Unit Testing the Sample Code**

Determine what functionality in the requirements provided in the User Story Requirements document could be implemented as Unit Tests.

A JUnit testing file named CoffeeMakerTest.java has been placed into the buggy and bug fixed directories.  CoffeeMakerTest.java is identical in each.

*Give the Unit Tests a Try...*

Compile and run the CoffeeMakerTest.java file in each directory.  Review Lab 3 for directions on how to compile and run JUnit4 tests.

When ran in the "buggy code" directory, the CoffeeMakerTest unit tests will have three passing tests and one failing test. Review and understand what the passing tests are checking for - they have nothing to do with the 6 bugs tho...  The failing test is checking for one of the coding bugs.

Run the CoffeeMakerTest.java unit test in the "bug fixed code" directory and all tests pass.  What was fixed to make the test pass?

Locate the 5 other bugs in the code.

Hint: 1 of the bug is in Main.java as mentioned above.  It is however a Main Menu bug, so a unit test isn't necessary per se. Could it be unit tested? (like in lab 3)

The Developer needs to implement additional unit tests that identify the bugs in the buggy code.

Then verify that the tests pass in the bug fixed code.
