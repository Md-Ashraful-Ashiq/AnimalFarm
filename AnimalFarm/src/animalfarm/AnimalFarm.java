package animalfarm;

public class AnimalFarm {

    static Farm farm;
    static AnimalFactory afactory;
    static DecorationFactory dfactory;
    Decoration barn, bush, coop, delete, feed, fence, haystack, light, pond, tree; 
    Animal chicken, cow, duck, horse, sheep;  
    Tree treeSubject;
    Bush bushSubject;
    Light lightSubject;
    Audio audio;
    WeatherFacade weather;

    public AnimalFarm() {
        treeSubject = new Tree();
        bushSubject = new Bush();
        lightSubject = new Light();
        audio = new Audio();
        
        afactory = new AnimalFactory();
        dfactory = new DecorationFactory(treeSubject, bushSubject, lightSubject);
        
        tree = dfactory.createDecoration(ElementEnum.TREE);
        bush = dfactory.createDecoration(ElementEnum.BUSH);
        light = dfactory.createDecoration(ElementEnum.LIGHT);
        
        barn = dfactory.createDecoration(ElementEnum.BARN);
        coop = dfactory.createDecoration(ElementEnum.COOP);
        haystack = dfactory.createDecoration(ElementEnum.HAYSTACK);
        pond = dfactory.createDecoration(ElementEnum.POND);

        chicken = afactory.createAnimal(ElementEnum.CHICKEN);
        cow = afactory.createAnimal(ElementEnum.COW);
        duck = afactory.createAnimal(ElementEnum.DUCK);
        horse = afactory.createAnimal(ElementEnum.HORSE);
        sheep = afactory.createAnimal(ElementEnum.SHEEP);
        
        farm = new Farm(barn, bush, coop, haystack, light, pond, tree, chicken, cow, duck, horse, sheep); 
        weather = new WeatherFacade(farm, treeSubject, lightSubject, bushSubject, audio);
    }

    public void start() {
        AWTWindow window = new AWTWindow();
        window.init("Animal Farm");
        window.add(farm);
        window.addKeyListener(new KeyHandler(afactory, dfactory, farm, weather, lightSubject));
        window.setFocusable(true);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        farm.showFarm();
        weather.Rainy();
    }

    public static Farm getFarmInstance() {
        return farm;
    }  
}
