# Wordle Command Line Game
This Game was built for my personal project for the course Testing and Software Improvement.

## Running the game

### To play the game please run the GameEngine.java file as it contains the main method.

## About the game

- This game is based on wordle
- The user enters a 5 letter word as a guess. They're aiming to guess a randomly generated word.
- After entering their guess the user will be shown which letters were correct, present but in the wrong position and incorrect.
- The user will have 6 attempts to guess the word.
- If a user guesses the word correctly they will be given the option to play again.

## Testing

### Stub

- The GetWords class has been implemented using a stub.
- This class is the data loading class and includes a function to read in from a text file.
- I have used a strategy design patter using the GetWordsInterface interface which is implemented by both GetWords and StubGetWords.
- The test class TestGetWords uses this stub to test the functions using doubling.

### Fake

- I have used a fake to test the parts of my application that use the java scanner class.
- I have again implemented a strategy design pattern by using the UserInput interface which is used by the ScannerUserInput and FakeUserInput classes.
- The FakeUserInput class is then used to test aspects of the GameEngine class.

## Mocking

- I have used mocking throughout my testing.
- I have tested the GetWords class with mocking alongside the stub.
- This doesn't add to the code coverage but I wanted to use mocking in the data load just to make sure i got marks.
- I have also used mocking to test the GameEngine.

## Test Coverage

- I think I have achieved good code coverage with every class having either doubling tests or traditional unit tests.

