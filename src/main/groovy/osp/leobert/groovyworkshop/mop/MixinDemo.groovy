package osp.leobert.groovyworkshop.mop

/**
 * <p><b>Package:</b> osp.leobert.groovyworkshop.mop </p>
 * <p><b>Project:</b> GroovyWorkshop </p>
 * <p><b>Classname:</b> MixinDemo </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/6/29.
 */
class MixinDemo {
    static class Paint {
        def draw(Drawable drawable) {
            println("paint ${drawable.name}")
        }
    }

    static class Drawable {
        String name
    }

    static void main(String[] args) {
        def paint = new Paint()
        Drawable.metaClass.draw = paint.&"draw"
        def drawable = new Drawable(name: "test")
        drawable.draw(drawable)
    }
}


class MixinDemo2 {

    static class MixinDelegate {
        private targetClass

        MixinDelegate(targetClass) {
            this.targetClass = targetClass
        }

        def mixin(String asMethodName, Closure closure) {
            targetClass.metaClass."$asMethodName" = closure
        }
    }

    static void main(String[] args) {
        def mixin = new MixinDelegate(MixinDemo.Drawable)
        mixin.mixin("draw", new MixinDemo.Paint().&"draw")
        def drawable = new MixinDemo.Drawable(name: "test")
        drawable.draw(drawable)
    }
}

class MixinDemo3 {

    static class MixinDsl implements GroovyInterceptable{
        private targetClass

        MixinDsl(targetClass) {
            this.targetClass = targetClass
        }

        def invokeMethod(String s, o) {
            if (s.startsWith("mixinFun") && s.length() > 8 && o[0] instanceof Closure) {
                def methodName = s[8].toLowerCase() + s[9..-1]
                targetClass.metaClass."$methodName" = o[0]
                return null
            } else {
                println("cannot handle")
            }
        }
    }

    static void main(String[] args) {
        (new MixinDsl(MixinDemo.Drawable)).mixinFunDraw new MixinDemo.Paint().&"draw"

        def drawable = new MixinDemo.Drawable(name: "test")
        drawable.draw(drawable)
    }
}

class MixinDemo4 {
    static class BitmapDrawable extends MixinDemo.Drawable {
    }

    static void main(String[] args) {
        MixinDemo.Drawable.metaClass.draw = new MixinDemo.Paint().&"draw"

        def drawable = new BitmapDrawable(name: "test BitmapDrawable")
        drawable.draw(drawable)
    }
}