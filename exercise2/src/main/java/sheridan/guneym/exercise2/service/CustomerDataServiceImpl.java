package sheridan.guneym.exercise2.service;

import org.springframework.stereotype.Service;
import sheridan.guneym.exercise2.model.CustomerForm;
import sheridan.guneym.exercise2.repository.CustomerDataRepository;
import sheridan.guneym.exercise2.repository.CustomerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerDataServiceImpl implements CustomerDataService {

    private final CustomerDataRepository customerDataRepository;

    CustomerDataServiceImpl(CustomerDataRepository customerDataRepository) {
        this.customerDataRepository = customerDataRepository;
    }

    private static void copyEntityToForm(CustomerEntity customer, CustomerForm form) {
        form.setCustomerId(customer.getCustomerId());
        form.setFirstName(customer.getFirstName());
        form.setLastName(customer.getLastName());
        form.setEmail(customer.getEmail());
        form.setStreet(customer.getStreet());
        form.setCity(customer.getCity());
        form.setState(customer.getState());
        form.setZipCode(customer.getZipCode());

    }

    public List<CustomerForm> getAllCustomerForms() {
        List<CustomerForm> formList = new ArrayList<>();
        List<CustomerEntity> customerList = customerDataRepository.findAll();
        for (CustomerEntity customer : customerList) {
            CustomerForm form = new CustomerForm();
            copyEntityToForm(customer, form);
            formList.add(form);
        }
        return formList;
    }

    public CustomerForm getCustomerForm(int customerId) {
        Optional<CustomerEntity> result = customerDataRepository.findById(customerId);
        if (result.isPresent()) {
            CustomerForm form = new CustomerForm();
            CustomerEntity customer = result.get();
            copyEntityToForm(customer, form);
            return form;
        }
        return null;

    }
}
