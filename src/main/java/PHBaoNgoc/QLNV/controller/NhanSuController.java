package PHBaoNgoc.QLNV.controller;

import jakarta.validation.Valid;
import PHBaoNgoc.QLNV.model.NhanVien;
import PHBaoNgoc.QLNV.service.NhanVienService;
import PHBaoNgoc.QLNV.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhansu")
public class NhanSuController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String listBooks(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllNhanVien();
        model.addAttribute("listNhanVien", nhanViens);
        model.addAttribute("title", "List Nhan Vien");
        return "nhansu/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
        return "nhansu/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listPhongBan", phongBanService.getAllPhongBan());
            return "nhansu/add";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhansu";
    }

/*    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") long id, Model model){
        book editBook = bookService.getBookById(id);
        if(editBook != null){
            model.addAttribute("book", editBook);
            return "book/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("book")book updateBook, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            return "book/edit";
        }
        bookService.getAllBook().stream()
                .filter(book -> book.getId() == updateBook.getId())
                .findFirst()
                .ifPresent(book -> {

                    bookService.updateBook(updateBook);
                });
        return "redirect:/books";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }*/
}
