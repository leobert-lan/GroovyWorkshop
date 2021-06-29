package osp.leobert.groovyworkshop.mop

import java.util.function.BiConsumer

/**
 * <p><b>Package:</b> osp.leobert.groovyworkshop.mop </p>
 * <p><b>Project:</b> GroovyWorkshop </p>
 * <p><b>Classname:</b> ExpandoDemo </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/6/29.
 */
class ExpandoDemo {

    static void main(String[] args) {
        Expando expando = new Expando()
        expando.foo = "foo"
        println(expando.foo)
        expando.bar = "bar"
        println(expando.bar)

        expando.properties.forEach(new BiConsumer() {
            @Override
            void accept(Object o, Object o2) {
                println("key:$o,value:$o2")
            }
        })
    }
}
