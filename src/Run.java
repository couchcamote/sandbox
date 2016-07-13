import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.alexiesracca.sandbox.cipher.Encrypt;
import com.alexiesracca.sandbox.cipher.EncrypterMessenger;
import com.alexiesracca.sandbox.exercise.ArmstrongNumber;
import com.alexiesracca.sandbox.exercise.NumericTest;
import com.alexiesracca.sandbox.exercise.ReverseString;
import com.alexiesracca.sandbox.qr.QRCodeGenerator;

/**
 * 
 */

/**
 * @author alexies racca
 * @dateCreated Mar 17, 2016
 */
public class Run {

    private static LinkedHashMap<String, Class> moduleMap = new LinkedHashMap<String, Class>();

    private static void initModules() {
        moduleMap.put("Encrypt", Encrypt.class);
        moduleMap.put("QRCodeGenerator", QRCodeGenerator.class);        
        moduleMap.put("ArmstrongNumber", ArmstrongNumber.class);
        moduleMap.put("NumericTest", NumericTest.class);
        moduleMap.put("ReverseString", ReverseString.class);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        initModules();
        int indx = 1;
        if (args.length == 0) {
            System.out.print("USAGE: <Module Name> <arguments... separated by space> | <Module Number> <arguments... separated by space> ");
            System.out.println("[Modules]");
            for (String key : moduleMap.keySet()) {
                System.out.println(indx + ") " + key);
                indx++;
            }

        }
        else {
            String module = args[0];
            Object[] keys = moduleMap.keySet().toArray();

            try {
                if (module.matches("\\d+")) {
                    int intx = Integer.parseInt(module);
                    Object mod = keys[intx - 1];
                    module = String.valueOf(mod);
                }

                System.out.println("Module: " + module);
                List<String> arguments = new ArrayList<String>(Arrays.asList(args));
                arguments.remove(0);
                String[] a = arguments.toArray(new String[arguments.size()]);

                Class clazz = moduleMap.get(module);
                
                if(clazz == null)
                {
                    System.out.println("Invalid Module Name");
                    return;
                }
                
                invokeMethod(moduleMap.get(module), a);
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Invalid Selection");
            }
            finally {
                
            }

        }
    }

    private static void invokeMethod(Class clazz, String[] args) {
        Class<?> c;
        try {
            c = Class.forName(clazz.getName());
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, (Object)args);
        }
        catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                        | NoSuchMethodException | SecurityException e) {
            System.out.println("Exception "+ e.getCause());
            System.out.println("Invalid Method or Parameters");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
