package com.xz.designPattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.xz.designPattern.composite
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/14 20:28
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        root.addNode(new LeafNode("根上的叶子"));
        BranchNode branch1 = new BranchNode("根上的树杈1");
        branch1.addNode(new LeafNode("树杈1上的叶子"));
        BranchNode branch2 = new BranchNode("树杈1的树杈2");
        branch2.addNode(new LeafNode("树杈2上的叶子"));
        branch1.addNode(branch2);
        root.addNode(branch1);
        tree(root,0);
    }

    private static void tree(Node node,int depth){
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        node.p();
        if(node instanceof BranchNode){
            for(Node n :((BranchNode)node).list) {
                tree(n,depth+1);
            }
        }
    }
}
abstract class Node{
    abstract void p();
}
class LeafNode extends Node{

    private String name;

    @Override
    void p() {
        System.out.println(name);
    }

    public LeafNode(String name) {
        this.name = name;
    }
}
class BranchNode extends Node{

    private String name;
    List<Node> list = new ArrayList<>();

    @Override
    void p() {
        System.out.println(name);
    }

    public void addNode(Node n){
        list.add(n);
    }

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BranchNode{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
