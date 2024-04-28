package wordle;

public class DisplayScreen {



    public void displayGameBoard(Word word) {
        System.out.println("------------------------------------ \n");
        for (int position : word.getLetters().keySet()) {
            Character[] letterState = word.getLetters().get(position);
            char letter = letterState[0];
            char state = letterState[1];

            switch (state) {
                case 'c':
                    System.out.println("\033[0;32m" + "[ " + letter + " ]");
                    break;
                case 'p':
                    System.out.println("\033[0;33m" + "[ " + letter + " ]");
                    break;
                case 'd':
                    System.out.println("\033[0;37m" + "[ " + letter + " ]");
                    break;
                default:
                    System.out.println("Error with printing board, stopping game ");
                    System.exit(0);
            }
            System.out.println("\033[0m"); // Reset color
        }
        System.out.println("\n ------------------------------------ \n");
    }
}

