package org.jLibNetSync;

public abstract class LNSObject {
    private int objectID = -1;
    private ObjectManager objectManager = null;
    private boolean factoryInitDone = false;
    private EncapsulatedMethodCall origin = null;
    
    protected final int getObjectID() {
        return objectID;
    }
    
    protected final ObjectManager getObjectManager() {
        return objectManager;
    }
    
    protected final boolean doFactoryInit(int id, ObjectManager objMan, EncapsulatedMethodCall o) {
        if(!factoryInitDone) {
            objectID = id;
            objectManager = objMan;
            origin = o;
            
            factoryInitDone = true;
            return true;
        }
        return false;
    }
    
    protected final CallListener getAssignedCallListener() {
        return null;
    }
    
    protected final void postUpdate() {
        //TODO compute delta and update;
    }
    
    public boolean isSynchronized() {
        return true;
    }
    
    public boolean doUpdateLoop() {
        return false;
    }
    
    public void update(float delta) {
        return;
    }
}
