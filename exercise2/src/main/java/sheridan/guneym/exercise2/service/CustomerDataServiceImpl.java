package sheridan.guneym.exercise2.service;

import sheridan.guneym.exercise2.repository.CustomerDataRepository;
import sheridan.guneym.exercise2.repository.CustomerEntity;
import sheridan.guneym.exercise2.model.CustomerForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDataServiceImpl implements CustomerDataService {

    private final CustomerDataRepository customerDataRepository;

    CustomerDataServiceImpl(CustomerDataRepository customerDataRepository){
        this.customerDataRepository = customerDataRepository;
    }

    private static void copyFormToEntity(CustomerForm form, CustomerEntity customer){
        customer.setCustomerId(form.getCustomerId());
        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setEmail(form.getEmail());
        customer.setStreet(form.getStreet());
        customer.setCity(form.getCity());
        customer.setState(form.getState());
        customer.setZipCode(form.getZipCode());

    }

    private static void copyEntityToForm(CustomerEntity customer, CustomerForm form){
        form.setCustomerId(customer.getCustomerId());
        form.setFirstName(customer.getFirstName());
        form.setEmail(customer.getEmail());
        form.setStreet(customer.getStreet());
        form.setCity(customer.getCity());
        form.setState(customer.getState());
        form.setZipCode(customer.getZipCode());

    }
    public List<CustomerForm> getAllCustomerForms() {
        List<CustomerForm> formList = new ArrayList<>();
        List<CustomerEntity> customerList = customerDataRepository.findAll();
        for(CustomerEntity customer: customerList){
            CustomerForm form = new CustomerForm();
            copyEntityToForm(customer, form);
            formList.add(form);
        }
        return formList;
    }


}
