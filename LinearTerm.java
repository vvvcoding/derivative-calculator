public class LinearTerm extends ConstantTerm {
    
    //fields
    private int constantTerm;
    public int ID = 1;

    //constructor
    public LinearTerm(int constantInput) {
        super(constantInput);
        constantTerm = getConstantTerm();
    }

    //implement derivative method
    @Override
    public ITerm derivative() {
        return new ConstantTerm(constantTerm);
    }

    //implement evaluate method
    @Override
    public double evaluate(double value) {
        double result = constantTerm * value;
        return result;
    }
    
    //implement toString method
    @Override
    public String toString() {
        return constantTerm + "x";
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
}