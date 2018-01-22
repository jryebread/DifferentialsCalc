
public class Main {

    public static void main(String[] args) {
        String Eq = "xy''' - y + 6y = 0";
        ODE de = new ODE(Eq, 'y', 'x');
        System.out.println(de.getOrder());
        System.out.println(de.getDegree());
        System.out.println(de.getLinearity());

    }
}
