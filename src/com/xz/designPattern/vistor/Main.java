package com.xz.designPattern.vistor;

/**
 * @Package: com.xz.designPattern.vistor
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/21 21:13
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        ComputerPart cpu = new Cpu();
        ComputerPart board = new Board();
        Visitor visitor = new VipPeople();
        cpu.accept(visitor);
        board.accept(visitor);
        System.out.println(visitor.total());
    }
}
abstract class ComputerPart{
    abstract void accept(Visitor v);
    abstract int price();
}
abstract class Visitor{
    int total = 0;
    abstract void cpu(ComputerPart c);
    abstract void board(ComputerPart c);
    int total() {
        return total;
    }
}
class Cpu extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.cpu(this);
    }

    @Override
    int price() {
        return 500;
    }
}
class Board extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.board(this);
    }

    @Override
    int price() {
        return 200;
    }
}
class NormalPeople extends Visitor{

    @Override
    void cpu(ComputerPart c) {
        total += c.price() * 0.9;
    }

    @Override
    void board(ComputerPart c) {
        total += c.price() * 0.85;
    }
}
class VipPeople extends Visitor{

    @Override
    void cpu(ComputerPart c) {
        total += c.price() * 0.7;
    }

    @Override
    void board(ComputerPart c) {
        total += c.price() * 0.6;
    }
}