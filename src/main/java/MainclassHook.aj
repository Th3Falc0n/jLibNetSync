
public aspect MainclassHook {
    pointcut creation(): initialization(Mainclass.new(..));
    
    before(): creation() {
        System.out.println("Created Mainclass");
        ((Mainclass)thisJoinPoint.getThis()).printShit();
    }
}
