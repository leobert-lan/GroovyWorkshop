package osp.leobert.groovyworkshop.mop

class Demo1 {

    def foo() {
        println 'foo'
    }

    def invokeMethod(String name, Object args) {
        return "unknown method $name(${args.join(',')})"
    }

    static void main(String[] args) {
        def demo = new Demo1()
        demo.foo()
        println demo.bar("A", "B")
    }

}

class Demo2 implements GroovyInterceptable {

    def foo(String s) {
        return "foo:$s"
    }

    def invokeMethod(String name, Object args) {
        return "unknown method $name(${args.join(',')})"
    }

    static void main(String[] args) {
        def demo = new Demo2()
        println demo.foo("a")
        println demo.bar("A", "B")
    }
}

class Demo3 {

    def foo(String s) {
        return "foo:$s"
    }

    def invokeMethod(String name, Object args) {
        return "unknown method $name(${args.join(',')})"
    }

    def methodMissing(String name, Object args) {
        return "methodMissing $name(${args.join(',')})"
    }

    static void main(String[] args) {
        def demo = new Demo3()
        println demo.foo("a")
        println demo.bar("A", "B")
    }
}

class Demo4 implements GroovyInterceptable {

    def foo(String s) {
        return "foo:$s"
    }

    def invokeMethod(String name, Object args) {
        return "unknown method $name(${args.join(',')})"
    }

    def methodMissing(String name, Object args) {
        return "methodMissing $name(${args.join(',')})"
    }

    static void main(String[] args) {
        def demo = new Demo4()
        println demo.foo("a")
        println demo.bar("A", "B")
    }
}