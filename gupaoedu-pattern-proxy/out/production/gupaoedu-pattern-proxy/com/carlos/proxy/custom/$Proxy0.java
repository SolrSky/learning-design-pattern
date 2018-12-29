package com.carlos.proxy.custom;
import com.carlos.proxy.staticed.Person;
import java.lang.reflect.Method;
public class $Proxy0 implements com.carlos.proxy.staticed.Person{
MyInvocationHandler h;
public $Proxy0(MyInvocationHandler h){
this.h = h;
}
@Override
public void findLove() {
try{
Method m = com.carlos.proxy.staticed.Person.class.getMethod("findLove", new Class[]{});
this.h.invoke(this, m, null);
}catch(Throwable e){
e.printStackTrace();
}
}
@Override
public void findJob() {
try{
Method m = com.carlos.proxy.staticed.Person.class.getMethod("findJob", new Class[]{});
this.h.invoke(this, m, null);
}catch(Throwable e){
e.printStackTrace();
}
}
}
