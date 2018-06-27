package com.company.MiscSpike.PureAction;

public class SubtractAction extends ActionBase<Double> {

    private Double minuend;
    private Double subtrahend;

    public SubtractAction setValues(double minuend, double subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
        return this;
    }

    @Override
    protected boolean isDataReady() {
        return minuend != null && subtrahend != null;
    }

    @Override
    protected Double innerInvoke() {
        return minuend - subtrahend;
    }
}
