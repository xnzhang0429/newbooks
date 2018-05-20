package com.xiaoxiannv.books.po;

public class Book {
    private Integer bookId;

    private String bookName;

    private Long bookTime;

    private String bookUser;

    private String bookLink;

    private String bookPassword;

    private Integer bookSort;

    private Integer bookDown;

    private String bookPic;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Long getBookTime() {
        return bookTime;
    }

    public void setBookTime(Long bookTime) {
        this.bookTime = bookTime;
    }

    public String getBookUser() {
        return bookUser;
    }

    public void setBookUser(String bookUser) {
        this.bookUser = bookUser == null ? null : bookUser.trim();
    }

    public String getBookLink() {
        return bookLink;
    }

    public void setBookLink(String bookLink) {
        this.bookLink = bookLink == null ? null : bookLink.trim();
    }

    public String getBookPassword() {
        return bookPassword;
    }

    public void setBookPassword(String bookPassword) {
        this.bookPassword = bookPassword == null ? null : bookPassword.trim();
    }

    public Integer getBookSort() {
        return bookSort;
    }

    public void setBookSort(Integer bookSort) {
        this.bookSort = bookSort;
    }

    public Integer getBookDown() {
        return bookDown;
    }

    public void setBookDown(Integer bookDown) {
        this.bookDown = bookDown;
    }

    public String getBookPic() {
        return bookPic;
    }

    public void setBookPic(String bookPic) {
        this.bookPic = bookPic == null ? null : bookPic.trim();
    }

}