package animalfarm;

import java.awt.event.*;
import javax.swing.*;

public class KeyHandler implements KeyListener {

    WeatherFacade weather;
    AnimalFactory afactory;
    DecorationFactory dfactory;
    Decoration decoration;
    ImageIcon image;
    Animal animal;
    Farm farm;
    LightsControl remote;
    LightOnCommand lightOn;
    LightOffCommand lightOff;

    int speedX, speedY;

    public KeyHandler(AnimalFactory afactory, DecorationFactory dfactory, Farm farm, 
                      WeatherFacade weather, Decoration light) {
        this.farm = farm;
        this.weather = weather;
        this.afactory = afactory;
        this.dfactory = dfactory;
        remote = new LightsControl();
        lightOn = new LightOnCommand(light);
        lightOff = new LightOffCommand(light);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        ElementEnum currentElementEnum = farm.getCurrentElementEnum();

        if (code == KeyEvent.VK_UP) {
            farm.move(-1, 0);
            speedX = -1;
            speedY = 0;
        }
        if (code == KeyEvent.VK_DOWN) {
            farm.move(1, 0);
            speedX = 1;
            speedY = 0;
        }
        if (code == KeyEvent.VK_LEFT) {
            farm.move(0, -1);
            speedX = 0;
            speedY = -1;
        }
        if (code == KeyEvent.VK_RIGHT) {
            farm.move(0, 1);
            speedX = 0;
            speedY = 1;
        }

        // Control decoration
        if (code == KeyEvent.VK_SPACE) {
            if (currentElementEnum == ElementEnum.DELETE) {
                Element element = farm.getElement(farm.x, farm.y);
                if (element != null && element instanceof Animal) {
                    Animal animal = (Animal) element;
                    if (animal.canBeSold()) {
                        animal.sell();
                        System.out.println("Animal " + animal.getName() + " sold for $" 
                                            + animal.sellPrice);
                        animal.stopTimer();
                        farm.deleteElement(farm.x, farm.y);
                    } else {
                        System.out.println("Not mature yet");
                    }
                }
                else {
                    farm.deleteElement(farm.x, farm.y);
                }
            } else if (currentElementEnum == ElementEnum.FEED) {
                Element element = farm.getElement(farm.x, farm.y);
                if (element != null && element instanceof Animal) {
                    Animal animal = (Animal) element;
                    animal.feed();
                    System.out.println("Animal " + animal.getName() + " fed");
                }
            } else {
                Element element = farm.getElement(farm.x, farm.y);
                if (element == null) {
                    if (currentElementEnum == ElementEnum.FENCE || 
                        currentElementEnum == ElementEnum.BARN || 
                        currentElementEnum == ElementEnum.COOP || 
                        currentElementEnum == ElementEnum.HAYSTACK || 
                        currentElementEnum == ElementEnum.LIGHT || 
                        currentElementEnum == ElementEnum.TREE || 
                        currentElementEnum == ElementEnum.POND || 
                        currentElementEnum == ElementEnum.TREE || 
                        currentElementEnum == ElementEnum.BUSH) { 
                        Decoration decoration = dfactory.createDecoration(currentElementEnum);
                        if (decoration.canBeBought()) {
                            if (decoration instanceof Fence) decoration.setImage(farm.getFenceImage());
                            decoration.buy();
                            farm.setElement(decoration, farm.x, farm.y);
                        }
                    } else {
                        Animal animal = afactory.createAnimal(currentElementEnum);
                        if (animal.canBeBought()) {
                            animal.buy();
                            farm.setElement(animal, farm.x, farm.y);
                        }
                    }            
                }
                farm.setCurrentElementEnum(ElementEnum.EMPTY);
                farm.setAllFalse();
            }
            farm.setX(farm.x);
            farm.setY(farm.y);
            farm.setCounter(0);
        }
        if (code == KeyEvent.VK_1) {
            farm.setCurrentElementEnum(ElementEnum.BARN);
            farm.setAllFalse();
            this.decoration = farm.barnEl;
            farm.setIsBarn(true);
        }
        if (code == KeyEvent.VK_2) {
            farm.setCurrentElementEnum(ElementEnum.COOP);
            farm.setAllFalse();
            this.decoration = farm.coopEl;
            farm.setIsCoop(true);
        }
        if (code == KeyEvent.VK_3) {
            farm.setCurrentElementEnum(ElementEnum.FENCE);
            farm.setAllFalse();
            if (farm.getCounter() == 8) {
                farm.setCounter(0);
            }
            int counter = farm.getCounter();
            counter++;
            this.decoration = farm.fenceEl;
            farm.setCounter(counter);
            farm.setIsFence(true);
        }
        if (code == KeyEvent.VK_4) {
            farm.setCurrentElementEnum(ElementEnum.HAYSTACK);
            farm.setAllFalse();
            this.decoration = farm.haystackEl;
            farm.setIsHaystack(true);
        }
        if (code == KeyEvent.VK_5) {
            farm.setCurrentElementEnum(ElementEnum.LIGHT);
            farm.setAllFalse();
            this.decoration = farm.lightsEl;
            farm.setIsLights(true);
        }
        if (code == KeyEvent.VK_6) {
            farm.setCurrentElementEnum(ElementEnum.POND);
            farm.setAllFalse();
            this.decoration = farm.pondEl;
            farm.setIsPond(true);
        }
        if (code == KeyEvent.VK_7) {
            farm.setCurrentElementEnum(ElementEnum.BUSH);
            farm.setAllFalse();
            this.decoration = farm.bushEl;
            farm.setIsBush(true);
        }
        if (code == KeyEvent.VK_8) {
            farm.setCurrentElementEnum(ElementEnum.TREE);
            farm.setAllFalse();
            this.decoration = farm.treeEl;
            farm.setIsTree(true);
        }
        if (code == KeyEvent.VK_9) {
            farm.setCurrentElementEnum(ElementEnum.DELETE);
            farm.setAllFalse();
            this.decoration = dfactory.createDecoration(ElementEnum.DELETE);
            farm.setIsDelete(true);
        }
        if (code == KeyEvent.VK_0) {
            farm.setCurrentElementEnum(ElementEnum.FEED);
            farm.setAllFalse();
            this.decoration = dfactory.createDecoration(ElementEnum.FEED);
            farm.setIsFeed(true);
        }
        
        // Control light
        if (code == KeyEvent.VK_O) {
            remote.setCommand(lightOn);
            remote.buttonWasPressed();
            System.out.println("Turn on the lights");
        }
        if (code == KeyEvent.VK_P) {
            remote.setCommand(lightOff);
            remote.buttonWasPressed();
            System.out.println("Turn off the lights");
        }


        // Control animal
        if (code == KeyEvent.VK_A) {
            farm.setCurrentElementEnum(ElementEnum.COW);
            farm.setAllFalse();
            this.decoration = null;
            this.animal = farm.cowEl;
            farm.setIsCow(true);
        }

        if (code == KeyEvent.VK_S) {
            farm.setCurrentElementEnum(ElementEnum.SHEEP);
            farm.setAllFalse();
            this.decoration = null;
            this.animal = farm.sheepEl;
            farm.setIsSheep(true);
        }

        if (code == KeyEvent.VK_D) {
            farm.setCurrentElementEnum(ElementEnum.DUCK);
            farm.setAllFalse();
            this.decoration = null;
            this.animal = farm.duckEl;
            farm.setIsDuck(true);
        }

        if (code == KeyEvent.VK_F) {
            farm.setCurrentElementEnum(ElementEnum.CHICKEN);
            farm.setAllFalse();
            this.decoration = null;
            this.animal = farm.chickenEl;
            farm.setIsChicken(true);
        }

        if (code == KeyEvent.VK_G) {
            farm.setCurrentElementEnum(ElementEnum.HORSE);
            farm.setAllFalse();
            this.decoration = null;
            this.animal = farm.horseEl;
            farm.setIsHorse(true);
        }

        // Control weather
        if (code == KeyEvent.VK_Q) {
            weather.Sunny();
        }
        if (code == KeyEvent.VK_W) {
            weather.Windy();
        }
        if (code == KeyEvent.VK_E) {
            weather.Cloudy();
        }
        if (code == KeyEvent.VK_R) {
            weather.Rainy();
        }
        if (code == KeyEvent.VK_T) {
            weather.Night();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
