package org.jLibNetSync;

import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    private List<LNSObject> objects = new ArrayList<>();
    private List<LNSObject> temporaryObjects = new ArrayList<>();
    private List<LNSObject> localObjects = new ArrayList<>();
    
    private boolean isClientSide = true;
    private int nextID = 0;
    
    public LNSObject registerObject(LNSObject object) {   
        boolean local = !object.isSynchronized();
        
        int id = -1;
        
        if(!local && !isClientSide) {
            id = nextID++;
        }
        
        object.doFactoryInit(id, this); //TODO  HOWTO ACCESS ASSIGNED ENCAPSULATED METHOD CALL? :(((
        
        if(local && isClientSide) {
            localObjects.add(object);
        } else if(isClientSide) {
            temporaryObjects.add(object);
            
            //TODO: Save EncapsulatedMethodCall.id for later removal
        } else {
            objects.add(object);
            
            //TODO: Send object creation and all references to clients
        }
        
        return object;
    }
}
