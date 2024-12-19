/* This file is for testing ONLY */
public class Main {
    public static void main(String[] args) {
        ITerm t1 = new LinearTerm(5);
        ITerm t2 = new PolynomialTerm(-4,3);
        ITerm t3 = new TrigTerm(-6, TrigType.COSINE);
        System.out.println(t1);
        System.out.println(t1.evaluate(5));
        System.out.println(t2);
        System.out.println(t2.evaluate(2));
        System.out.println(t3);
        System.out.println(t3.evaluate(45));
        Expression e1 = new Expression();
        e1.add(t1);
        e1.add(t2);
        e1.add(t3);
        Expression e2 = e1.getDerivative();
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e1.getEvaluation(0));
        System.out.println(e2.getEvaluation(0));
    }
}