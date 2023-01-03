package com.crecard;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.crecard.interfaces.ICustomerService;
import com.crecard.model.Customer;
import com.crecard.repository.ICustomerRepository;

class CustomerTestCase {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	List<Customer> list;
    ICustomerService serviceImpl;
    /*CustomerService customerservice;*/
    ICustomerRepository customerrepository;
    /*@Test
    public void testfindAllCustomers() {
        List<Customer> t=new ArrayList<Customer>(list);
        ICustomerRepository trMock=Mockito.mock(ICustomerRepository.class);
        serviceImpl.setCustomerRepository(trMock);
        Mockito.when(trMock.findAll()).thenReturn(list); //2
        List<Customer> actual= serviceImpl.getAllCustomers();
        assertTrue(t.equals(actual));
        Mockito.verify(trMock,Mockito.times(1)).findAll();
    }
    @Test
    public void testfindByUserId() {
       // List<Customer> b1=new ArrayList<Customer>(list);
        Customer customer = mock(Customer.class);
        Optional<Customer> b1 = Optional.of(customer);
        ICustomerRepository brMock=Mockito.mock(ICustomerRepository.class);
        serviceImpl.setCustomerRepository(brMock);
        Mockito.when(brMock.findById(102)).thenReturn(b1); //2
        Optional<Customer> actual= Optional.of(serviceImpl.getCustomer(102));
        assertTrue(b1.equals(actual));
        Mockito.verify(brMock,Mockito.times(1)).findById(102);
    }*/
    /*@BeforeEach
    public void DummyTestData() {
        list = new ArrayList<>();
        Customer c1 = new Customer();
        c1.setUserId("101");
        c1.setName("siri");
        c1.setEmail("siri@gmail.com");
        c1.setContactNo("9640948191");
        list.add(c1);

        Customer c2 = new Customer();
        c2.setUserId("102");
        c2.setName("raji");
        c2.setEmail("raji@gmail.com");
        c2.setContactNo("8074930665");
        list.add(c2);

        serviceImpl = new ICustomerService();
    }
    @Test
    public void testDeleteById(){
    //    List<Bill> b1=new ArrayList<Bill>(list);
    	ICustomerRepository brMock=Mockito.mock(ICustomerRepository.class);

        serviceImpl.setCustomerRepository(brMock);
        Mockito.when(brMock.existsById("101")).thenReturn(true);
        Mockito.doNothing().when(brMock).deleteById("101");
        String actual=serviceImpl.removeCustomer("101");
        assertEquals("Customer removed successfully.",actual);

        Mockito.verify(brMock,Mockito.times(1)).existsById(101);
        Mockito.verify(brMock,Mockito.times(1)).deleteByCustomerId(101);

    }*/

}
