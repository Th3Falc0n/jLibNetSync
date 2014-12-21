package org.jLibNetSync;

public abstract class UpdatedObject {
    private int objectID = -1;
    private ObjectManager objectManager = null;
    private boolean factoryInitDone = false;
    
    protected final int getObjectID() {
        return objectID;
    }
    
    protected final ObjectManager getObjectManager() {
        return objectManager;
    }
    
    protected final boolean doFactoryInit(int id, ObjectManager objMan) {
        if(!factoryInitDone) {
            objectID = id;
            objectManager = objMan;
            
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
    
    public abstract void update(float delta);
}
