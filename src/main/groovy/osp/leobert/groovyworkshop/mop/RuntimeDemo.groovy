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
    }
}
