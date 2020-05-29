package com.mouse.java.jvm.demo3;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/27
 * @description finally语句不执行的两种情况: 1 try语句前就返回 2 try|catch中 System.exit(0); 这样的语句 jvm关闭自然执行不到
 * 在try-catch-finally中, return遇到finally, return对finally无效
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        function();
        function2();
        function3();
        System.out.println(function4());
        System.out.println(function5());
        System.out.println(function6());
    }

    /**
     * try
     * finally
     */
    private static void function() {
        try {
            System.out.println("try");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }

    /**
     * try
     * catch
     * finally
     */
    private static void function2() {
        try {
            System.out.println("try");
            throw new Exception("");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }

    /**
     * try
     * catch
     * finally
     * Exception in thread "main" java.lang.Exception:
     * at com.mouse.java.jvm.demo3.Demo.function3(Demo.java:46)
     * at com.mouse.java.jvm.demo3.Demo.main(Demo.java:14)
     *
     * @throws Exception
     */
    private static void function3() throws Exception {
        try {
            System.out.println("try");
            throw new Exception("");
        } catch (Exception e) {
            System.out.println("catch");
            throw new Exception("");
        } finally {
            System.out.println("finally");
        }
    }

    /**
     * try
     * finally
     * 3
     *
     * @return
     */
    private static int function4() {
        try {
            System.out.println("try");
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }

    /**
     * try
     * catch
     * finally
     * 3
     *
     * @return
     */
    private static int function5() {
        try {
            System.out.println("try");
            int i = 1 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }

    private static int function6() {
        try {
            System.out.println("try");
            System.exit(0);
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }
}
