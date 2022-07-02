import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //printMatchingWords("fooa*bar", "src/regex01.txt", true);
        //printMatchingWords("foo.bar", "src/regex02.txt", true);
        //printMatchingWords("foo.*bar", "src/regex03.txt", true);
        //printMatchingWords("foo\\s*bar", "src/regex04.txt", true);
        //printMatchingWords("[fcl]oo", "src/regex05.txt", true);
        //printMatchingWords("[fcdlpb]oo", "src/regex06.txt", true);
        //printMatchingWords("[^mh]oo", "src/regex07.txt", true);
        //printMatchingWords("[j-m]oo", "src/regex08.txt", true);
        //printMatchingWords("[j-mz]oo", "src/regex09.txt", true);
        //printMatchingWords("[j-mJ-Mz]oo", "src/regex10.txt", true);
        printMatchingWords("x*\\.y*", "src/regex11.txt", true);
    }

    private static void printMatchingWords(String regex, String fileName, boolean printAll) {
        if (printAll) {
            printAllWords(fileName);
        }
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fr);
            String word;
            int lineNumber = 1;
            while ((word = bf.readLine()) != null) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(word);
                if(matcher.find()) {
                    System.out.println("Line " + lineNumber + ": " + word);
                }
                lineNumber++;
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAllWords(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fr);
            String word;
            while ((word = bf.readLine()) != null) {
                System.out.println(word);
            }
            System.out.println();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
