package osp.leobert.groovyworkshop.mop

/**
 * <p><b>Package:</b> osp.leobert.groovyworkshop.mop </p>
 * <p><b>Project:</b> GroovyWorkshop </p>
 * <p><b>Classname:</b> RuntimeDemo </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/6/29.
 */
class RuntimeDemo {

    static class Bean {
        String a
        String b
        String c
        String d

        @Override
        public String toString() {
            return "Bean{" +
                    "a='" + a + '\'' +
                    ", b='" + b + '\'' +
                    ", c='" + c + '\'' +
                    ", d='" + d + '\'' +
                    '}';
        }
    }

    static class ConstructorDemo {

        void main() {
            Bean.metaClass.constructor = { String a ->
                new Bean(a: a, b: "b", c: "c", d: "d")
            }
            def bean = new Bean("a")
            println(bean)
        }
    }

    static void main(String[] args) {
        def bean = new Bean(a: "a", b: "b", c: "c")
        println(bean)
        new ConstructorDemo().main()

        GpathDemo.Foo.metaClass.'static'.hello = { args1 ->
            return "RuntimeDemo：hello,${args1}"
        }
        println GpathDemo.Foo.hello("foo")

        //为对象添加方法
        try {
            bean.hello()
        } catch(Exception e) {
            println(e.message)
        }

        def emc = new ExpandoMetaClass(Bean.class, false)
        emc.hello = { println "hello" }
        emc.initialize()
        bean.metaClass = emc
        bean.hello()

        try {
            new Bean().hello()
        } catch(Exception e) {
            println(e.message)
        }

    }
}
