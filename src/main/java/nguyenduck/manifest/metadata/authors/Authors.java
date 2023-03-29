package nguyenduck.manifest.metadata.authors;

import nguyenduck.utils.Property;

public class Authors extends Property {

    public Authors() {
        super("authors");
    }

    @Override
    public String[] getValue() {
        return (String[]) super.getValue();
    }

    public String[] getAuthors() {
        if (getValue() == null) setAuthors(new String[]{});
        return getValue();
    }

    public void addAuthor(String author) {
        String[] authors = getAuthors();
        String[] a = new String[authors.length + 1];
        System.arraycopy(authors, 0, a, 0, authors.length);
        a[a.length - 1] = author;
        setAuthors(a);
    }

    public void setAuthors(String[] authors) {
        setValue(authors);
    }

}
