import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lab06 {
    public int evalRPN(List<String> tokens) {

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i)=="+"){
                stack.push(stack.pop()+stack.pop());
            }
            else if (tokens.get(i)=="-"){
                int int1=stack.pop();
                int int2=stack.pop();
                stack.push(int2-int1);
            }
            else if (tokens.get(i)=="*"){
                stack.push(stack.pop()*stack.pop());
            }
            else if (tokens.get(i)=="/"){
                int int1=stack.pop();
                int int2=stack.pop();
                stack.push(int2/int1);
            }
            else{
                stack.add(Integer.parseInt(tokens.get(i)));
            }
        }
        return stack.pop();
    }
    public ArrayList<String> getList(int example) throws Exception  {
        if (example < 0 || example > 2)
            throw new Exception("Three examples only!");
        ArrayList<String> list = new ArrayList<String>();
        if (example == 0)
            list.addAll(List.of("2", "1", "+", "3", "*"));
        else if (example == 2)
            list.addAll(List.of("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"));
        else
            list.addAll(List.of("4","13","5","/","+"));
        return list;
    }
    public static void main (String [] args) {
        Lab06 lab = new Lab06();
        ArrayList<String> tokens = new ArrayList<String>();

        try {
            for (int example = 0; example < 3; example++)
            System.out.println("Example " + example + " evaluates to " +
                        lab.evalRPN(lab.getList(example)));
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }

    }
}
