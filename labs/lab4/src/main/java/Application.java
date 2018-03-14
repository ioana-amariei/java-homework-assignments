/**
 * @author Birsan Ioana (cas. Amariei B5)
 * @author Gensthaler octavian B5
 */

import catalog.Catalog;
import document.Article;
import document.Book;
import document.Manual;


public class Application {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.add(new Book("The Art of Computer Programming", "d:\books\programming\tacp.ps", 1967, "Donald E. Knuth"));
        catalog.add(new Article("Mastering the Game of Go without Human Knowledge", "d:\articles\AlphaGo.pdf", 2017, "David Silver", "Julian Schrittwieser", "Karen Simonyan"));
        catalog.add(new Manual("Cookbook", "d:\stuff\cookbook.doc"));
        catalog.save("d:\catalog.dat");
        //...
        catalog = Catalog.load("d:\catalog.dat");
        catalog.list();
    }
}
