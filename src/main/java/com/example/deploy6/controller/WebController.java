package com.example.deploy6.controller;

import com.example.deploy6.model.Mahasiswa;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140159"; // GANTI DENGAN NIM KAMU!

    // Halaman Login
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            session.setAttribute("user", username);
            session.setAttribute("mahasiswaList", new ArrayList<Mahasiswa>());
            return "redirect:/home";
        }
        model.addAttribute("error", "Username atau password salah!");
        return "login";
    }

    // Halaman Home (tampilkan data temporary)
    @GetMapping("/home")
    public String homePage(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        @SuppressWarnings("unchecked")
        List<Mahasiswa> list = (List<Mahasiswa>) session.getAttribute("mahasiswaList");
        model.addAttribute("mahasiswaList", list);
        model.addAttribute("namaKamu", "Muhammad Dzulfikri"); // GANTI DENGAN NAMAMU
        model.addAttribute("nimKamu", "20230140159"); // GANTI DENGAN NIM KAMU
        return "home";
    }

    // Halaman Form Input
    @GetMapping("/form")
    public String formPage(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        model.addAttribute("mahasiswa", new Mahasiswa());
        model.addAttribute("nimKamu", "20230140159"); // GANTI DENGAN NIM KAMU
        return "form";
    }

    // Proses Submit Form
    @PostMapping("/submit")
    public String submitForm(@ModelAttribute Mahasiswa mahasiswa,
                             HttpSession session,
                             Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        @SuppressWarnings("unchecked")
        List<Mahasiswa> list = (List<Mahasiswa>) session.getAttribute("mahasiswaList");
        list.add(mahasiswa);
        session.setAttribute("mahasiswaList", list);
        model.addAttribute("mahasiswa", mahasiswa);
        model.addAttribute("nimKamu", "20230140159"); // GANTI DENGAN NIM KAMU
        return "hasil";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}