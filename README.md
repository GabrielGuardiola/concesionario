
# Concesionario de coches [WIP]

El objetivo de este ejercicio es seguir los principios SOLID

A pesar de no estar terminado, a continuación explicaré los principios aplicados hasta ahora y en los fragmentos de código:


## S - Single Responsability

- Métodos de clase BaseCar, etc.
```java
// BaseCar.java

    public abstract void accelerate();

    public abstract void brake();

    public abstract void decelerate();

    public abstract void turnRight();

    public abstract void turnLeft();

    public abstract void doTrainingRace();
  
```
Este principio es complicado de aplicar ahora mismo ya que todavia no he podido implementar funcionalidades. La idea del código de arriba es que cada método de BaseCar cumpla una sola función.

- Implementaciones futuras

Este principio se cumplirá por ejemplo, cuando se implementen los repositorios. Si **FamilyCarRepository** tiene un método **SellCar()**, este método venderá el coche y posteriormente se llamará a otro método **updateStock()** para reducir la cantidad.

## O - Open/Close

Personalmente este es el principio que más me está costando de implementar. En los siguientes casos es donde hasta ahora se usan:

- Partes de los coches

La clase abstracta **BaseCar** tiene una lista de tipo **PartType** que es una interfaz que implementará la clase abstracta de las partes **PartTypeBase** para que posteriormente se pueda extender a nuevos tipos de partes (heredando de PartTypeBase) y que aún así los coches puedan tener nuevas partes sin modificar código.

```java
//PartType.java
public interface PartType {
    String getPartName();
    PartState getPartState();
    void accept(PartVisitor partVisitor);
}
```

```java
//PartTypeBase.java
public abstract class PartTypeBase implements PartType {

    private String partName;
    private PartState partState;

    protected PartTypeBase(String partName, PartState partState) {
        this.partName = partName;
        this.partState = partState;
    }
    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public PartState getPartState() {
        return this.partState;
    }
}

```

```java
//Engine.java
public class Engine extends PartTypeBase {

    private int engineCV;

    public Engine(String partName, PartState partState, int engineCV) {
        super(partName, partState);
        this.engineCV = engineCV;
    }

    public int getEngineCV() {
        return engineCV;
    }

    @Override
    public void accept(PartVisitor partVisitor) {
        partVisitor.visit(this);
    }
}
```

```java
//BaseCar.java
public abstract class BaseCar {
    ...
    protected List<PartType> partsList;

    ...
    public void addPart(PartType part) {
        partsList.add(part);
    }

```

- Patrón visitor para consumir las partes

He utilizado el patrón visitor para poder consumir las partes de los coches sin necesidad de identificar el tipo de parte (Engine, Wheel...) para evitar tener que modificar partes del código más alla de donde se muestra por consola.

```java
//PartVisitor.java
public interface PartVisitor {
    void visit(Engine engine);
    void visit(Wheel wheel);
    void visit(Suspension suspension);
}
```

```java
//Engine.java
public class Engine extends PartTypeBase {
    
    ...
    @Override
    public void accept(PartVisitor partVisitor) {
        partVisitor.visit(this);
    }
}

```

```java
//CarPrinterManager.java
public class CarPrinterManager {

    ...
    public void print(FamilyCar car){
        System.out.println("Family Car: " + car.getModel());

        for (PartType parte : car.getPartsList()) {
            parte.accept(partsPrinterManager);
        }
    }
    ...
}
```

```java
//PartsPrinterManager.java
public class PartsPrinterManager implements PartVisitor {

    @Override
    public void visit(Engine engine) {
        System.out.println("Engine: " + engine.getPartName() + " - " + engine.getEngineCV());
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Wheel: " + wheel.getPartName() + " - " + wheel.getWheelSize());

    }

    @Override
    public void visit(Suspension suspension) {
        System.out.println("Suspension: " + suspension.getPartName() + " - " + suspension.getSuspensionHeight());
    }
}
```

## L - Liskov

- Clase PartTypeBase

En la clase abstracta **PartTypeBase** tenemos los métodos:

```java
//PartTypeBase.java
    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public PartState getPartState() {
        return this.partState;
    }
```

Estos métodos serán accesibles desde una clase heredada, como por ejemplo Engine. En decir, que se pueden acceder a métodos de la clase padre desde los hijos.

## I - Interface Segregation

Se puede ver como se cumple este principio en interfaces como **PartType**. En el futuro, las interfaces de los repositorios también cumplirán este principio.

## D - Dependency Injection

Por el momento solo tengo aplicado este principio a **CarPrinterManager** y **PartsPrinterManager**. Pero en el futuro se inyectará la lógica de negocio y los repositorios, al igual que hace Spring.

Podemos observar como le pasamos instancias nuevas a ConcesionarioApplication.
```java
//Main.java
public class Main {
    public static void main(String[] args) {
        ConcesionarioApplication concesionarioApplication = new ConcesionarioApplication(new CarPrinterManager(new PartsPrinterManager()));
        concesionarioApplication.run();
    }
}

```

Vemos la inyección de dependencias en **ConcesionarioApplication.java**
```java
//ConcesionarioApplication.java
    private final CarPrinterManager carPrinterManager;

    public ConcesionarioApplication(CarPrinterManager carPrinterManager) {
        this.carPrinterManager = carPrinterManager;
    }
```

En **CarPrinterManager.java** observamos también la inyección de **PartsPrinterManager**, que también se hace desde el **main** al crear la instancia de la clase que se muestra.

```java
//CarPrinterManager.java
public class CarPrinterManager {

    private final PartsPrinterManager partsPrinterManager;
    public CarPrinterManager(PartsPrinterManager partsPrinterManager) {

        this.partsPrinterManager = partsPrinterManager;
    }

    ...

```







