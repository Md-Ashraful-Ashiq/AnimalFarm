package animalfarm;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;

public class Farm extends JPanel implements ActionListener {

    int x = 8;
    int y = 12;
    int counter = 0;
    private final int height = 17;
    private final int width = 25;

    Element[][] farm = new Element[height][width];
    ElementEnum currentElementEnum = ElementEnum.EMPTY;

    private final Icon el;
    Decoration barnEl, bushEl, coopEl, haystackEl, lightsEl, pondEl, treeEl;
    Animal chickenEl, cowEl, duckEl, horseEl, sheepEl;
    Delete deleteEl;
    Feed feedEl;
    Fence fenceEl;                
    private ImageIcon fenceImage;
    private final int size = 40;

    private boolean isCloudy = false;
    private boolean isWindy = false;
    private boolean isRainy = false;
    private boolean isNight = false;
    private boolean isBarn = false;
    private boolean isCoop = false;
    private boolean isFence = false;
    private boolean isHaystack = false;
    private boolean isLights = false;
    private boolean isPond = false;
    private boolean isBush = false;
    private boolean isTree = false;
    private boolean isDelete = false;
    private boolean isFeed = false;
    private boolean isCow = false;         
    private boolean isSheep = false;         
    private boolean isDuck = false;         
    private boolean isChicken = false;         
    private boolean isHorse = false;   
    
    private Font derivedFont;
    private CurrencySingleton currencySingleton;

    public Farm(Decoration barnEl, Decoration bushEl, Decoration coopEl, Decoration haystackEl, 
                Decoration lightsEl, Decoration pondEl, Decoration treeEl, Animal chickenEl, Animal cowEl, 
                Animal duckEl, Animal horseEl, Animal sheepEl) {
        el = new Icon();
        this.barnEl = barnEl;
        this.bushEl = bushEl;
        this.coopEl = coopEl;
        this.deleteEl = new Delete();
        this.feedEl = new Feed();
        this.fenceEl = new Fence();
        this.haystackEl = haystackEl;
        this.lightsEl = lightsEl;
        this.pondEl = pondEl;
        this.treeEl = treeEl;
        this.chickenEl = chickenEl;
        this.cowEl = cowEl;
        this.duckEl = duckEl;                          
        this.horseEl = horseEl;
        this.sheepEl = sheepEl;  

        InputStream is = getClass().getResourceAsStream("Minecraft.ttf");
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            derivedFont = font.deriveFont(Font.PLAIN, 24);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        currencySingleton = CurrencySingleton.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //Draw initial farm
        el.getGrass().paintIcon(this, g, 0, 0);

        //Draw elements
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (farm[row][col] != null) {
                    draw(farm[row][col], g, row, col);
                }
            }
        }

        //Cloudy
        if (isCloudy) {
            el.getCloudy().paintIcon(this, g, 0, 0);
        }

        //Windy
        if (isWindy) {
        }

        //Rainy
        if (isRainy) {
            el.getDark().paintIcon(this, g, 0, 0);
            el.getRain().paintIcon(this, g, 0, 0);
        }

        //Night
        if (isNight) {
            el.getNight().paintIcon(this, g, 0, 0);
        }

        // Decorations
        if (isBarn) {
            draw(barnEl, g, x, y);
        }
        if (isCoop) {
            draw(coopEl, g, x, y);
        }
        if (isFence) {
            fenceImage = fenceEl.getFence(counter);
            draw(fenceEl, g, x, y);
        }
        if (isHaystack) {
            draw(haystackEl, g, x, y);
        }
        if (isLights) {
            draw(lightsEl, g, x, y);
        }
        if (isPond) {
            draw(pondEl, g, x, y);
        }
        if (isBush) {
            draw(bushEl, g, x, y);
        }
        if (isTree) {
            draw(treeEl, g, x, y);
        }
        if (isDelete) {
            deleteEl.getDelete().paintIcon(this, g, y * size, x * size);
        }
        if (isFeed) {
            feedEl.getFeed().paintIcon(this, g, y * size, x * size);
        }
        
        // Animals
        if (isCow) {
            draw(cowEl, g, x, y);                                       
        }
        if (isSheep) {
            draw(sheepEl, g, x, y);                                       
        }
        if (isDuck) {
            draw(duckEl, g, x, y);                                    
        }
        if (isChicken) {
            draw(chickenEl, g, x, y);                                      
        }
        if (isHorse) {
            draw(horseEl, g, x, y);                                      
        }
        
        //Menu
        el.getMenu().paintIcon(this, g, 21 * size, 25);
        g.setFont(derivedFont); 
        g.setColor(Color.WHITE);
        g.drawString("$" + String.valueOf(currencySingleton.getCurrency()), 900,30);
    }

    public void draw(Element element, Graphics g, int row, int col){
        element.getImage().paintIcon(this, g, col * size , row * size 
                - (element.getImage().getIconHeight() - size));
    }

    public void setIsRainy(boolean isRainy) {
        this.isRainy = isRainy;
    }

    public void setIsCloudy(boolean isCloudy) {
        this.isCloudy = isCloudy;
    }

    public void setIsWindy(boolean isWindy) {
        this.isWindy = isWindy;
    }

    public void setIsNight(boolean isNight) {
        this.isNight = isNight;
    }

    public void setIsBarn(boolean isBarn) {
        this.isBarn = isBarn;
    }

    public void setIsCoop(boolean isCoop) {
        this.isCoop = isCoop;
    }

    public void setIsFence(boolean isFence) {
        this.isFence = isFence;
    }

    public void setIsHaystack(boolean isHaystack) {
        this.isHaystack = isHaystack;
    }

    public void setIsLights(boolean isLights) {
        this.isLights = isLights;
    }

    public void setIsPond(boolean isPond) {
        this.isPond = isPond;
    }

    public void setIsBush(boolean isBush) {
        this.isBush = isBush;
    }

    public void setIsTree(boolean isTree) {
        this.isTree = isTree;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public void setIsFeed(boolean isFeed) {
        this.isFeed = isFeed;
    }

    public void setIsCow(boolean isCow) {
        this.isCow = isCow;                                                            
    }
    
    public void setIsSheep(boolean isSheep) {
        this.isSheep = isSheep;                                                       
    }

    public void setIsDuck(boolean isDuck) {
        this.isDuck = isDuck;                                                             
    }
    
    public void setIsChicken(boolean isChicken) {
        this.isChicken = isChicken;                                                            
    }

    public void setIsHorse(boolean isHorse) {
        this.isHorse = isHorse;                                                             
    }
    
    public void setAllFalse() {
        this.isBarn = false;
        this.isCoop = false;
        this.isFence = false;
        this.isHaystack = false;
        this.isLights = false;
        this.isPond = false;
        this.isBush = false;
        this.isTree = false;
        this.isDelete = false;
        this.isFeed = false;
        this.isCow = false;        
        this.isSheep = false;
        this.isDuck = false;
        this.isChicken = false;
        this.isHorse = false;
    }
    
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ImageIcon getFenceImage() {
        return fenceImage;
    }

    public void setElement(Decoration decoration, int x, int y) {
        this.farm[x][y] = decoration;
    }

    public Element getElement(int x, int y) {
        return this.farm[x][y];
    }

    public void setElement(Animal animal, int x, int y) {
        this.farm[x][y] = animal;
        animal.add(x, y);
    }

    public void deleteElement(int x, int y) {
        this.farm[x][y] = null;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void showFarm() {
        for (int row = 0; row < farm.length; row++) {
            System.out.println("");
            for (int col = 0; col < farm[row].length; col++) {
                System.out.print("[" + farm[row][col] + "]");
            }
        }
    }

    public void move(int moveX, int moveY) {
        x += moveX;
        y += moveY;
    }

    public void setCurrentElementEnum(ElementEnum currentElementEnum) {
        this.currentElementEnum = currentElementEnum;
    }

    public ElementEnum getCurrentElementEnum() {
        return currentElementEnum;
    }
}
