public interface ITerm {
    //methods must be filled in in the subclasses that implement iTerm
    public ITerm derivative();
    public double evaluate(double value);
    public String toString();
    public int getID();
    public boolean isNegative();
    public int getConstantTerm();
    public int getExponent();
    public TrigType getTrigFunction();
}