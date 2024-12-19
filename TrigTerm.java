public class TrigTerm extends LinearTerm {
    
    //fields
    private int constantTerm;
    private TrigType trigFunction;
    private int ID = 3;

    //constructor
    public TrigTerm(int constantInput, TrigType trigInput) {
        super(constantInput);
        constantTerm = getConstantTerm();
        trigFunction = trigInput;
    }

    //implement derivative method
    @Override
    public ITerm derivative() {
        //take derivative of sine/consine and switch signs if necessary
        if (trigFunction == TrigType.COSINE) {
            TrigType tempTrigFunction = TrigType.SINE;
            //flip the sign
            int tempConstantTerm = constantTerm * -1;
            return new TrigTerm(tempConstantTerm, tempTrigFunction);
        } else if (trigFunction == TrigType.SINE) {
            TrigType tempTrigFunction = TrigType.COSINE;
            return new TrigTerm(constantTerm, tempTrigFunction);
        }
        //shouldn't ever reach this point
        return null;
    }

    //implement evaluate method
    @Override
    public double evaluate(double value) {
        double result = 0;
        if (trigFunction == TrigType.COSINE) {
            result = constantTerm * (Math.cos(Math.toRadians(value)));
        } else if (trigFunction == TrigType.SINE) {
            result = constantTerm * (Math.sin(Math.toRadians(value)));
        }
        return result;
    }

    //implement toString method
    @Override
    public String toString() {
        if (trigFunction == TrigType.COSINE) {
            return constantTerm + "cos(x)";
        } else if (trigFunction == TrigType.SINE) {
            return constantTerm + "sin(x)";
        }
        //shouldn't ever hit this case
        return null;
    }

    //return ID
    public int getID() {
        return ID;
    }

    //check if constant term is negative and return true/false
    public boolean isNegative() {
        if (constantTerm < 0) {
            return true;
        }
        return false;
    }

    //return trig function (cosine/sine)
    public TrigType getTrigFunction() {
        return trigFunction;
    }
}