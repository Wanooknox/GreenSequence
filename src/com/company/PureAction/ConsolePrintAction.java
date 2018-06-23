package com.company.PureAction;

public class ConsolePrintAction extends ActionBase {

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
    protected void innerInvoke() {
        System.out.println(this.message);
    }
}
