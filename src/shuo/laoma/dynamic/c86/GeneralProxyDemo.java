package shuo.laoma.dynamic.c86;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GeneralProxyDemo {
    static interface IServiceA {
        public void sayHello();
    }

    static class ServiceAImpl implements IServiceA {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static interface IServiceB {
        public void fly();
    }

    static class ServiceBImpl implements IServiceB {

        @Override
        public void fly() {
            System.out.println("flying");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler {
        private Object realObj;

        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + realObj.getClass().getSimpleName() + "::" + method.getName());
            Object result = method.invoke(realObj, args);
            System.out.println("leaving " + realObj.getClass().getSimpleName() + "::" + method.getName());
            return result;
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T getProxy(Class<T> intf, T realObj) {
        return (T) Proxy.newProxyInstance(intf.getClassLoader(), new Class<?>[] { intf },
                new SimpleInvocationHandler(realObj));
    }

    public static void main(String[] args) throws Exception {
        IServiceA a = new ServiceAImpl();
        IServiceA aProxy = getProxy(IServiceA.class, a);
        aProxy.sayHello();

        IServiceB b = new ServiceBImpl();
        IServiceB bProxy = getProxy(IServiceB.class, b);
        bProxy.fly();
    }
}