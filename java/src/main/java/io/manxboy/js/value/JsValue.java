package io.manxboy.js.value;

import io.manxboy.js.JsContext;
import io.manxboy.js.JsRuntime;
import io.manxboy.js.impl.V8Ref;

public class JsValue extends V8Ref {

    private JsContext context;

    protected JsValue(long ptr) {
        super(ptr);
    }

    @Override
    protected native void nativeDestructor(long ptr);

    public JsValue (JsRuntime runtime, int value) {
        super(nativeConstructor(runtime, value));
    }

    public JsValue (JsRuntime runtime, long value) {
        super(nativeConstructor(runtime, value));
    }

    public JsValue (JsRuntime runtime, double value) {
        super(nativeConstructor(runtime, value));
    }

    public JsValue (JsRuntime runtime, boolean value) {
        super(nativeConstructor(runtime, value));
    }

    public JsValue (JsRuntime runtime, String value) {
        super(nativeConstructor(runtime, value));
    }

    private static native long nativeConstructor(JsRuntime runtime, int value);
    private static native long nativeConstructor(JsRuntime runtime, long value);
    private static native long nativeConstructor(JsRuntime runtime, double value);
    private static native long nativeConstructor(JsRuntime runtime, boolean value);
    private static native long nativeConstructor(JsRuntime runtime, String value);

    public native double toDouble();
    public native long toInt();

    @Override
    public native String toString();
    public native boolean toBoolean();

    /**
     * get a debug string represent
     * @return
     */
    public native String toDetailString();

    @Override
    public boolean equals(Object object) {
        return object instanceof JsValue && this.equals(object);
    }

    public native boolean equals(JsValue value);

    public native boolean strictEquals(JsValue value);

    public native String typeOf(JsRuntime runtime);
}
