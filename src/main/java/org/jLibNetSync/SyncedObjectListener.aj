package org.jLibNetSync;

import org.aspectj.lang.reflect.MethodSignature;
import org.jLibNetSync.annotations.CallSynced;

public aspect SyncedObjectListener {
    pointcut methodCall(): call(* UpdatedObject.*(*));
    
    before(): methodCall() {
        if (((MethodSignature)thisJoinPoint.getSignature()).getMethod().isAnnotationPresent(CallSynced.class)
           && ((UpdatedObject)thisJoinPoint.getTarget()).isSynchronized()) {
            CallListener listener = ((UpdatedObject)thisJoinPoint.getTarget()).getAssignedCallListener();
            
            EncapsulatedMethodCall methodCall = new EncapsulatedMethodCall();
        }
    }
}
