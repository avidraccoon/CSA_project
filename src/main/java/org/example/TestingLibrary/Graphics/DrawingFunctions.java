package org.example.TestingLibrary.Graphics;
import java.awt.*;
import java.util.ArrayList;



public class DrawingFunctions {


    /*
    private void fillRect(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.fillRect(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(4));
    }
    public void fillCircle(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.fillOval(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(3));
    }

    public void fillSquare(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.fillRect(parameters.readInt(1), parameters.readInt(2), parameters.readInt(3), parameters.readInt(3));
    }

    public void drawRect(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.drawRect(parameters.readInt(1), parameters.readInt(2), parameters.readInt(3), parameters.readInt(4));
    }
    public void drawCircle(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.drawOval(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(3));
    }

    public void drawSquare(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.drawRect(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(3));
    }

    public static ArrayList<String> splitNewLine(String str){
      ArrayList<String> lines = new ArrayList<String>();
      String temp = "";
      for (int i = 0; i<str.length(); i++){
        if (str.substring(i, i+1).equals("\n")){
          lines.add(temp);
          temp = "";
        }
        else{
          temp+=str.substring(i, i+1);
        }
      }
      if (temp.length() > 0) lines.add(temp);
      return lines;
    }

    public static ArrayList<String> splitText(ArrayList<String> lines, int length){
      ArrayList<String> newLines = new ArrayList<String>();
      ArrayList<String> temp;
      for (String line : lines){
        temp = splitText(line, length);
        for (String str : temp){
          newLines.add(str);
        }
      }
      return newLines;
    }

    public static ArrayList<String> splitText(String str, int length){
      ArrayList<String> lines = new ArrayList<String>();
      String temp = "";
      int index = 0;
      while (index<str.length()){
        temp += str.substring(index, index+1);
        if (temp.length()>=length){lines.add(temp); temp="";}
        index++;
      }
      if (temp.length()>0) lines.add(temp);
      return lines;
    }
  
    public static void drawText(int x, int y, String text, Color color, boolean newLine, int lineHeight, int lineLength){
      if (newLine){
        ArrayList<String> textList = splitNewLine(text);
        if (lineLength > 0){
          textList = splitText(textList, lineLength);
        }
        for (int i = 0; i<textList.size(); i++){
          addDrawText(x, y+i*lineHeight, textList.get(i), color);
        }
      }
      else{
        if (lineLength > 0){
          ArrayList<String> textList = splitText(text, lineLength);
          for (int i = 0; i<textList.size(); i++){
            addDrawText(x, y+i*lineHeight, textList.get(i), color);
          }
        }
        else{
          addDrawText(x, y, text, color);
        }
      }
    }

    public void drawText(Graphics2D g){
      g.setColor(parameters.readColor(0));
      g.drawString(parameters.readString(3),parameters.readInt(1),parameters.readInt(2));
    }

    */
}
