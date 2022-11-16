package peaksoft.model.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.model.Company;
import peaksoft.model.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/allCompanies")
    public String getAllCompanies(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "/allCompany";

    }
    @GetMapping("/savePageCompany")
    public String createCompany(Model model) {
        model.addAttribute("company", new Company());
        return "create_company";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("student") Company company) {
        companyService.saveCompany(company);
        return "redirect:/company/allCompanies";
    }
    @GetMapping("/update")
    public String updateCompany(@RequestParam("companyId") Long companyId, Model model) {
        model.addAttribute("company", companyService.getCompanyById(companyId));
        return "update_company";
    }

    @PostMapping("/update")
    public String updateCompany(@ModelAttribute("company") Company company) {
       companyService.updateCompany(company);
        return "redirect:/company/allCompanies";
    }
    @PostMapping("/removeCompany")
    private String removeCompany(@PathVariable Long id) {
        companyService.removeCompany(companyService.getCompanyById(id));
        return "redirect:/allCompanies";
    }
}
