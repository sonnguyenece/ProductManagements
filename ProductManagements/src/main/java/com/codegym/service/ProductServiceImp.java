package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "CocaCola", 5.6f));
        products.put(2, new Product(2, "Poca", 6.6f));
        products.put(3, new Product(3, "Mentos", 4.9f));
        products.put(4, new Product(4, "KFC", 10.6f));
        products.put(5, new Product(5, "Pony", 2.3f));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {

        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
