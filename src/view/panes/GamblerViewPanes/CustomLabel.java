package view.panes.GamblerViewPanes;
import javafx.scene.control.Label;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.regex.Pattern;

/*class for labels that update automatically*/

public class CustomLabel{
    public Label label;
    public String labelText;
    String methodPath;
    Object obj;

    public CustomLabel(String text,Object obj, String metodPath){
        label = new Label(text);
        this.labelText = text;
        this.methodPath = metodPath;
        this.obj = obj;
    }

    /*get the methods that need to be called to get new value of label */
    private ArrayList<String> parseMethodPath(){
        ArrayList<String> result = new ArrayList<>();
        String[] path = this.methodPath.split(Pattern.quote(".")); // Split on period.
        for (String str: path){
            result.add(str.substring(0,str.length()-2));
        }
        return result;
    }

    /*
        use reflection to get new value of label
        if value == null or -1 -> display label text cause there is no value
        else update label text
    */
    public void update() {
        Method method = null;
        ArrayList<String> methodPath = parseMethodPath();
        Object result = obj;
        for (String str: methodPath){
            try {
                if(result != null){
                    method = result.getClass().getMethod(str);
                    result = method.invoke(result);
                    if (result != null && result instanceof Integer){
                        label.setText(labelText + Integer.toString((int) result));
                        if((int) result != -1){
                            label.setText(labelText + Integer.toString((int) result));
                        }else{
                            label.setText(labelText);
                        }
                    }else if(result != null){
                        label.setText(labelText + (String) result.toString());

                    }else{
                        label.setText(labelText);
                    }
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }



}
