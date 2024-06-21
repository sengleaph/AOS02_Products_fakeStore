package com.sifu.myapi;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int id;
    private String title;
    private int price;
    private String description;
    private List<String> images;
    private String creationAt;
    private String updatedAt;
    private Category category;

    public Product(int id, String title, int price, String description, List<String> images, String creationAt, String updatedAt, Category category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.images = images;
        this.creationAt = creationAt;
        this.updatedAt = updatedAt;
        this.category = category;
    }

    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(String creationAt) {
        this.creationAt = creationAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Make sure Category also implements Serializable if it is being passed
    public static class Category implements Serializable {
        private int id;
        private String name;
        private String image;
        private String creationAt;
        private String updatedAt;

        public Category(int id, String name, String image, String creationAt, String updatedAt) {
            this.id = id;
            this.name = name;
            this.image = image;
            this.creationAt = creationAt;
            this.updatedAt = updatedAt;
        }

        // Getters and setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCreationAt() {
            return creationAt;
        }

        public void setCreationAt(String creationAt) {
            this.creationAt = creationAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
