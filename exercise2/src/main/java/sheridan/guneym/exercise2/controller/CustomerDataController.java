package sheridan.guneym.exercise2.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerDataController {

    private final Logger logger = LoggerFactory.getLogger(CustomerDataController.class);

    private final CustomerDataService customerDataService;

    public CustomerDataController(CustomerDataService customerDataService){
        this.customerDataService = customerDataService;
    }

    @GetMapping("/CustomerList")
    public ModelAndView customerList() {
        logger.trace("customerList() is called");
        List<CustomerForm> list = customerDataService.getAllCustomerForms();
        return new ModelAndView("CustomerList",
                "customers", list);
    }

    @GetMapping("CustomerDetails/{id}")
    public String customerDetails(@PathVariable String id, Model model){
        logger.trace("customerDetails() is called");
        try {
            CustomerForm form = customerDataService.getcustomerForm(Integer.parseInt(id));
            if (form != null) {
                model.addAttribute("customer", form);
                return "CustomerDetails";
            } else {
                logger.trace("no data for this id=" + id);
                return "DataNotFound";
            }
        } catch (NumberFormatException e) {
            logger.trace("the id is missing or not an integer");
            return "DataNotFound";
        }
    }

}



