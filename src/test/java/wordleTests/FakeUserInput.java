package wordleTests;

import wordle.UserInput;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class FakeUserInput implements UserInput {
    private Queue<String> inputQueue;

    public FakeUserInput(String... inputs) {
        this.inputQueue = new LinkedList<>(Arrays.asList(inputs));
    }

    @Override
    public String getNextLine() {
        if (inputQueue.isEmpty()) {
            throw new NoSuchElementException("No more input available");
        }
        return inputQueue.poll();
    }
}

