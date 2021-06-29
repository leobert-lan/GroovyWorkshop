package osp.leobert.groovyworkshop.mop

/**
 * <p><b>Package:</b> osp.leobert.groovyworkshop.mop </p>
 * <p><b>Project:</b> GroovyWorkshop </p>
 * <p><b>Classname:</b> GpathDemo </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/6/29.
 */
class GpathDemo {

    static class Foo {
        String bar

        def getBaz() {
            return "baz"
        }
    }

    static class Bar {

    }

    static void main(String[] args) {
        Foo foo = new Foo(bar:"bar")
        foo.bar = "bar 2"
        println(foo.bar)
        println(foo.baz)

        Bar.metaClass."getBaz" = { ->
            return "baz"
        }

        Bar bar = new Bar()
        println(bar.baz)
    }
}
