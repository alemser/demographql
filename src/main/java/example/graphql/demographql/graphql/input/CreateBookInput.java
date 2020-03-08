package example.graphql.demographql.graphql.input;

import example.graphql.demographql.model.Author;

public class CreateBookInput {
    private String name;
    private Integer pageCount;
    private String authorId;

    public CreateBookInput() {
    }

    public CreateBookInput(String name, Integer pageCount, String authorId) {
        this.name = name;
        this.pageCount = pageCount;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
