public class PolynomialTerm extends LinearTerm {
    
    //fields
    private int constantTerm;
    private int exponent;
    private int ID = 0;

    //constructor
    public PolynomialTerm(int constantInput, int exponentInput) {
        super(constantInput);
        constantTerm = getConstantTerm();
        exponent = exponentInput;
    }

    //implement derivative method
    @Override
    public ITerm derivative() {
        if (exponent > 2) {
            constantTerm = constantTerm * exponent;
            int tempExponent = exponent - 1;
            return new PolynomialTerm(constantTerm, tempExponent);
        } else if (exponent == 2) {
            constantTerm = constantTerm * exponent;
            return new LinearTerm(constantTerm);
        }
        //shouldn't ever reach this point
        return null;
    }

    //implement evaluate method
    @Override
    public double evaluate(double value) {
        double result = constantTerm * (Math.pow(value, exponent));
        return result;
    }

    //implement toString method
    @Override
    public String toString() {
        if (exponent > 1) {
            return constantTerm + "x^" + exponent;
        } else if (exponent == 1) {
            return constantTerm + "x";
        }
        //shouldn't ever reach this point
        return "Error. Something went wrong!";
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
        return exponent;
    }
}