public class ConstantTerm implements ITerm {
    
    //fields
    private int constantTerm;
    public int ID = 2;

    //constructor
    public ConstantTerm(int constantInput) {
        constantTerm = constantInput;
    }
    
    //implement derivative method
    @Override
    public ITerm derivative() {
        //the derivative of a constant term is always = 0
        return new ConstantTerm(0);
    }

    //implement evaluate method
    @Override
    public double evaluate(double value) {
        //can't evaluate this since it is just a constant term
        double result = constantTerm;
        return result;
    }

    //implement toString method
    @Override
    public String toString() {
        //just return the constant term
        return String.valueOf(constantTerm);
    }

    //get constant term for subclasses
    public int getConstantTerm() {
        return constantTerm;
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

    //return exponent
    public int getExponent() {
        return 0;
    }

    //return trig function (cosine/sine)
    public TrigType getTrigFunction() {
        return null;
    }
}
