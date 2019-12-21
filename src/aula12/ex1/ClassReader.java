package aula12.ex1;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassReader {

    public static void class_dumper(Object o) {
        class_dumper(o.getClass());
    }

    public static void class_dumper(Class cl) {
        //print packages
        System.out.println("package " + cl.getPackageName() + ";");
        System.out.println();
        //print class declaration
        System.out.printf("public class " + cl.getSimpleName() + " extends " + cl.getSuperclass().getSimpleName());
        //prints interfaces
        if (!(cl.getInterfaces().length == 0)) {
            System.out.printf(" implements ");
            for (Class inter : cl.getInterfaces()) {
                System.out.printf(inter.getSimpleName() + " ");
            }
        }
        System.out.printf("{ \n");
        System.out.println();
        //get declarated fiels
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("    " + f.toGenericString().replaceAll(cl.getPackageName() + "." + cl.getSimpleName() + ".", "") + ";");
        }
        System.out.println();
        //print constructors
        Constructor[] construct = cl.getConstructors();

        for (Constructor c : construct) {
            System.out.println("    " + c.toGenericString().replaceAll(cl.getPackageName() + ".", "") + "{...};");
        }
        System.out.println();
        //print methods
        Method[] method = cl.getDeclaredMethods();
        for (Method m : method) {
            System.out.println("    " + m.toGenericString().replaceAll(cl.getPackageName() + ".", "") + "{...};");
        }
        System.out.println("}");
    }

    public static Object createObject(Class cl) {
        Scanner kb = new Scanner(System.in);
        System.out.println(">> Available Constructors <<");
        //print constructors
        Constructor[] construct = cl.getConstructors();
        int i = 0;
        for (Constructor c : construct) {
            System.out.println(i + ") " + c.toGenericString().replaceAll(cl.getPackageName() + ".", "") + "{...};");
            i++;
        }
        int op = 0;
        boolean valid = true;
        Constructor chosen_one = null;
        while (valid) {
            try {
                System.out.println("Choose an option, please: ");
                String s = kb.nextLine();
                op = Integer.parseInt(s);
                chosen_one = construct[op];
                valid = false;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid option, needs to be a number");
                valid = true;
            } catch (ArrayIndexOutOfBoundsException arr) {
                System.out.println("Not a valid option, needs to be one of the options");
                valid = true;
            }

        }
        Class[] param = chosen_one.getParameterTypes();
        ArrayList<Object> param_obj = new ArrayList<>();
        for (Class p : param) {
            System.out.println(p.getCanonicalName());
            String var_type = p.getCanonicalName();
            if (p.isPrimitive()) {
                switch (var_type) {
                    case "int":
                        param_obj.add(Integer.parseInt(kb.nextLine()));
                        break;
                    case "double":
                        param_obj.add(Double.parseDouble(kb.nextLine()));
                        break;
                    case "char":
                        param_obj.add(kb.next());
                        break;
                    case "float":
                        param_obj.add(Float.parseFloat(kb.nextLine()));
                        break;
                    case "long":
                        param_obj.add(Long.parseLong(kb.nextLine()));
                        break;
                    case "short":
                        param_obj.add(Short.parseShort(kb.nextLine()));
                        break;
                    case "byte":
                        param_obj.add(Byte.parseByte(kb.nextLine()));
                        break;
                    case "String":
                        param_obj.add(kb.nextLine());
                        break;
                }

            }
            else{
                try {
                    param_obj.add(createObject(p));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Bug");
                    System.exit(1);
                }
            }
        }

        try {
            return chosen_one.newInstance(param_obj.toArray(new Object[0]));
        } catch (InstantiationException e) {
            System.out.println("Instantiation error");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Illegal Access error");
            System.exit(1);
        } catch (InvocationTargetException e) {
            System.out.println("Invocation Target error");
            System.exit(1);
        }
        return null;
    }

        /*private Class<?> cl; //classe

    public ClassReader(String classe) {
        try {
            this.cl = Class.forName(classe);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO: A classe " + classe + " não foi encontrada.");
        }
    }

    //interfaces, superclasses, construtores, métodos, atributos
    public String InterfacesToString() {
        String r = "Interfaces: \n";
        Class<?>[] f = cl.getInterfaces();
        for (Class c : f) {
            r += c.getSimpleName() + "\n";
        }
        return r;
    }

    public String SuperClassesToString() {
        String r = "SuperClasses: \n";
        Class<?> f = cl.getSuperclass();
        r += f.getSimpleName();
        return r;
    }

    public String ConstrutoresToString() {
        String r = "Construtores: \n";
        try {
            Constructor<?> f = cl.getConstructor();
            r += f.getName();
        } catch (NoSuchMethodException e) {
            return "ERRO: Não exitem construtores nesta classe";
        }

        return r;
    }

    public String MetodosToString() {
        String r = "Metodos: \n";
        Method[] m = cl.getMethods();
        for (Method me : m) {
            r += me.getName() + "\n";
        }
        return r;
    }

    public String AtributeToString() {
        String r = "Atributes: \n";
        Field[] f = cl.getFields();
        for (Field fi : f) {
            try {
                r += fi.getName() + " : " + cl.getField(fi.getName()) + "\n";
            } catch (NoSuchFieldException e) {
                return (" Atributo não existe");
            }
        }
        r += "Declared atributes: ";
        Field[] df = cl.getDeclaredFields();
        for (Field fi : df) {
            try {
                r += fi.getName() + " : " + cl.getField(fi.getName()) + "\n";
            } catch (NoSuchFieldException e) {
                return (" Atributo não existe");
            }
        }
        return r;
    }*/
}
