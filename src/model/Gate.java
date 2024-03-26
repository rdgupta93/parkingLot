package model;

import model.enums.GateStatus;
import model.enums.GateType;

public class Gate extends BaseModel{

    private GateType gateType;
    private int gateNumber;
    private String OperatorName;
    private GateStatus gateStatus;

    public Gate() {
    }

    public Gate(GateType gateType, int gateNumber, String operatorName, GateStatus gateStatus) {
        this.gateType = gateType;
        this.gateNumber = gateNumber;
        this.OperatorName = operatorName;
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public String getOperatorName() {
        return OperatorName;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
