public class Pricelist implements Endorse {
    public Integer endorseFotoStory = 100000;
    public Integer endorseVideoStory = 150000;
    public Integer endorseFotoFeed = 200000;
    public Integer endorseVideoFeed = 300000;

    //Konstruktor
    @Override
    public void endorseFotoStory() {
        this.endorseFotoStory = endorseFotoStory;
    }

    @Override
    public void endorseVideoStory() {
        this.endorseVideoStory = endorseVideoStory;
    }

    @Override
    public void endorseFotoFeed() {
        this.endorseFotoFeed = endorseFotoFeed;
    }

    @Override
    public void endorseVideoFeed() {
        this.endorseVideoFeed = endorseVideoFeed;
    }
}
