package BomberMan.findRoad;

import java.util.Objects;

public class Node {
    public Node parent;
    public int yNode;
    public int xNode;
    public int gCost;
    public int hCost;
    public int fCost;
    public boolean open;
    public boolean checked;

    public Node() {
        System.out.println("cc");
    }

    public Node(int yNode, int xNode) {
        this.yNode = yNode;
        this.xNode = xNode;
    }

    public void setAsOpen() {
        this.open = true;
    }

    public void setAsChecked() {
        checked = true;
    }

    public void calCost(Node startNode, Node goalNode) {
        // reset Node trong game loop
        this.open = false;
        this.checked = false;
        // cal G Cost(the distance from the start Node)
        int xDistance = Math.abs(this.xNode - startNode.xNode);
        int yDistance = Math.abs(this.yNode - startNode.yNode);
        this.gCost = xDistance + yDistance;

        // cal H Cost(the distance from the goal Node)
        xDistance = Math.abs(this.xNode - goalNode.xNode);
        yDistance = Math.abs(this.yNode - goalNode.yNode);
        this.hCost = xDistance + yDistance;

        // cal F Cost(The total cost)
        this.fCost = this.gCost + this.hCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return yNode == node.yNode && xNode == node.xNode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yNode, xNode);
    }
}
