package org.example.Graphics;
import java.awt.*;
import java.util.ArrayList;
public class DrawingFunctions {

    public static class DrawingFunctionsParameters {
        private final ArrayList<Object> parameters = new ArrayList<Object>();
        public DrawingFunctionsParameters() {}

        public void writeColor(Color color){
            parameters.add(color);
        }

        public Color readColor(int index){
            return (Color) parameters.get(index);
        }

        public void writeInt(int i){
            parameters.add(i);
        }

        public int readInt(int index){
            return (Integer) parameters.get(index);
        }

        public void writeString(String s){
          parameters.add(s);
        }

        public String readString(int index){
          return (String) parameters.get(index);
        }
    }
    private static DrawingHandler handler;
    private String drawFunction = "";
    private DrawingFunctionsParameters parameters = new DrawingFunctionsParameters();
    public DrawingFunctions(String function, DrawingFunctionsParameters parameters){
        this.drawFunction = function;
        this.parameters = parameters;
    }

    public void execute(Graphics2D g){
        switch(drawFunction) {
            case "FillRectangle":
                fillRect(g);
                break;
            case "FillCircle":
                fillCircle(g);
                break;
            case "FillSquare":
                fillSquare(g);
                break;
            case "DrawRectangle":
                drawRect(g);
                break;
            case "DrawCircle":
                drawCircle(g);
                break;
            case "DrawSquare":
                drawSquare(g);
                break;
            case "DrawText":
                drawText(g);
                break;
        }
    }

    public static void setHandler(DrawingHandler h){
        handler = h;
    }

    private void fillRect(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.fillRect(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(4));
    }

    public static void fillRect(int x, int y, int width, int height, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(width);
        params.writeInt(height);
        handler.addAction(new DrawingFunctions("FillRectangle", params));
    }

    public static void fillRect(int x, int y, int width, int height){
        fillRect(x,y,width,height,handler.getColor());
    }

    public void fillCircle(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.fillOval(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(3));
    }
    
    public static void fillCircle(int x, int y, int radius, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(radius);
        handler.addAction(new DrawingFunctions("FillCircle", params));
    }

    public static void fillCircle(int x, int y, int radius){
        fillCircle(x,y,radius,handler.getColor());
    }

    public void fillSquare(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.fillRect(parameters.readInt(1), parameters.readInt(2), parameters.readInt(3), parameters.readInt(3));
    }
    public static void fillSquare(int x, int y, int length, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(length);
        handler.addAction(new DrawingFunctions("FillSquare", params));
    }
    public static void fillSquare(int x, int y, int length){
        fillSquare(x,y,length,handler.getColor());
    }

    public void drawRect(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.drawRect(parameters.readInt(1), parameters.readInt(2), parameters.readInt(3), parameters.readInt(4));
    }
    public static void drawRect(int x, int y, int width, int height, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(width);
        params.writeInt(height);
        handler.addAction(new DrawingFunctions("DrawRectangle", params));
    }
    public static void drawRect(int x, int y, int width, int height){
        drawRect(x,y,width,height,handler.getColor());
    }
    public void drawCircle(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.drawOval(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(3));
    }

    public static void drawCircle(int x, int y, int radius, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(radius);
        handler.addAction(new DrawingFunctions("DrawCircle", params));
    }

    public static void drawCircle(int x, int y, int radius){
        drawCircle(x,y,radius,handler.getColor());
    }

    public void drawSquare(Graphics2D g){
        g.setColor(parameters.readColor(0));
        g.drawRect(parameters.readInt(1),parameters.readInt(2),parameters.readInt(3), parameters.readInt(3));
    }

    public static void drawSquare(int x, int y, int length, Color color){
        DrawingFunctionsParameters params = new DrawingFunctionsParameters();
        params.writeColor(color);
        params.writeInt(x);
        params.writeInt(y);
        params.writeInt(length);
        handler.addAction(new DrawingFunctions("DrawSquare", params));
    }

    public static void drawSquare(int x, int y, int length){
        drawSquare(x,y,length,handler.getColor());
    }

    public static void setColor(Color color){
        handler.setColor(color);
    }

    public static Color getColor(){
      return handler.getColor();
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

    public static void addDrawText(int x, int y, String text, Color color){
      DrawingFunctionsParameters params = new DrawingFunctionsParameters();
      params.writeColor(color);
      params.writeInt(x);
      params.writeInt(y);
      params.writeString(text);
      handler.addAction(new DrawingFunctions("DrawText", params));
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

    public static void drawText(int x, int y, String text, Color color, boolean newLine, int lineHeight){
        drawText(x,y,text,color,newLine,lineHeight, 0);
    }
  
    public static void drawText(int x, int y, String text, Color color, boolean newLine){
        drawText(x,y,text,color,newLine, 20);
    }

    public static void drawText(int x, int y, String text, Color color){
        drawText(x,y,text,color,false);
    }

    public static void drawText(int x, int y, String text){
      drawText(x,y,text,handler.getColor());
    }

    public void drawText(Graphics2D g){
      g.setColor(parameters.readColor(0));
      g.drawString(parameters.readString(3),parameters.readInt(1),parameters.readInt(2));
    }


}
