package animalfarm;

public class DecorationFactory {
    
    private Tree tree;
    private Bush bush;
    private Light light;

    public DecorationFactory(Tree tree, Bush bush, Light light) {
        this.tree = tree;
        this.bush = bush;
        this.light = light;
    }

    public Decoration createDecoration(ElementEnum decorationType) {
        if (decorationType == null) {
            return null;
        }
        if (decorationType == ElementEnum.BARN) {
            return new Barn();
        } else if (decorationType == ElementEnum.BUSH) {
            return new BushChild(bush);
        } else if (decorationType == ElementEnum.COOP) {
            return new Coop();
        } else if (decorationType == ElementEnum.DELETE) {
            return new Delete();
        } else if (decorationType == ElementEnum.FEED) {
            return new Feed();
        } else if (decorationType == ElementEnum.FENCE) {
            return new Fence();
        } else if (decorationType == ElementEnum.HAYSTACK) {
            return new Haystack();
        } else if (decorationType == ElementEnum.LIGHT) {
            return new LightChild(light);
        } else if (decorationType == ElementEnum.POND) {
            return new Pond();
        } else if (decorationType == ElementEnum.TREE) {
            return new TreeChild(tree);
        }
        return null;
    }
}
