
public class Main {

    public static void main(String[] args) {
        String Eq = "y'' - 2x^8 - y^4 = 2x";
        ODE de = new ODE(Eq, 'y', 'x');
        System.out.println(de.getOrder());
        System.out.println(de.getDegree());
    }
}
