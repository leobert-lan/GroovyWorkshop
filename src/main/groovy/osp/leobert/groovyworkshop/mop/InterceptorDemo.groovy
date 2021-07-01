package osp.leobert.groovyworkshop.mop

/**
 * <p><b>Package:</b> osp.leobert.groovyworkshop.mop </p>
 * <p><b>Project:</b> GroovyWorkshop </p>
 * <p><b>Classname:</b> InterceptorDemo </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/7/1.
 */
class InterceptorDemo {
    static class Demo {
        def String s

        String foo() {
            return "foo $s"
        }


        @Override
        public String toString() {
            return "Demo{" +
                    "s='" + s + '\'' +
                    '}';
        }
    }

    static class DemoInterceptor1 implements Interceptor {

        def tmp = new Demo(s: "DemoInterceptor1")

        @Override
        Object beforeInvoke(Object o, String s, Object[] objects) {
            if (s == "foo") {
                println("before $s, $o")
                o.s = "aaaaa"
            }
            return tmp
//            return o
        }

        @Override
        Object afterInvoke(Object o, String s, Object[] objects, Object o1) {
            if (s == "foo") {
                println("after $s, $o")
//                println(o.&foo())
                return "hahaha"
            }
            return o1
        }

        @Override
        boolean doInvoke() {
            return true
        }
    }

    static void main(String[] args) {
        def proxy = ProxyMetaClass.getInstance(Demo)
        proxy.interceptor = new DemoInterceptor1()

        proxy.use {
            def demo = new Demo(s: "demo")
            println demo.&foo()
        }
    }
}
