package com.xz.designPattern.builder;


/**
 * @Package: com.xz.designPattern.builder
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/25 16:52
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Computer build = new ComputerBuilder().buildCpu("AMD").buildBoard("微星").buildMemory("镁光").build();
        System.out.println(build);
    }
}
class Computer{
    Cpu cpu;
    Board board;
    Memory memory;

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu +
                ", board=" + board +
                ", memory=" + memory +
                '}';
    }
}
class Cpu{
    String name;

    @Override
    public String toString() {
        return "Cpu{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Board{
    String name;

    @Override
    public String toString() {
        return "Board{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Memory{
    String name;

    @Override
    public String toString() {
        return "Memory{" +
                "name='" + name + '\'' +
                '}';
    }
}
class ComputerBuilder{
    private Computer computer = new Computer();
    public ComputerBuilder buildCpu(String name){
        Cpu cpu = new Cpu();
        cpu.name = name;
        computer.cpu = cpu;
        return this;
    }
    public ComputerBuilder buildBoard(String name){
        Board board = new Board();
        board.name = name;
        computer.board = board;
        return this;
    }
    public ComputerBuilder buildMemory(String name){
        Memory memory = new Memory();
        memory.name = name;
        computer.memory = memory;
        return this;
    }
    public Computer build(){
        return computer;
    }
}