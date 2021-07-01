package osp.leobert.groovyworkshop.mop

/**
 * <p><b>Package:</b> osp.leobert.groovyworkshop.mop </p>
 * <p><b>Project:</b> GroovyWorkshop </p>
 * <p><b>Classname:</b> ResponseToDemo </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/7/1.
 */
class ResponseToDemo {
    static class Demo {
        def p = "p"
        def foo() {
            println("foo")
        }
    }

    static void main(String[] args) {
        Demo.metaClass."bar" = { ->
            println 'bar'
        }

        def demo = new Demo()
        if (demo.metaClass.respondsTo(demo, 'bar')) {
            println 'bar ok'
        }

        if (demo.metaClass.respondsTo(demo, 'foo')) {
            println 'foo ok'
        }

        if (demo.metaClass.hasProperty(demo, 'p')) {
            println 'p ok'
        }
    }
}
