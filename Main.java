import java.io.*;
import java.util.*;

import static java.lang.Character.toLowerCase;

public class Main {

    public String takeWord() throws  IOException{
        FileReader fileReader = new FileReader("E:\\Serious Projects\\Hangman\\src\\Words");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Random rand = new Random();
        int randIndex = 0;
        List<String> lines = new ArrayList<String>();

        String line;
        while((line = bufferedReader.readLine()) != null){
            lines.add(line);
            randIndex = rand.nextInt(lines.size());
        }
        bufferedReader.close();
        return lines.get(randIndex);
    }

    public char[] loadIntoArray(String word){
        char[] list;
        list = word.toCharArray();
        return list;
    }

    public char[] fillList(char[] list){
        for(int i=0; i<list.length; i++){
            list[i] = '.';
        }
        return list;
    }

    public char[] makeAGuess(char letter, int place, char[] list, char[] invisibleList){
        list[place] = letter;
        if(list[place] == invisibleList[place]){
            return list;
        }else{
            list[place] = '.';

        }

        return list;
    }


  public static void main(String[] args) throws IOException {

        Main mejn = new Main();
      String word = mejn.takeWord();
      mejn.loadIntoArray(word);
      char[] list = new char[word.length()];
      char[] invisibleList = word.toCharArray();
      mejn.fillList(list);

      System.out.print("Wylosowana fraza: ");
      for(int i=0; i<invisibleList.length; i++){
          System.out.print(invisibleList[i]);
      }

      System.out.println("\n\n\n");

      Scanner skaner = new Scanner(System.in);
      System.out.println("Podaj literę: ");
      char letter = skaner.next().charAt(0);
      System.out.println("Podaj numer miejsca: \n");
      int place = skaner.nextInt()-1;


      System.out.println(mejn.makeAGuess(letter, place, list, invisibleList));

  }
  }



