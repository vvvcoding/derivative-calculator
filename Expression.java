public class Expression {

    //fields
    private ProjLinkedList<ITerm> newExpression;
    
    //constructor
    public Expression() {
        newExpression = new ProjLinkedList<>();
    }

    //methods
    public int getCount() {
        int count = 0;
        ProjNode<ITerm> currentNode = newExpression.getHead();
        while (currentNode != null) {
            count ++;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    //get derivative of expression
    public Expression getDerivative() {
        Expression derivedExpression = new Expression();
        ProjNode<ITerm> currentNode = newExpression.getHead();
        while (currentNode != null) {
            ITerm derivedTerm = currentNode.getData().derivative();
            if (derivedTerm != null) {
                derivedExpression.add(derivedTerm);
            }
            currentNode = currentNode.getNext();
        }
        return derivedExpression;
    }

    //evaluate the expression with the value given
    public double getEvaluation(double value) {
        double result = 0;
        for (int i = 0; i < getCount(); i ++) {
            result += newExpression.getAt(i).evaluate(value);
        }
        return result;
    }

    //print the expression
    public String toString() {
        String strToPrint = "";
        int length = newExpression.getLength();

        //add polynomial terms
        for (int i = 0; i < length; i ++) {
            if (newExpression.getAt(i).getID() == 0) {
                if (newExpression.getAt(i).isNegative() == true) {
                    int tempConstant = newExpression.getAt(i).getConstantTerm() * -1;
                    strToPrint += "- " + tempConstant + "x^" + newExpression.getAt(i).getExponent() + " ";
                } else {
                    strToPrint += newExpression.getAt(i).toString() + " ";
                }
            }
        }

        //add linear terms
        for (int i = 0; i < length; i ++) {
            if (newExpression.getAt(i).getID() == 1) {
                if (newExpression.getAt(i).isNegative() == true) {
                    strToPrint += "- " + newExpression.getAt(i).toString() + " ";    
                } else {
                    strToPrint += "+ " + newExpression.getAt(i).toString() + " ";
                }
            }
        }

        //add constant terms
        for (int i = 0; i < length; i ++) {
            if (newExpression.getAt(i).getID() == 2) {
                if (newExpression.getAt(i).isNegative() == true) {
                    strToPrint += "- " + newExpression.getAt(i).toString() + " ";    
                } else {
                    strToPrint += "+ " + newExpression.getAt(i).toString() + " ";
                }
            }
        }

        //add trig terms
        for (int i = 0; i < length; i ++) {
            if (newExpression.getAt(i).getID() == 3) {
                if (newExpression.getAt(i).isNegative() == true) {
                    int tempConstant = newExpression.getAt(i).getConstantTerm() * -1;
                    String tempTrigFunction = "";
                    if (newExpression.getAt(i).getTrigFunction() == TrigType.COSINE) {
                        tempTrigFunction = "cos(x)";
                    } else if (newExpression.getAt(i).getTrigFunction() == TrigType.SINE) {
                        tempTrigFunction = "sin(x)";
                    }
                    strToPrint += "- " + tempConstant + tempTrigFunction;    
                } else {
                    strToPrint += "+ " + newExpression.getAt(i).toString();
                }
            }
        }
        return strToPrint;
    }

    //add node to linked list
    public void add(ITerm input) {
        newExpression.add(input);
    }
}