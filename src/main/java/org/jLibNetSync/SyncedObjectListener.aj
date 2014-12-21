package org.jLibNetSync;

import org.aspectj.lang.reflect.MethodSignature;
import org.jLibNetSync.annotations.CallSynced;

public aspect SyncedObjectListener {
    pointcut methodCall(): call(* LNSObject.*(*));
    
    before(): methodCall() {
        if (((MethodSignature)thisJoinPoint.getSignature()).getMethod().isAnnotationPresent(CallSynced.class)
           && ((LNSObject)thisJoinPoint.getTarget()).isSynchronized()) {
            CallListener listener = ((LNSObject)thisJoinPoint.getTarget()).getAssignedCallListener();
            
            EncapsulatedMethodCall methodCall = new EncapsulatedMethodCall();
        }
    }
}
