package sheridan.guneym.exercise2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import sheridan.guneym.exercise2.model.CustomerForm;
import sheridan.guneym.exercise2.service.CustomerDataService;

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

    @GetMapping("CustomerDetails/{customerId}")
    public String customerDetails(@PathVariable String customerId, Model model){
        logger.trace("customerDetails() is called");
           CustomerForm form = customerDataService.getCustomerForm(Integer.parseInt(customerId));
            if (form != null) {
                model.addAttribute("customer", form);
                return "CustomerDetails";
            } else {
                logger.trace("no data for this id=" + customerId);
                return "CustomerList";
            }

    }

}



