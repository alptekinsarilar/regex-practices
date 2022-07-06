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
        //printMatchingWords("x*\\.y*", "src/regex11.txt", true);
        //printMatchingWords("x*[#:.]y*", "src/regex12.txt", true);
        //printMatchingWords("x*[#:\\^]y*", "src/regex13.txt", true);
        //printMatchingWords("x*[#\\\\\\^]y*", "src/regex14.txt", true);
        //printMatchingWords("^foo.*", "src/regex15.txt", true);
        //printMatchingWords(".*bar$", "src/regex16.txt", true);
        //printMatchingWords("^foo$", "src/regex17.txt", true);
        //printMatchingWords("^[0-9]{3}$", "src/regex18.txt", true);
        //printMatchingWords("^[a-z]{4,6}$", "src/regex19.txt", true);
        //printMatchingWords("^(ha){4,}$", "src/regex20.txt", true);
        //printMatchingWords("^(ha){1,2}$", "src/regex21.txt", true);
        //printMatchingWords("^fooa+bar$", "src/regex22.txt", true);
        //printMatchingWords("^https?://website$", "src/regex23.txt", true);
        //printMatchingWords("^(log|ply)wood$", "src/regex24.txt", true);
        findAndPrintWithReplacedOnes("([0-9]+)x([0-9]+)", "src/regex25.txt", true);
    }

    private static void printMatchingWords(String regex, String fileName, boolean printAll) {
        if (printAll) {
            printAllWords(fileName);
        }
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fr);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher;
            String word;
            int lineNumber = 1;
            while ((word = bf.readLine()) != null) {
                matcher = pattern.matcher(word);
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

    private static void findAndPrintWithReplacedOnes(
            String searchPattern,String fileName, boolean printBefore) {
        if (printBefore) {
            printAllWords(fileName);
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            Pattern p = Pattern.compile(searchPattern);
            Matcher matcher;
            String line;
            while((line = br.readLine()) != null) {
                matcher = p.matcher(line);
                if (matcher.find()) {
                    line = matcher.replaceAll(matcher.group(1) + " pixel by " + matcher.group(2) + " pixel");
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
