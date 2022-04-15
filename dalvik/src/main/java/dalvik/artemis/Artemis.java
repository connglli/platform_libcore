package dalvik.artemis;

import java.lang.reflect.Method;

/**
 * Utility class for Artemis
 */
public class Artemis {
    /**
     * Return whehter JIT is enabled in ART.
     */
    public static native boolean isJitEnabled();

    /**
     * Return whether the method being invoked (caller of isBeingInterpreted()) is being interpreted.
     */
    public static native boolean isBeingInterpreted();

    /**
     * Return whether the method being invoked (caller of isJitCompiled()) is JIT compiled.
     * Note, a method is JIT compiled does not mean the method is running in the JIT/OSR code.
     */
    public static native boolean isJitCompiled();

    /**
     * Return whether the given method is JIT compiled.
     */
    public static native boolean isMethodJitCompiled(Method method);

    /**
     * Return whether the given method is JIT compiled.
     */
    public static boolean isMethodJitCompiled(Class<?> clazz, 
                                              String methodName, 
                                              Class<?>... args) throws NoSuchMethodException, SecurityException {
        return isMethodJitCompiled(clazz.getDeclaredMethod(methodName, args));
    }

    /**
     * Force to JIT compile a given method. Return whether the method is successfully JIT compiled.
     */
    public static native boolean ensureMethodJitCompiled(Method method);

    /**
     * Force to JIT compile a given method. Return whether the method is successfully JIT compiled.
     */
    public static boolean ensureMethodJitCompiled(Class<?> clazz, 
                                                  String methodName, 
                                                  Class<?>... args) throws NoSuchMethodException, SecurityException {
        return ensureMethodJitCompiled(clazz.getDeclaredMethod(methodName, args));
    }

    /**
     * Force to JIT compile current invoking method. Return whether the method is successfully JIT compiled.
     */
    public static native boolean ensureJitCompiled();

    /**
     * Force to depotimize a given method. Return whether the method is successfully depotimized.
     */
    public static native boolean ensureMethodDeoptimized(Method method);

    /**
     * Force to depotimize a given method. Return whether the method is successfully JIT depotimized.
     */
    public static boolean ensureMethodDeoptimized(Class<?> clazz, 
                                                  String methodName, 
                                                  Class<?>... args) throws NoSuchMethodException, SecurityException {
        return ensureMethodDeoptimized(clazz.getDeclaredMethod(methodName, args));
    }

    /**
     * Force to depotimize current invoking method. Return whether the method is successfully depotimized.
     */
    public static native boolean ensureDeoptimized();

}
