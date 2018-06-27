package com.company.MiscSpike.PureAction;

public class ConsolePrintAction extends ActionBase<Void> {

    private String message;

    public ConsolePrintAction message(String msg) {
        this.message = msg;
        return this;
    }

    @Override
    protected boolean isDataReady() {
        return this.message != null;
    }

    @Override
    protected Void innerInvoke() {
        System.out.println(this.message);
        return null;
    }
}
