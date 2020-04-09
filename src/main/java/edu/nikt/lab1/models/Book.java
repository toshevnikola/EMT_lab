package edu.nikt.lab1.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Book {
    @NotNull
    private long id;
    @NotNull
    @Size(min = 3, message = "Plese input valid book title.")
    private String name;
    @NotNull
    @Min(value = 0, message = "Please enter valid quantity value.")
    private int copies;
    private Category category;
    private String base64Img;
    private MultipartFile image;

    public Book() {

    }
    public Book(long id, String name, int copies, Category category, String base64Img, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.copies = copies;
        this.category = category;
        this.base64Img = base64Img;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBase64Img() {
        return base64Img;
    }

    public void setBase64Img(String base64Img) {
        this.base64Img = base64Img;
    }

    public MultipartFile getImg() {
        return image;
    }

    public void setImg(MultipartFile image) {
        this.image = image;
    }
}
