package sample;

public class Test {

    static AbstractNode pn1 = new PositiveNode();
    static AbstractNode pn2 = new PositiveNode();
    static AbstractNode pn3 = new PositiveNode();

    static AbstractNode nn1 = new NegativeNode();
    static AbstractNode nn2 = new NegativeNode();
    static AbstractNode nn3 = new NegativeNode();

    static LogicGate lg = new LogicGate(LogicGateType.XNOR);

    public static void main(String[] args) {
        Connection c1 = new Connection(pn1, lg.getInNode(0));
        Connection c2 = new Connection(pn2, lg.getInNode(1));
        printStats();
        pn1.setLogicValue(LogicValue.LOGICAL_LOW);
        printStats();
    }

    public static void printStats() {
        System.out.println("pn1: " + pn1.getLogicValue().getValue() + ", pn2: " +
                pn2.getLogicValue().getValue() + ", and: " + lg.getLogicValue().getValue());
    }
}
