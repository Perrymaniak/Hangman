import java.io.*;
import java.util.*;

import static java.lang.Character.toLowerCase;

public class Main {


    private String takeWord() throws  IOException{
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

    private void fillList(char[] list){
        for(int i=0; i<list.length; i++){
            list[i] = '.';
        }
    }

    private boolean makeAGuess(char letter, int place, char[] list, char[] invisibleList){
        list[place] = letter;
        if(list[place] == invisibleList[place]){
            for(int i=0; i<list.length; i++){
                System.out.print(list[i]);
            }

            return true;
        }else{
            list[place] = '.';
        }

        for(int i=0; i<list.length; i++){
            System.out.print(list[i]);
        }

        return false;
    }

  public static void main(String[] args) throws IOException {
      int errCount = 0;

          Main mejn = new Main();
          String word = mejn.takeWord();
          char[] list = new char[word.length()];
          char[] invisibleList = word.toCharArray();
          mejn.fillList(list);

          System.out.print("Wylosowana fraza: ");
          for (char anInvisibleList : invisibleList) {
              System.out.print(anInvisibleList);
          }

          System.out.println("\n\n\n");
          int goodCount = list.length;
      do {
          Scanner skaner = new Scanner(System.in);
          System.out.print("Podaj literę: ");
          char letter = skaner.next().charAt(0);
          System.out.print("Podaj numer miejsca: ");
          int place = skaner.nextInt() - 1;

          if(!mejn.makeAGuess(letter, place, list, invisibleList)){
              errCount++;
          }else{
              goodCount--;
          }

//          errCount=mejn.addErrorCounter(errCount);

      }while(errCount<5 && goodCount>0);
  }
  }


  //TODO: Exception handling



