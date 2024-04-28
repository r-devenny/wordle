package wordle;

import java.util.Scanner;

public class ScannerUserInput implements UserInput {
    private Scanner scanner;

    public ScannerUserInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getNextLine() {
        return scanner.nextLine();
    }
}

