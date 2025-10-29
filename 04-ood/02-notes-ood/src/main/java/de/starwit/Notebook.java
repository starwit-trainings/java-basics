package de.starwit;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Page> pages = new ArrayList<>();

    public void addPage(String content) {
        this.pages.add(new Page(content));
    }

    public void deletePage(int id) {
        this.pages.remove(id);
    }

    public Page getPage(int id) {
        return this.getPage(id);
    }

    public void editPage(int id, String newContent) {
        this.pages.get(id).setContent(newContent);
    }

    public List<Page> getAllPages() {
        return new ArrayList<>(this.pages);
    }
}
