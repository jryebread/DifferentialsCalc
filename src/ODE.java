//**Ordinary Differential Equation**\\
public class ODE {

    public ODE(String eq, char depVar, char indVar) {
        m_eq = eq;
        m_depVar = depVar;
        m_indVar = indVar;
        //parse differential equation(get order,degree)
        m_linearity = parseEq(eq);


    }

    // 1.check for y and all its derivatives are of 1st degree
    // 2. if all coefficients of the dependent var and its derivatives are independent functions or are constants
    private boolean parseEq(String eq) {
        int result = eq.replaceFirst(".*?(" + '\'' + "+).*", "$1").length();
        m_order = result;

        char pos_Degree = '0';
        //parse degree
        for(int x = 0; x < eq.length(); ++x)
        {
            if(eq.charAt(x) == '^' && eq.charAt(x-1) != m_indVar)
            {
                if(Character.getNumericValue(eq.charAt(x+1)) > Character.getNumericValue(pos_Degree))
                    pos_Degree = eq.charAt(x+1);
            }
            if(eq.charAt(x) == m_depVar && x > 1)
            {
                if(x > 2 && Character.isDigit(eq.charAt(x-1)) && eq.charAt(x-2) == '^' && eq.charAt(x-3) == m_depVar)
                {
                    return false;
                }
                else if(eq.charAt(x-1) == m_depVar)
                {
                    return false;
                }
            }
        }
        m_degree = Character.getNumericValue(pos_Degree);

        if(m_degree > 1)
            return false;
        else
            return true;
    }

    public int getDegree()
    {
        return m_degree;
    }
    public int getOrder()
    {
        return m_order;
    }
    public boolean getLinearity()
    {
        return m_linearity;
    }
    //data
    private String m_eq;
    private int m_order; //the order is the highest derivative
    private int m_degree;
    private char m_depVar;
    private char m_indVar;
    private boolean m_linearity;


}
