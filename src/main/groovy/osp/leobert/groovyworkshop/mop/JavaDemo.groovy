package osp.leobert.groovyworkshop.mop

/**
 * <p><b>Package:</b> osp.leobert.groovyworkshop.mop </p>
 * <p><b>Project:</b> GroovyWorkshop </p>
 * <p><b>Classname:</b> JavaDemo </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/7/1.
 */
class JavaDemo {

    static class DemoInterceptor2 implements Interceptor {


        @Override
        Object beforeInvoke(Object o, String s, Object[] objects) {
            println("before $s, $o")
            return o
        }

        @Override
        Object afterInvoke(Object o, String s, Object[] objects, Object o1) {
            println("after $s, $o")
            return o1
        }

        @Override
        boolean doInvoke() {
            return true
        }
    }

    static void main(String[] args) {
        ExpandoMetaClass emc = new ExpandoMetaClass(JavaClz, false)
        emc.foo = { return "hello,world!" }
        emc.initialize()

        def foo = new groovy.util.Proxy().wrap(new JavaClz())
        foo.setMetaClass(emc)
        println foo.foo()


//        拦截器正常使用
        def proxy = ProxyMetaClass.getInstance(JavaClz.class);
        proxy.interceptor = new DemoInterceptor2()

        proxy.use {

            println new JavaClz().jFoo()
        }
    }
}
