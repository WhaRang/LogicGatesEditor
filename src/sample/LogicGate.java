package sample;

import java.util.ArrayList;

enum LogicGateType {
    NOT("NOT", 1),
    AND("AND", 4),
    OR("OR", 4),
    NAND("NAND", 4),
    NOR("NOR", 4),
    XOR("XOR", 4),
    XNOR("XNOR", 4);

    private String name;
    private int maxInNodeNum;

    LogicGateType(String name, int maxInNodeNum) {
        this.name = name;
        this.maxInNodeNum = maxInNodeNum;
    }

    public String getName() {
        return name;
    }

    public int getMaxInNodeNum() {
        return maxInNodeNum;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class LogicGate implements ModificationObserver, LogicalElement {

    private static final int STD_IN_NODE_NUM = 2;

    private LogicValue logicValue;
    private LogicGateType type;
    private ArrayList<Node> inNodes;
    private Node outNode;
    private int maxInNodeNum;

    public LogicGate(LogicGateType type) {

        this.type = type;
        this.maxInNodeNum = type.getMaxInNodeNum();

        inNodes = new ArrayList<>(maxInNodeNum);
        int inNodeNum = Math.min(STD_IN_NODE_NUM, maxInNodeNum);

        for (int i = 0; i < inNodeNum; i++) {
            Node inNode = new NegativeNode();
            inNode.connectTo(this);
            inNodes.add(inNode);
        }

        outNode = new PositiveNode();
        outNode.setConnectable(false);

        computeLogicValue();
    }

    private void computeLogicValue() {
        switch (type) {

            case NOT: {
                LogicValue lv = inNodes.get(0).getLogicValue() == LogicValue.LOGICAL_HIGH ?
                        LogicValue.LOGICAL_LOW : LogicValue.LOGICAL_HIGH;
                outNode.setLogicValue(lv);
                break;
            }

            case AND: {
                int iLv = 1;
                for (Node inNode : inNodes) {
                    iLv *= inNode.getLogicValue().getValue();
                }
                LogicValue lv = iLv > 0 ? LogicValue.LOGICAL_HIGH : LogicValue.LOGICAL_LOW;
                outNode.setLogicValue(lv);
                break;
            }

            case OR: {
                int iLv = 0;
                for (Node inNode : inNodes) {
                    iLv += inNode.getLogicValue().getValue();
                }
                LogicValue lv = iLv > 0 ? LogicValue.LOGICAL_HIGH : LogicValue.LOGICAL_LOW;
                outNode.setLogicValue(lv);
                break;
            }

            case NOR: {
                int iLv = 0;
                for (Node inNode : inNodes) {
                    iLv += inNode.getLogicValue().getValue();
                }
                LogicValue lv = iLv > 0 ? LogicValue.LOGICAL_LOW : LogicValue.LOGICAL_HIGH;
                outNode.setLogicValue(lv);
                break;
            }

            case NAND: {
                int iLv = 1;
                for (Node inNode : inNodes) {
                    iLv *= inNode.getLogicValue().getValue();
                }
                LogicValue lv = iLv > 0 ? LogicValue.LOGICAL_LOW : LogicValue.LOGICAL_HIGH;
                outNode.setLogicValue(lv);
                break;
            }

            case XOR: {
                int iLv = 0;
                for (Node inNode : inNodes) {
                    iLv += inNode.getLogicValue().getValue();
                }
                LogicValue lv = iLv != 1 ? LogicValue.LOGICAL_LOW : LogicValue.LOGICAL_HIGH;
                outNode.setLogicValue(lv);
                break;
            }

            case XNOR: {
                int iLv = 0;
                for (Node inNode : inNodes) {
                    iLv += inNode.getLogicValue().getValue();
                }
                LogicValue lv = iLv != 1 ? LogicValue.LOGICAL_HIGH : LogicValue.LOGICAL_LOW;
                outNode.setLogicValue(lv);
                break;
            }
        }

        logicValue = outNode.getLogicValue();
    }

    @Override
    public void sendNotification() {
        computeLogicValue();
    }

    public Node getInNode(int i) {
        return inNodes.get(i);
    }

    public Node getOutNode() {
        return outNode;
    }

    public LogicGateType getType() {
        return type;
    }

    public int getMaxInNodeNum() {
        return maxInNodeNum;
    }

    @Override
    public LogicValue getLogicValue() {
        return logicValue;
    }

    @Override
    public void setLogicValue(LogicValue logicValue) {
    }
}
