package org.jLibNetSync;

import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    private List<UpdatedObject> objects = new ArrayList<>();
    private List<UpdatedObject> temporaryObjects = new ArrayList<>();
    private List<UpdatedObject> localObjects = new ArrayList<>();
    
    private boolean isClientSide = true;
    private int nextID = 0;
    
    public UpdatedObject registerObject(UpdatedObject object) {   
        boolean local = !object.isSynchronized();
        
        int id = -1;
        
        if(!local && !isClientSide) {
            id = nextID++;
        }
        
        object.doFactoryInit(id, this);
        
        if(local && isClientSide) {
            localObjects.add(object);
        } else if(isClientSide) {
            temporaryObjects.add(object);
        } else {
            objects.add(object);
            
            //TODO: post and shit
        }
        
        return object;
    }
}
