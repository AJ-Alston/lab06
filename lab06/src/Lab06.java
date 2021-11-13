import java.util.ArrayList;
import java.util.List;

//Class to evaluate reverse polish notation
public class Lab06 {

    public int evalRPN(List<String> tokens) {
        //create a stack with 10 data slots
        Stack stack = new Stack(10);

        //loop through input tokens, add numbers to stack, and do operations if token is an operation character
        for (int i = 0; i < tokens.size(); i++) {
            //add items and push new number back to stack
            if (tokens.get(i)=="+"){
                stack.push(stack.pop()+stack.pop());
            }
            //subtract items and push new number back to stack
            else if (tokens.get(i)=="-"){
                int int1=stack.pop();
                int int2=stack.pop();
                stack.push(int2-int1);
            }

            //multiply items and push new number back to stack
            else if (tokens.get(i)=="*"){
                stack.push(stack.pop()*stack.pop());
            }
            //divide items and push new number back to stack
            else if (tokens.get(i)=="/"){
                int int1=stack.pop();
                int int2=stack.pop();
                stack.push(int2/int1);
            }
            //push numbers to stack
            else{
                stack.push(Integer.parseInt(tokens.get(i)));
            }
        }
        //return answer
        return stack.pop();
    }
    //create array list of strings and add the input calculation into list
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

        //loop through tests and see if they evaluate correctly
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
