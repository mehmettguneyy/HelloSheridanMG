package sheridan.guneym.exercise2.service;

import sheridan.guneym.exercise2.model.CustomerForm;

import java.util.List;

public interface CustomerDataService {

   List<CustomerForm> getAllCustomerForms();

   CustomerForm getCustomerForm(int customerId);
}
