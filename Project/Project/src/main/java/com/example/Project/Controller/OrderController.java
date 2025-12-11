package com.example.Project.Controller;

import com.example.Project.entity.Order;
import com.example.Project.service.ComicService;
import com.example.Project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {
    @Autowired private OrderService orderService;
    @Autowired private ComicService comicService;

    @GetMapping("/order-form/{comicId}")
    public String showOrderForm(@PathVariable Long comicId, Model model) {
        model.addAttribute("comic", comicService.getById(comicId));
        model.addAttribute("order", new Order());
        return "order-form";
    }

    @PostMapping("/order/save")
    public String saveOrder(@ModelAttribute Order order, @RequestParam Long comicId) {
        // Lệnh này sẽ chạy ngon vì Entity Order đã có field 'comic'
        order.setComic(comicService.getById(comicId));
        orderService.save(order);
        return "redirect:/order-success";
    }

    @GetMapping("/order-success")
    public String success() { return "order-success"; }
}