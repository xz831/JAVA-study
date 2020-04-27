package com.xz.designPattern.command;

/**
 * @Package: com.xz.designPattern.command
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/27 20:54
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Content content = new Content();
        content.text="hello word!";
        InsertCommand insertCommand = new InsertCommand();
        insertCommand.content = content;
        insertCommand.doit();
        System.out.println(content.text);
        insertCommand.undo();
        System.out.println(content.text);
    }
}
abstract class BaseCommand{
    abstract void doit();
    abstract void undo();
}
class Content{
    String text;
}
class InsertCommand extends BaseCommand{
    Content content;
    String temp = "abc";
    @Override
    void doit() {
        content.text += temp;
    }

    @Override
    void undo() {
        content.text = content.text.substring(0,content.text.length()-temp.length());
    }
}
