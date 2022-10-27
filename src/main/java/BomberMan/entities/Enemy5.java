package BomberMan.entities;

import BomberMan.Map.Map;
import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import BomberMan.findRoad.Node;
import BomberMan.graphics.Sprite;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import static BomberMan.constValue.constValue.SCORE;

public class Enemy5 extends Enemy {
    private int frame;
    private State state;
    private State temp;
    private Point2D moveXY = new Point2D(0, 0);
    public Node[][] nodes = new Node[14][29];
    private boolean isCatching = false;
    private double speed = constValue.ENEMY2_SPEED;
    public Enemy5() {
        super();
        frame = 0;
        state = State.LEFT;
        temp = null;
//         Khoi tao mang Node de tim duong
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 29; j++) {
                nodes[i][j] = new Node(i, j);
            }
        }
    }

    public void update(Bomber man) {
        temp = null;
        if (!isAlive) {
            return;
        }
        switch (state) {
            case LEFT:
                this.moveXY = new Point2D(-this.speed, 0);
                this.move(moveXY);
                break;
            case RIGHT:
                this.moveXY = new Point2D(this.speed, 0);
                this.move(moveXY);
                break;
            case UP:
                this.moveXY = new Point2D(0, -this.speed);
                this.move(moveXY);
                break;
            case DOWN:
                moveXY = new Point2D(0, this.speed);
                this.move(moveXY);
                break;
            default:
                break;
        }
//        int thisX = (int) ((this.getPosition().getX() + constValue.ENTITY_SIZE / 2) / constValue.ENTITY_SIZE);
//        int thisY = (int) ((this.getPosition().getY() + constValue.ENTITY_SIZE / 2) / constValue.ENTITY_SIZE);
//        System.out.println("Start: " + thisX + " " + thisY);
        if (state != State.DIE) calculateState(man);
//            this.checkToMap();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void drawEnemy(GraphicsContext gc) {
        if (temp != null) state = temp;
        frame++;
        if (!isAlive) {
            if (frame >= 0 && frame < 15) {
                gc.drawImage(Sprite.doria_dead.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 15 && frame < 30) {
                gc.drawImage(Sprite.mob_dead1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 30 && frame < 45) {
                gc.drawImage(Sprite.mob_dead2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 45 && frame < 60) {
                gc.drawImage(Sprite.mob_dead3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame == 60) {
                SCORE += 600;
                constValue.ENEMIES--;
            }
            return;
        }
        if (frame >= 12) frame = 0;
        switch (state) {
            case STOP:
                gc.drawImage(Sprite.doria_left1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                break;
            case UP:
                if (frame >= 0 && frame < 4) {
                    gc.drawImage(Sprite.doria_left1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.doria_left2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 8 && frame < 12) {
                    gc.drawImage(Sprite.doria_left3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                break;
            case DOWN:
                if (frame >= 0 && frame < 4) {
                    gc.drawImage(Sprite.doria_right1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.doria_right2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 8 && frame < 12) {
                    gc.drawImage(Sprite.doria_right3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                break;
            case LEFT:
                if (frame >= 0 && frame < 4) {
                    gc.drawImage(Sprite.doria_left1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.doria_left2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 8 && frame < 12) {
                    gc.drawImage(Sprite.doria_left3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                break;
            case RIGHT:
                if (frame >= 0 && frame < 4) {
                    gc.drawImage(Sprite.doria_right1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.doria_right2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 8 && frame < 12) {
                    gc.drawImage(Sprite.doria_right3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                break;
            case DIE:
                frame = 0;
                isAlive = false;
                break;
        }
    }

    /*
    Tim duong di
     */

    //Openlist contains nodes which is being checked for evaluation
    ArrayList<Node> openList = new ArrayList<>();
    //Checkdlist contains nodes which we stepped on it before as a best candidate
//    ArrayList<Node> checkedList = new ArrayList<>();
    Stack<Node> bestPath = new Stack<>();
    private boolean goalReached = false;
    Node currentNode = null;
    Node startNode = null;
    Node goalNode = null;
    int step = 0;

    /**
     * A* algorithm
     * @param man goal
     */
    public void findRoad(Bomber man) {

        bestPath.clear();
        goalReached = false;
        openList.clear();
        int manX = (int) ((man.getPosition().getX() + constValue.FRAME_SIZE / 2) / constValue.ENTITY_SIZE);
        int manY = (int) ((man.getPosition().getY() + constValue.FRAME_SIZE / 2) / constValue.ENTITY_SIZE);
        goalNode = nodes[manY][manX];
        int thisX = (int) ((this.getPosition().getX() + constValue.ENTITY_SIZE / 2) / constValue.ENTITY_SIZE);
        int thisY = (int) ((this.getPosition().getY() + constValue.ENTITY_SIZE / 2) / constValue.ENTITY_SIZE);

        System.out.println("Start: " + thisY + " " + thisX);
        System.out.println("Goal: " + manY + " " + manX);


        //****************
        if (thisY == manY && thisX == manX) {
            return;
        }

        startNode = nodes[thisY][thisX];
        currentNode = nodes[thisY][thisX];
        //Tinh Cost
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 29; j++) {
                nodes[i][j].calCost(nodes[thisY][thisX], nodes[manY][manX]);
            }
        }
        autoSearch();
        if (bestPath.size() > 0) {
            Stack<Node> testprint = new Stack<>();

            testprint.addAll(bestPath);
            while (!testprint.isEmpty()) {
                Node temp = testprint.pop();
                System.out.println(temp.yNode + " " + temp.xNode);
            }

            int xpos = (int) this.getPosition().getX();
            int ypos = (int) this.getPosition().getY();

            System.out.print("next step is: ");
            Node nextNode = bestPath.pop();

//                System.out.println((int) this.getPosition().getY() + " " + (int) this.getPosition().getX());

            if (nextNode.xNode == thisX && nextNode.yNode > thisY) {
                state = State.DOWN;
            }
            if (nextNode.xNode == thisX && nextNode.yNode < thisY) {
                state = State.UP;
            }
            if (nextNode.xNode > thisX && nextNode.yNode == thisY) {
                state = State.RIGHT;
            }
            if (nextNode.xNode < thisX && nextNode.yNode == thisY) {
                state = State.LEFT;
            }
            //Xu ly neu quai bi mac nua nguoi
            if (xpos > thisX * constValue.ENTITY_SIZE && (state == State.UP || state == State.DOWN)) {
                temp = State.LEFT;
            } else if (xpos < thisX * constValue.ENTITY_SIZE && (state == State.UP || state == State.DOWN)) {
                temp = State.RIGHT;
            } else if (ypos < thisY * constValue.ENTITY_SIZE && (state == State.LEFT || state == State.RIGHT)) {
                temp = State.DOWN;
            } else if (ypos > thisY * constValue.ENTITY_SIZE && (state == State.LEFT || state == State.RIGHT)) {
                temp = State.UP;
            }

            System.out.println(state);
        }
    }

    /**
     * A* algorithm.
     */
    public void autoSearch() {
        while (!goalReached && step <= 300) {
            int x = currentNode.xNode;
            int y = currentNode.yNode;
            currentNode.setAsChecked();
//            checkedList.add(currentNode);
            openList.remove(currentNode);
            // open the up node
            if (y - 1 > 1) {
                openNode(nodes[y - 1][x]);
            }
            // down node
            if (y + 1 < 13) {
                openNode(nodes[y + 1][x]);
            }
            // left node
            if (x - 1 > 0) {
                openNode(nodes[y][x - 1]);
            }
            // right node
            if (x + 1 < 28) {
                openNode(nodes[y][x + 1]);
            }

            //Find the best node
            int bestNodeIndex = 0;
            int bestNodeCost = Integer.MAX_VALUE;
            for (int i = 0; i < openList.size(); i++) {
                // check if this Node's FCost is better ?
                if (openList.get(i).fCost < bestNodeCost) {
                    bestNodeIndex = i;
                    bestNodeCost = openList.get(i).fCost;
                } else if (openList.get(i).fCost == bestNodeCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;
                    }
                }
            }
            //After the loop, got the best node which is our next step
            if (openList.size() > 0) {
                currentNode = openList.get(bestNodeIndex);
            }

            if (currentNode.equals(goalNode)) {
                goalReached = true;
                System.out.println("DONE!!!!");
                trackThePath();
            }
            step++;
        }
    }

    /**
     * check node.
     *
     * @param node node to be checked
     */
    public void openNode(Node node) {
        if (!node.open && !node.checked
                && (Map.mapTitle[node.yNode][node.xNode] == constValue.GRASS
                || Map.mapTitle[node.yNode][node.xNode] == constValue.BRICK
                || Map.mapTitle[node.yNode][node.xNode] == constValue.ITEM_SHOW
                || Map.mapTitle[node.yNode][node.xNode] == constValue.ITEM
                || Map.mapTitle[node.yNode][node.xNode] == constValue.ITEM_WAIT)) {
            //If this node is opend yet, add it to the open list
            node.setAsOpen();
            node.parent = currentNode;
            openList.add(node);
        }
    }

    /**
     * back track and store the best path.
     */
    public void trackThePath() {
        Node current = goalNode;
        while (current != startNode) {
            bestPath.push(current);
            current = current.parent;
        }
    }

    public void calculateState(Bomber man) {
        Random generator = new Random();
        int cal;

        int x1 = (int) ((this.getPosition().getX() + 4) / constValue.ENTITY_SIZE);
        int x2 = (int) ((this.getPosition().getX() + constValue.ENTITY_SIZE - 4) / constValue.ENTITY_SIZE); // Frame_size - 10) / ...
        int y1 = (int) ((this.getPosition().getY() + 4) / constValue.ENTITY_SIZE);
        int y2 = (int) ((this.getPosition().getY() + constValue.ENTITY_SIZE - 4) / constValue.ENTITY_SIZE);
        if (isCatching) {
            if (moveXY.getX() > 0) {
                if (Map.mapTitle[y2][x2] == constValue.WALL || Map.mapTitle[y1][x2] == constValue.WALL || Map.mapTitle[y2][x2] == constValue.BOM_WAIT || Map.mapTitle[y1][x2] == constValue.BOM_WAIT || Map.mapTitle[y2][x2] == -2 || Map.mapTitle[y1][x2] == -2) {
                    this.setPosition((float) (x1 * constValue.ENTITY_SIZE), (float) (this.getPosition().getY()));
                    moveXY = new Point2D(0, 0);
                }
            } else if (moveXY.getX() < 0) {
                if (Map.mapTitle[y1][x1] == constValue.WALL || Map.mapTitle[y2][x1] == constValue.WALL || Map.mapTitle[y1][x1] == constValue.BOM_WAIT || Map.mapTitle[y2][x1] == constValue.BOM_WAIT || Map.mapTitle[y1][x1] == -2 || Map.mapTitle[y2][x1] == -2) {
                    this.setPosition((float) ((x1 + 1) * constValue.ENTITY_SIZE), (float) (this.getPosition().getY()));
                    moveXY = new Point2D(0, 0);
                }
            } else if (moveXY.getY() > 0) {
                if (Map.mapTitle[y2][x1] == constValue.WALL || Map.mapTitle[y2][x2] == constValue.WALL || Map.mapTitle[y2][x1] == constValue.BOM_WAIT || Map.mapTitle[y2][x2] == constValue.BOM_WAIT || Map.mapTitle[y2][x1] == -2 || Map.mapTitle[y2][x2] == -2) {
                    this.setPosition((float) (this.getPosition().getX()), (float) (y1 * constValue.ENTITY_SIZE));
                    moveXY = new Point2D(0, 0);
                }
            } else if (moveXY.getY() < 0) {
                if (Map.mapTitle[y1][x1] == constValue.WALL || Map.mapTitle[y1][x2] == constValue.WALL || Map.mapTitle[y1][x1] == constValue.BOM_WAIT || Map.mapTitle[y1][x2] == constValue.BOM_WAIT || Map.mapTitle[y1][x1] == -2 || Map.mapTitle[y1][x2] == -2) {
                    this.setPosition((float) (this.getPosition().getX()), (float) ((y1 + 1) * constValue.ENTITY_SIZE));
                    moveXY = new Point2D(0, 0);
                }
            }
        } else {
            if (moveXY.getX() > 0) {
                if (Map.mapTitle[y2][x2] != constValue.GRASS || Map.mapTitle[y1][x2] != constValue.GRASS) {
                    this.setPosition((float) (x1 * constValue.ENTITY_SIZE), (float) (this.getPosition().getY()));
                    moveXY = new Point2D(0, 0);
                }
            } else if (moveXY.getX() < 0) {
                if (Map.mapTitle[y1][x1] != constValue.GRASS || Map.mapTitle[y2][x1] != constValue.GRASS) {
                    this.setPosition((float) ((x1 + 1) * constValue.ENTITY_SIZE), (float) (this.getPosition().getY()));
                    moveXY = new Point2D(0, 0);
                }
            } else if (moveXY.getY() > 0) {
                if (Map.mapTitle[y2][x1] != constValue.GRASS || Map.mapTitle[y2][x2] != constValue.GRASS) {
                    this.setPosition((float) (this.getPosition().getX()), (float) (y1 * constValue.ENTITY_SIZE));
                    moveXY = new Point2D(0, 0);
                }
            } else if (moveXY.getY() < 0) {
                if (Map.mapTitle[y1][x1] != constValue.GRASS || Map.mapTitle[y1][x2] != constValue.GRASS) {
                    this.setPosition((float) (this.getPosition().getX()), (float) ((y1 + 1) * constValue.ENTITY_SIZE));
                    moveXY = new Point2D(0, 0);
                }
            }
        }
        // Tim duong bang A*
        double dISTANCE = this.getPosition().distance(man.getPosition());
        if (dISTANCE <= 4 * constValue.ENTITY_SIZE) {
            isCatching = true;
            step = 0;
            System.out.println("------------------");
            System.out.println("Finding");
            findRoad(man);
        } else {
            isCatching = false;
            goalReached = false;
        }
        if (moveXY.getX() == 0 && moveXY.getY() == 0 && !goalReached) { // Random vi tri di chuyen
            State temp = null;
            while (temp == null) {
                generator = new Random();
                cal = generator.nextInt();
                switch (cal % 4) {
                    case 0 -> {
                        if (Map.mapTitle[y2][x1 + 1] == constValue.GRASS || Map.mapTitle[y1][x1 + 1] == constValue.GRASS) {
                            state = State.RIGHT;
                            temp = state;
                            break;
                        }
                    }
                    case 1 -> {
                        if (Map.mapTitle[y1 + 1][x2] == constValue.GRASS || Map.mapTitle[y1 + 1][x1] == constValue.GRASS) {
                            state = State.DOWN;
                            temp = state;
                            break;
                        }
                    }
                    case 2 -> {
                        if (Map.mapTitle[y1][x2 - 1] == constValue.GRASS || Map.mapTitle[y2][x2 - 1] == constValue.GRASS) {
                            state = State.LEFT;
                            temp = state;
                            break;
                        }
                    }
                    case 3 -> {
                        if (Map.mapTitle[y2 - 1][x1] == constValue.GRASS || Map.mapTitle[y2 - 1][x2] == constValue.GRASS) {
                            state = State.UP;
                            temp = state;
                            break;
                        }
                    }
                }
            }
        }
    }
}
