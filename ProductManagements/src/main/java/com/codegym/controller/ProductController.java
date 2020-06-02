package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    private ProductServiceImp productService = new ProductServiceImp();

    @GetMapping("/")
    public String index(Model model) {

        List products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @RequestMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @RequestMapping("product/save")
    public String save(Product product, RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }

    @RequestMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/";
    }

    @RequestMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        productService.remove(id);
        redirect.addFlashAttribute("success", "Deleted product");
        return "redirect:/";
    }
}
