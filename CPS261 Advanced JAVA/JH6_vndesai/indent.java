import java.awt.*;
import java.util.*;
import java.io.*;

public classs indent{

    public static int lineColNum(String line){
        for(int i = 0; i < line.length(); i++){
            if(line[i] != ' '){
                return i;
            }
        }
        return -1;
    }

    public static bool indentationChecker(String fileName){
        FileInputStream reader = new FileINputStream(fileName);
        Deque<Integer> indents = new ArrayDeque<Integer>();
        while(reader.hasNextLine()){
            if(indets.poll() == null){
                indets.offerFirst(lineColNum(reader.nextLine()));
            }
            else{
                if(lineColNum(reader.nextLine()) > indets.peekFirst()){
                    indets.offerFirst(lineColNum(reader.nextLine()));
                }
                else if(lineColNum(reader.nextLine()) == indets.peekFirst()){
                    indents.removeFirst();
                }
                else{
                    return false;
                }
            }
        }

        if(indets.poll() == null){
            return true;
        }
        return false;
    }

    static void main(String args[]){
        for(int i = 0; i < args.length){
            boolean indentation = indentationChecker(args[i]);
            if(indentation){

            }
        }
    }
}