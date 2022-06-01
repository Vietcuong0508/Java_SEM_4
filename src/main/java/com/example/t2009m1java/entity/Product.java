package com.example.t2009m1java.entity;

import com.example.t2009m1java.entity.base.BaseEntity;
import com.example.t2009m1java.entity.myenum.ProductStatus;

import java.time.LocalDateTime;

public class Product extends BaseEntity {
    private int id;
    private String name;
    private String thumbnail;
    private double price;
    private int categoryId;
    private String description;
    private ProductStatus status;

    public Product() {
    }

    public Product(int id, String name, String thumbnail, double price, int categoryId, String description) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
    }

    public Product(int id, String name, String thumbnail, double price, int categoryId, String description, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
        this.status = status;
    }

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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }


    public static final class ProductBuilder {
        private int id;
        private String name;
        private String thumbnail;
        private double price;
        private int categoryId;
        private String description;
        private ProductStatus status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime deletedAt;
        private int createdBy;
        private int updatedBy;
        private int deletedBy;

        private ProductBuilder() {
        }

        public static ProductBuilder aProduct() {
            return new ProductBuilder();
        }

        public ProductBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder withThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public ProductBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder withCategoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder withStatus(ProductStatus status) {
            this.status = status;
            return this;
        }

        public ProductBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ProductBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ProductBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public ProductBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public ProductBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public ProductBuilder withDeletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setThumbnail(thumbnail);
            product.setPrice(price);
            product.setCategoryId(categoryId);
            product.setDescription(description);
            product.setStatus(status);
            product.setCreatedAt(createdAt);
            product.setUpdatedAt(updatedAt);
            product.setDeletedAt(deletedAt);
            product.setCreatedBy(createdBy);
            product.setUpdatedBy(updatedBy);
            product.setDeletedBy(deletedBy);
            return product;
        }
    }
}
