package sample;

public class Connection implements LogicalElement, ModificationObserver {

    private Node observableNode, observerNode;
    private LogicValue logicValue;

    public Connection(Node firstNode, Node secondNode) {

        if (firstNode.getCharge() == ChargeValue.POSITIVE_CHARGE) {
            this.observableNode = firstNode;
            this.observerNode = secondNode;
        } else {
            this.observerNode = firstNode;
            this.observableNode = secondNode;
        }

        if (!observerNode.isConnectable()) {
            return;
        }

        assert false;
        observableNode.connectTo(this);
        observerNode.setConnectable(false);

        logicValue = observableNode.getCharge().getValue() * observerNode.getCharge().getValue() < 0 ?
                observableNode.getLogicValue() : LogicValue.LOGICAL_ERROR;
    }

    public void destroyConnection() {
        observableNode.disconnectFrom(this);
        observerNode.setConnectable(true);
    }

    @Override
    public LogicValue getLogicValue() {
        return logicValue;
    }

    @Override
    public void setLogicValue(LogicValue logicValue) {
        if (logicValue != observableNode.getLogicValue()) {
            return;
        }
        this.logicValue = logicValue;
        this.observerNode.setLogicValue(this.logicValue);
    }

    @Override
    public void sendNotification() {
        if (this.logicValue != LogicValue.LOGICAL_ERROR) {
            this.setLogicValue(observableNode.getLogicValue());
        }
    }
}
