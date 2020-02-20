package sample;

import java.util.Collection;
import java.util.HashSet;

public abstract class AbstractNode implements Node {

    private ChargeValue chargeValue;
    private LogicValue logicValue;
    private Collection<ModificationObserver> connectedElements;
    private boolean isConnectable;

    public AbstractNode(ChargeValue chargeValue) {
        this.chargeValue = chargeValue;
        this.logicValue = LogicValue.LOGICAL_HIGH;
        this.isConnectable =true;
        connectedElements = new HashSet<>();
    }

    @Override
    public ChargeValue getCharge() {
        return chargeValue;
    }

    @Override
    public void connectTo(ModificationObserver mo) {
        connectedElements.add(mo);
    }

    @Override
    public void disconnectFrom(ModificationObserver mo) {
        connectedElements.remove(mo);
    }

    @Override
    public Collection<ModificationObserver> getConnectedElements() {
        return connectedElements;
    }

    @Override
    public boolean isConnectable() {
        return isConnectable;
    }

    @Override
    public void setConnectable(boolean isConnectable) {
        this.isConnectable = isConnectable;
    }

    @Override
    public LogicValue getLogicValue() {
        return logicValue;
    }

    @Override
    public void setLogicValue(LogicValue logicValue) {
        this.logicValue = logicValue;
        for (ModificationObserver mo : connectedElements) {
            mo.sendNotification();
        }
    }
}
